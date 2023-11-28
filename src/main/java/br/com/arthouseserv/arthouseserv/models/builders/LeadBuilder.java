package br.com.arthouseserv.arthouseserv.models.builders;

import br.com.arthouseserv.arthouseserv.models.Contato;
import br.com.arthouseserv.arthouseserv.models.Lead;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeadBuilder {

    private Integer  id;
    private String nome;

    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private List<Contato> contatos = new ArrayList<>();

    public LeadBuilder comId(Integer id) {
        this.id = id;
        return this;
    }
    public LeadBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LeadBuilder comDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
        return this;
    }

    public LeadBuilder comDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
        return this;
    }

    public LeadBuilder comContatos(List<Contato> contatos) {
        this.contatos = contatos;
        return this;
    }

    public LeadBuilder comContato(Contato contato) {
        this.contatos.add(contato);
        return this;
    }

    public Lead build() {
        Lead lead = new Lead();
        lead.setIdLead(this.id);
        lead.setNomeLead(this.nome);
        lead.setDataCriacao(this.dataHoraCriacao);
        lead.setDataAlteracao(this.dataHoraAlteracao);
        lead.setContatos(this.contatos);
        return lead;
    }
}
