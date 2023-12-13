package br.com.arthouseserv.services.lead;

import br.com.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.dto.LeadMensagemDTO;
import br.com.arthouseserv.form.LeadMensagemForm;
import br.com.arthouseserv.mappers.LeadMapper;
import br.com.arthouseserv.models.Lead;
import br.com.arthouseserv.models.LeadMensagem;
import br.com.arthouseserv.repositories.LeadMensagemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeadMensagemService {
    private final LeadMensagemRepository leadMensagemRepository;
    private final LeadService leadService;
    private final LeadMapper leadMapper;

    public LeadMensagemService(LeadMensagemRepository leadMensagemRepository, LeadService leadService, LeadMapper leadMapper) {
        this.leadMensagemRepository = leadMensagemRepository;
        this.leadService = leadService;
        this.leadMapper = leadMapper;
    }

    @Transactional
    public LeadMensagemDTO createLeadMensagem(LeadMensagemForm leadMensagemForm) {
        LeadDTO leadDTO = leadService.createLead(leadMensagemForm.getNome(), leadMensagemForm.getEmail(), leadMensagemForm.getCelular());
        Lead lead = leadMapper.toEntity(leadDTO);
        LeadMensagem leadMensagem = leadMapper.mensagemFormToEntity(leadMensagemForm.getAssunto(), leadMensagemForm.getMensagem(), lead);
        return leadMapper.toLeadMensagemDTO(leadMensagemRepository.save(leadMensagem));
    }
}
