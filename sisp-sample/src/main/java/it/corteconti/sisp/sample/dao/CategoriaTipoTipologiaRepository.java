package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Categoria;
import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;
import it.corteconti.sisp.sample.model.Giudizio;

public interface CategoriaTipoTipologiaRepository extends CrudRepository<CategoriaTipoTipologia, Long> {
	
}
