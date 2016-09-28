package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Tipologia;

public interface TipologiaRepository extends CrudRepository<Tipologia, Long> {
	
}
