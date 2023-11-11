package br.com.arthouseserv.arthouseserv.repositories;

import br.com.arthouseserv.arthouseserv.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
