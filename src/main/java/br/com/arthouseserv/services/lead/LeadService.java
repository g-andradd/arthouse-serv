package br.com.arthouseserv.services.lead;

import br.com.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.mappers.LeadMapper;
import br.com.arthouseserv.models.Contato;
import br.com.arthouseserv.models.Lead;
import br.com.arthouseserv.repositories.LeadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final LeadContatoService contatoService;
    private final LeadMapper leadMapper;

    public LeadService(LeadRepository leadRepository, LeadMapper leadMapper, LeadContatoService contatoService) {
        this.leadRepository = leadRepository;
        this.contatoService = contatoService;
        this.leadMapper = leadMapper;
    }

    public List<LeadDTO> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        return leads.stream()
                .map(leadMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LeadDTO> getLeadById(Long id) {
        Optional<Lead> lead = leadRepository.findById(id);
        return lead.map(leadMapper::toDTO);
    }

    @Transactional
    public LeadDTO createLead(String nome, String email, String celular) {
        Contato contato = contatoService.createContato(email, celular);
        Lead lead = leadMapper.FormToEntity(nome, contato);
        return leadMapper.toDTO(leadRepository.save(lead));
    }

    @Transactional
    public LeadDTO updateLead(Long id, LeadDTO leadDTO) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead não encontrado!"));
        Lead atualizado = leadMapper.toUpdatedEntity(lead, leadDTO);
        return leadMapper.toDTO(leadRepository.save(atualizado));
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}
