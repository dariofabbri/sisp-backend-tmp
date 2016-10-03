package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Contatore;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Contatore</em>
 * @version 1.0
 */
public interface ContatoreRepository extends CrudRepository<Contatore, Long> {
	
	
	//public List<Contatore> find
	
}
