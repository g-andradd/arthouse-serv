package br.com.arthouseserv.mappers;

import br.com.arthouseserv.dto.ContatoDTO;
import br.com.arthouseserv.form.LeadDescontoForm;
import br.com.arthouseserv.models.Contato;
import br.com.arthouseserv.models.Lead;
import br.com.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.models.builders.ContatoBuilder;
import br.com.arthouseserv.models.builders.LeadBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Component
public class LeadMapper {

    private final ContatoMapper contatoMapper;

    @Autowired
    public LeadMapper(ContatoMapper contatoMapper) {
        this.contatoMapper = contatoMapper;
    }

    public LeadDTO toDTO(Lead lead) {
        return new LeadDTO(
                lead.getIdLead(),
                lead.getNomeLead(),
                lead.getDataCriacao(),
                lead.getDataAlteracao(),
                lead.getContatos().stream()
                        .map(contatoMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    public Lead toEntity(LeadDTO leadDTO) {
        return new LeadBuilder()
                .comId(leadDTO.id())
                .comNome(leadDTO.nome())
                .comDataHoraCriacao(leadDTO.dataHoraCriacao())
                .comDataHoraAlteracao(leadDTO.dataHoraAlteracao())
                .comContatos(mapContatosDTOToEntities(leadDTO.contatos()))
                .build();
    }

    public Lead toUpdatedEntity(Lead lead, LeadDTO leadDTO) {
        lead.setIdLead(leadDTO.id());
        lead.setNomeLead(leadDTO.nome());
        lead.setDataCriacao(leadDTO.dataHoraCriacao());
        lead.setDataAlteracao(LocalDateTime.now());
        lead.setContatos(mapContatosDTOToEntities(leadDTO.contatos()));

        return lead;
    }

    private List<Contato> mapContatosDTOToEntities(List<ContatoDTO> contatoDTOs) {
        if (contatoDTOs != null) {
            return contatoDTOs.stream()
                    .map(contatoMapper::toEntity)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public Lead descontoFormToEntity(LeadDescontoForm leadDescontoForm) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
        Contato contato = new ContatoBuilder()
                .comEmail(leadDescontoForm.getEmail())
                .comCelular(leadDescontoForm.getCelular())
                .comDataHoraCriacao(LocalDateTime.now())
                .build();

        return new LeadBuilder()
                .comContato(contato)
                .comDataHoraCriacao(LocalDateTime.now())
                .build();
    }
}
