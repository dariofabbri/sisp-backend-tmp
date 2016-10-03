package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Ambito;
import it.corteconti.sisp.sample.model.Tipologia;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Ambito</em>
 * @version 1.0
 */

public interface AmbitoRepository extends CrudRepository<Ambito, String> {
	
}
