package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Ambito;
import it.corteconti.sisp.sample.model.Giudizio;

public interface AmbitoRepository extends CrudRepository<Ambito, Long> {
	
}
