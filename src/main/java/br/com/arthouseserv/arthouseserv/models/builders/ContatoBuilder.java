package br.com.arthouseserv.arthouseserv.models.builders;

import br.com.arthouseserv.arthouseserv.models.Contato;

import java.time.LocalDateTime;

public class ContatoBuilder {

    private Long id;
    private String email;
    private String celular;
    private LocalDateTime dataHoraAlteracao;
    private LocalDateTime dataHoraCriacao;

    public ContatoBuilder comId(Long id) {
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
        contato.setId(this.id);
        contato.setEmail(this.email);
        contato.setCelular(this.celular);
        contato.setDataHoraAlteracao(this.dataHoraAlteracao);
        contato.setDataHoraCriacao(this.dataHoraCriacao);
        return contato;
    }

}
