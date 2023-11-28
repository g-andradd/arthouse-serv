package br.com.arthouseserv.arthouseserv.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente_lead")
public class Lead extends DefaultCriacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE_LEAD")
    private Integer idLead;

    @Column(name="NOME_CLIENTE_LEAD")
    private String nomeLead;


    @Column(insertable=false, updatable=false)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lead",orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    public Lead(Integer idLead, String nomeLead, List<Contato> contatos) {
        this.idLead = idLead;
        this.nomeLead = nomeLead;
        this.contatos = contatos;
    }

    public Lead() {
    }

    public Integer getIdLead() {
        return idLead;
    }

    public void setIdLead(Integer idLead) {
        this.idLead = idLead;
    }

    public String getNomeLead() {
        return nomeLead;
    }

    public void setNomeLead(String nomeLead) {
        this.nomeLead = nomeLead;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
