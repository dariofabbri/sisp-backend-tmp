package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Tipo;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Tipo</em>
 * @version 1.0
 */
public interface TipoRepository extends CrudRepository<Tipo, String> {
	
	/**
	 * Ritorna una lista di entità <em>it.corteconti.sisp.sample.model.Tipo</em>
	 * @param codiceAmbito		id dell'entità Ambito
	 * @param codiceCategoria	id dell'entità Categoria
	 * @param codiceLivelloAoo	livello AOO
	 * @return 					<em>java.util.List<it.corteconti.sisp.sample.model.Tipo></em>
	 */
	@Query("SELECT DISTINCT ctt.tipo FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.categoria.codiceCategoria=?2 AND ctt.codiceLivelloAoo=?3 ORDER BY ctt.tipo.ordineTipo ASC")
	public List<Tipo> findFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAoo(String codiceAmbito, String codiceCategoria, String codiceLivelloAoo);
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Tipo</em>
	 * @param codiceAmbito		id dell'entità Ambito
	 * @param codiceCategoria	id dell'entità Categoria
	 * @param codiceLivelloAoo	livello AOO
	 * @param codiceTipo		id dell'entità Tipo
	 * @return 					<em>it.corteconti.sisp.sample.model.Tipo</em>
	 */
	@Query("SELECT DISTINCT ctt.tipo FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.categoria.codiceCategoria=?2 AND ctt.codiceLivelloAoo=?3 AND ctt.tipo.codiceTipo=?4 ORDER BY ctt.tipo.ordineTipo ASC")
	public Tipo getFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAooAndTipo(String codiceAmbito, String codiceCategoria, String codiceLivelloAoo, String codiceTipo);
}
