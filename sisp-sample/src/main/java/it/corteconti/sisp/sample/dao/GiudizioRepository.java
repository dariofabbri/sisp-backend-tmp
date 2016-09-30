package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Giudizio;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */

public interface GiudizioRepository extends CrudRepository<Giudizio, Long> {
	
}
