package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	@Query("SELECT DISTINCT ctt.categoria FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.codiceLivelloAoo=?2")
	public List<Categoria> findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAoo(String codiceAmbito, String codiceLivelloAoo);
	
}
