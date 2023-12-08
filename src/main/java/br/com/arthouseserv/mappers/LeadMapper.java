package br.com.arthouseserv.mappers;

import br.com.arthouseserv.dto.ContatoDTO;
import br.com.arthouseserv.dto.LeadMensagemDTO;
import br.com.arthouseserv.form.LeadDescontoForm;
import br.com.arthouseserv.form.LeadMensagemForm;
import br.com.arthouseserv.models.Contato;
import br.com.arthouseserv.models.Lead;
import br.com.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.models.LeadMensagem;
import br.com.arthouseserv.models.builders.ContatoBuilder;
import br.com.arthouseserv.models.builders.LeadBuilder;
import br.com.arthouseserv.models.builders.LeadMensagemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.TimeZone;

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
                contatoMapper.toDTO(lead.getContato())
        );
    }

    public LeadMensagemDTO toLeadMensagemDTO(LeadMensagem leadMensagem) {
        return new LeadMensagemDTO(
                leadMensagem.getIdMensagem(),
                leadMensagem.getAssuntoMensagem(),
                leadMensagem.getTextoMensagem(),
                leadMensagem.getDataCriacao(),
                leadMensagem.getDataAlteracao(),
                this.toDTO(leadMensagem.getLead())
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
        lead.setContato(mapContatosDTOToEntities(leadDTO.contatos()));

        return lead;
    }

    private Contato mapContatosDTOToEntities(ContatoDTO contatoDTOs) {

        return contatoMapper.toEntity(contatoDTOs);


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

    public LeadMensagem mensagemFormToEntity(LeadMensagemForm leadMensagemForm) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
        Contato contato = new ContatoBuilder()
                .comEmail(leadMensagemForm.getEmail())
                .comCelular(leadMensagemForm.getCelular())
                .comDataHoraCriacao(LocalDateTime.now())
                .build();

        Lead lead = new LeadBuilder()
                .comNome(leadMensagemForm.getNome())
                .comContato(contato)
                .comDataHoraCriacao(LocalDateTime.now())
                .build();

        return new LeadMensagemBuilder()
                .comAssunto(leadMensagemForm.getAssunto())
                .comMensagem(leadMensagemForm.getMensagem())
                .comDataHoraCriacao(LocalDateTime.now())
                .comLead(lead)
                .build();
    }
}
