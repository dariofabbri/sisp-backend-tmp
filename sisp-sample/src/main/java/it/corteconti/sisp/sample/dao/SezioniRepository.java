package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;
import it.corteconti.sisp.sample.model.Sezioni;

public interface SezioniRepository extends CrudRepository<Sezioni, Long> {
	
}
