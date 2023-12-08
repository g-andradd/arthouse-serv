package br.com.arthouseserv.services.lead;

import br.com.arthouseserv.dto.LeadMensagemDTO;
import br.com.arthouseserv.form.LeadMensagemForm;
import br.com.arthouseserv.mappers.LeadMapper;
import br.com.arthouseserv.models.LeadMensagem;
import br.com.arthouseserv.repositories.LeadMensagemRepository;
import br.com.arthouseserv.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadMensagemService {
    private final LeadMensagemRepository leadMensagemRepository;
    private final LeadMapper leadMapper;

    @Autowired
    public LeadMensagemService(LeadMensagemRepository leadMensagemRepository, LeadMapper leadMapper) {
        this.leadMensagemRepository = leadMensagemRepository;
        this.leadMapper = leadMapper;
    }

    public LeadMensagemDTO createLeadMensagem(LeadMensagemForm leadMensagemForm) {
        LeadMensagem leadMensagem = leadMapper.mensagemFormToEntity(leadMensagemForm);
        return leadMapper.toLeadMensagemDTO(leadMensagemRepository.save(leadMensagem));
    }
}
