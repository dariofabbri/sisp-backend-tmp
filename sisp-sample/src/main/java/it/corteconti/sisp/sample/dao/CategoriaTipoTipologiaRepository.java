package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;

public interface CategoriaTipoTipologiaRepository extends CrudRepository<CategoriaTipoTipologia, Long> {
	
	
	@Query("FROM CategoriaTipoTipologia ctt LEFT JOIN FETCH ctt.categoria c LEFT JOIN FETCH ctt.ambito a WHERE a.codiceAmbito=?1 AND ctt.codiceLivelloAoo=?2")
	public List<CategoriaTipoTipologia> findByIdAmbitoAndLivelloAoo(String idAmbito, String livelloAoo);
	
}
