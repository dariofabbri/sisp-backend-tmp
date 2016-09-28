package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
	
	@Query("SELECT DISTINCT ctt.tipo FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.categoria.codiceCategoria=?2 AND ctt.codiceLivelloAoo=?3")
	public List<Tipo> findFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAoo(String codiceAmbito, String codiceCategoria, String codiceLivelloAoo);
	
	@Query("SELECT DISTINCT ctt.tipo FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.categoria.codiceCategoria=?2 AND ctt.codiceLivelloAoo=?3 AND ctt.tipo.codiceTipo=?4")
	public Tipo getFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAooAndTipo(String codiceAmbito, String codiceCategoria, String codiceLivelloAoo, String codiceTipo);
}
