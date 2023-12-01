package br.com.arthouseserv.models.builders;

import br.com.arthouseserv.models.Contato;

import java.time.LocalDateTime;

public class ContatoBuilder {

    private Integer id;
    private String email;
    private String celular;
    private LocalDateTime dataHoraAlteracao;
    private LocalDateTime dataHoraCriacao;

    public ContatoBuilder comId(Integer id) {
        this.id = id;
        return this;
    }

    public ContatoBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public ContatoBuilder comCelular(String celular) {
        this.celular = celular;
        return this;
    }

    public ContatoBuilder comDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
        return this;
    }

    public ContatoBuilder comDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
        return this;
    }

    public Contato build() {
        Contato contato = new Contato();
        contato.setIdContatoLead(this.id);
        contato.setEmailLead(this.email);
        contato.setCelularLead(this.celular);
        contato.setDataAlteracao(this.dataHoraAlteracao);
        contato.setDataCriacao(this.dataHoraCriacao);
        return contato;
    }

}
