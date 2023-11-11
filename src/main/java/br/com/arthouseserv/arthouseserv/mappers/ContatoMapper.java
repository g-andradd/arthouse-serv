package br.com.arthouseserv.arthouseserv.mappers;

import br.com.arthouseserv.arthouseserv.models.Contato;
import br.com.arthouseserv.arthouseserv.models.builders.ContatoBuilder;
import br.com.arthouseserv.arthouseserv.dto.ContatoDTO;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public ContatoDTO toDTO(Contato contato) {
        return new ContatoDTO(
                contato.getId(),
                contato.getEmail(),
                contato.getCelular(),
                contato.getDataHoraCriacao(),
                contato.getDataHoraAlteracao()
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
