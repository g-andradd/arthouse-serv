package br.com.arthouseserv.models.builders;

import br.com.arthouseserv.models.Lead;
import br.com.arthouseserv.models.LeadMensagem;

import java.time.LocalDateTime;

public class LeadMensagemBuilder {

    private Integer id;
    private String assunto;
    private String mensagem;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private Lead lead;

    public LeadMensagemBuilder comId(Integer id) {
        this.id = id;
        return this;
    }

    public LeadMensagemBuilder comAssunto(String assunto) {
        this.assunto = assunto;
        return this;
    }

    public LeadMensagemBuilder comMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public LeadMensagemBuilder comDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
        return this;
    }

    public LeadMensagemBuilder comDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
        return this;
    }

    public LeadMensagemBuilder comLead(Lead lead) {
        this.lead = lead;
        return this;
    }

    public LeadMensagem build() {
        LeadMensagem leadMensagem = new LeadMensagem();
        leadMensagem.setIdMensagem(this.id);
        leadMensagem.setAssuntoMensagem(this.assunto);
        leadMensagem.setTextoMensagem(this.mensagem);
        leadMensagem.setDataAlteracao(this.dataHoraAlteracao);
        leadMensagem.setDataCriacao(this.dataHoraCriacao);
        leadMensagem.setLead(this.lead);
        return leadMensagem;
    }

}
