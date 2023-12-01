package br.com.arthouseserv.models;

import jakarta.persistence.Column;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class DefaultCriacao {
    @Column(name = "ID_USUARIO_CRIACAO")
    private Long idUsuarioCriacao;
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;
    @Column(name = "ID_USUARIO_ALTERACAO")
    private Long idUsuarioAlteracao;
    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;


    public Long getIdUsuarioCriacao() {
        return idUsuarioCriacao;
    }

    public void setIdUsuarioCriacao(Long idUsuarioCriacao) {
        this.idUsuarioCriacao = idUsuarioCriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getIdUsuarioAlteracao() {
        return idUsuarioAlteracao;
    }

    public void setIdUsuarioAlteracao(Long idUsuarioAlteracao) {
        this.idUsuarioAlteracao = idUsuarioAlteracao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
