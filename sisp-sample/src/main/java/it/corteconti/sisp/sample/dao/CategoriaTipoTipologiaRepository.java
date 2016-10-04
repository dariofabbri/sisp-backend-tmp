package it.corteconti.sisp.sample.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;

public interface CategoriaTipoTipologiaRepository extends CrudRepository<CategoriaTipoTipologia, Long> {
	
	
	@Query("SELECT COUNT(ctt) FROM CategoriaTipoTipologia ctt WHERE ctt.tipo.codiceTipo=?1 AND ctt.categoria.codiceCategoria=?2 "
			+ "AND ctt.ambito.codiceAmbito=?3 AND ctt.codiceLivelloAoo=?4")
	public Integer countByTipoAndCategoriaAndAmbitoAndLivelloAoo(String idTipo, String idCategoria, String idAmbito, String livelloAoo);
	
	@Query("SELECT COUNT(ctt) FROM CategoriaTipoTipologia ctt WHERE ctt.tipo.codiceTipo=?1 AND ctt.categoria.codiceCategoria=?2 "
			+ "AND ctt.ambito.codiceAmbito=?3 AND ctt.tipologia.codiceTipologia=?4 AND ctt.codiceLivelloAoo=?5")
	public Integer countByTipoAndCategoriaAndAmbitoAndTipologiaAndLivelloAoo(String idTipo, String idCategoria, String idAmbito, String idTipologia, String livelloAoo);
	
}
