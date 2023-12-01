package br.com.arthouseserv.mappers;

import br.com.arthouseserv.models.Contato;
import br.com.arthouseserv.models.builders.ContatoBuilder;
import br.com.arthouseserv.dto.ContatoDTO;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public ContatoDTO toDTO(Contato contato) {
        return new ContatoDTO(
                contato.getIdContatoLead(),
                contato.getEmailLead(),
                contato.getCelularLead(),
                contato.getDataCriacao(),
                contato.getDataAlteracao()
        );
    }

    public Contato toEntity(ContatoDTO contatoDTO) {
        return new ContatoBuilder()
                .comId(contatoDTO.id())
                .comEmail(contatoDTO.email())
                .comCelular(contatoDTO.celular())
                .comDataHoraCriacao(contatoDTO.dataHoraCriacao())
                .comDataHoraAlteracao(contatoDTO.dataHoraAlteracao())
                .build();
    }
}
