package br.com.arthouseserv.arthouseserv.dto;

import java.time.LocalDateTime;
import java.util.List;

public record LeadDTO(Long id, String nome, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAlteracao, List<ContatoDTO> contatos) {
}
