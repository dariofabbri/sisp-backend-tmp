package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
}
