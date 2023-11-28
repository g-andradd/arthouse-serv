package br.com.arthouseserv.arthouseserv.dto;

import java.time.LocalDateTime;
import java.util.List;

public record LeadDTO(Integer id, String nome, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAlteracao, List<ContatoDTO> contatos) {
}
