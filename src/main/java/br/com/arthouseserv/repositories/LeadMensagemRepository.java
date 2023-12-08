package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.LeadMensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadMensagemRepository  extends JpaRepository<LeadMensagem, Integer> {
}
