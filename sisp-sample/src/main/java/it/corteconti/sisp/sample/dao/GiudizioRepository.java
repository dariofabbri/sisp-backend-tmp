package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Giudizio;

public interface GiudizioRepository extends CrudRepository<Giudizio, Long> {
	
}
