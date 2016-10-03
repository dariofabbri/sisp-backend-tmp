package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Ambito;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Ambito</em>
 * @version 1.0
 */

public interface AmbitoRepository extends CrudRepository<Ambito, String> {
	
}
