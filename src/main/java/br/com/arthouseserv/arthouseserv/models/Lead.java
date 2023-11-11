package br.com.arthouseserv.arthouseserv.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private Long id;

    @Column(length=150)
    private String nome;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    public Lead() {
        this.dataHoraCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
