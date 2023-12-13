package br.com.arthouseserv.services.lead;

import br.com.arthouseserv.dto.ContatoDTO;
import br.com.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.dto.LeadMensagemDTO;
import br.com.arthouseserv.form.LeadMensagemForm;
import br.com.arthouseserv.mappers.ContatoMapper;
import br.com.arthouseserv.models.Contato;
import br.com.arthouseserv.models.Lead;
import br.com.arthouseserv.models.LeadMensagem;
import br.com.arthouseserv.repositories.ContatoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeadContatoService {

    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    public LeadContatoService (ContatoRepository contatoRepository, ContatoMapper contatoMapper) {
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
    }

    @Transactional
    public Contato createContato(String email, String celular) {
        Contato contato = contatoMapper.FormToEntity(email, celular);
        contatoRepository.save(contato);
        return contato;
    }

}
