package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contato_cliente_lead")
public class Contato extends  DefaultCriacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO_CLIENTE_LEAD")
    private Integer idContatoLead;

    @Column(name = "EMAIL_CLIENTE_LEAD")
    private String emailLead;

    @Column(name = "CELULAR_CLIENTE_LEAD")
    private String celularLead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE_LEAD")
    private Lead lead;

    public Contato () {
    }

    public Contato(Integer idContatoLead, String emailLead, String celularLead, Lead lead) {
        this.idContatoLead = idContatoLead;
        this.emailLead = emailLead;
        this.celularLead = celularLead;
        this.lead = lead;
    }

    public Integer getIdContatoLead() {
        return idContatoLead;
    }

    public void setIdContatoLead(Integer idContatoLead) {
        this.idContatoLead = idContatoLead;
    }

    public String getEmailLead() {
        return emailLead;
    }

    public void setEmailLead(String emailLead) {
        this.emailLead = emailLead;
    }

    public String getCelularLead() {
        return celularLead;
    }

    public void setCelularLead(String celularLead) {
        this.celularLead = celularLead;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }
}
