package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Tipologia;

public interface TipologiaRepository extends CrudRepository<Tipologia, Long> {
	
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo=?1 AND ctt.ambito.codiceAmbito=?2 AND ctt.categoria.codiceCategoria=?3 AND ctt.tipo.codiceTipo=?4 ")
	public List<Tipologia> findFromTipologiaByLivelloAooAndIdAmbitoAndIdCategoriaAndIdTipo(String codiceLivelloAoo, String codiceAmbito, String codiceCategoria, String codiceTipo);
	
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo=?1 AND ctt.ambito.codiceAmbito=?2 AND ctt.categoria.codiceCategoria=?3 AND ctt.tipo.codiceTipo=?4 AND ctt.tipologia.codiceTipologia=?5")
	public Tipologia findFromTipologiaByLivelloAooAndIdAmbitoAndIdCategoriaAndIdTipoAndIdTipologia(String codiceLivelloAoo, String codiceAmbito, String codiceCategoria, String codiceTipo, String codiceTipologia);

}
