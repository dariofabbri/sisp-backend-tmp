package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Ambito;

public interface AmbitoRepository extends CrudRepository<Ambito, Long> {
	
}
