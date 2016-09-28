package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
	
}
