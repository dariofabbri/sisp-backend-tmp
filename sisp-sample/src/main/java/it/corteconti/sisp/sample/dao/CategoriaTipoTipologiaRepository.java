package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;

public interface CategoriaTipoTipologiaRepository extends CrudRepository<CategoriaTipoTipologia, Long> {
	
	
	@Query("FROM CategoriaTipoTipologia ctt JOIN FETCH ctt.categoria c, JOIN FETCH ctt.ambito WHERE ctt.ambito.codiceAmbito=?1 AND ctt.codiceLivelloAoo=?2")
	public List<CategoriaTipoTipologia> findByIdAmbitoAndLivelloAoo(String idAmbito, String livelloAoo);
	
}
