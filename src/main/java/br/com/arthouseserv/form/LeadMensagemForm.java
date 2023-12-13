package br.com.arthouseserv.form;

import br.com.arthouseserv.models.Lead;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class LeadMensagemForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String assunto;

    @NotBlank
    @Max(2000)
    private String mensagem;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Max(11)
    private String celular;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
