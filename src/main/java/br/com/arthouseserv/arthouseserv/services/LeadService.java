package br.com.arthouseserv.arthouseserv.services;

import br.com.arthouseserv.arthouseserv.form.LeadDescontoForm;
import br.com.arthouseserv.arthouseserv.mappers.LeadMapper;
import br.com.arthouseserv.arthouseserv.models.Contato;
import br.com.arthouseserv.arthouseserv.models.Lead;
import br.com.arthouseserv.arthouseserv.dto.LeadDTO;
import br.com.arthouseserv.arthouseserv.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper;

    @Autowired
    public LeadService(LeadRepository leadRepository, LeadMapper leadMapper) {
        this.leadRepository = leadRepository;
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
    public LeadDTO createLead(LeadDescontoForm leadDescontoForm) {
        Lead lead = leadMapper.descontoFormToEntity(leadDescontoForm);
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
