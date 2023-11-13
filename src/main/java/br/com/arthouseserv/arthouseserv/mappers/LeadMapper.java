package br.com.arthouseserv.arthouseserv.mappers;

import br.com.arthouseserv.arthouseserv.dto.ContatoDTO;
import br.com.arthouseserv.arthouseserv.form.LeadDescontoForm;
import br.com.arthouseserv.arthouseserv.models.Contato;
import br.com.arthouseserv.arthouseserv.models.Lead;
import br.com.arthouseserv.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.arthouseserv.models.builders.ContatoBuilder;
import br.com.arthouseserv.arthouseserv.models.builders.LeadBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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
                lead.getId(),
                lead.getNome(),
                lead.getDataHoraCriacao(),
                lead.getDataHoraAlteracao(),
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
        lead.setId(leadDTO.id());
        lead.setNome(leadDTO.nome());
        lead.setDataHoraCriacao(leadDTO.dataHoraCriacao());
        lead.setDataHoraAlteracao(LocalDateTime.now());
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
