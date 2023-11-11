package br.com.arthouseserv.arthouseserv.repositories;

import br.com.arthouseserv.arthouseserv.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
