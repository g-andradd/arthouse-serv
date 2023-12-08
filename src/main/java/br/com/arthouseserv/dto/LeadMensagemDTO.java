package br.com.arthouseserv.dto;

import java.time.LocalDateTime;

public record LeadMensagemDTO (Integer idMensagem, String assuntoMensagem, String textoMensagem, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAlteracao, LeadDTO lead) {
}
