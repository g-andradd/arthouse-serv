package br.com.arthouseserv.arthouseserv.dto;

import java.time.LocalDateTime;

public record ContatoDTO(Long id, String email, String celular, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAlteracao) {
}
