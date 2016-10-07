package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
	@Query("SELECT DISTINCT ctt.tipo FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito = :codiceAmbito AND ctt.categoria.codiceCategoria = :codiceCategoria AND ctt.codiceLivelloAoo = :codiceLivelloAoo ORDER BY ctt.tipo.ordineTipo ASC")
	public List<Tipo> findFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAoo(@Param("codiceAmbito") String codiceAmbito,
																						  @Param("codiceCategoria") String codiceCategoria,
																						  @Param("codiceLivelloAoo") String codiceLivelloAoo);
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Tipo</em>
	 * @param codiceAmbito		id dell'entità Ambito
	 * @param codiceCategoria	id dell'entità Categoria
	 * @param codiceLivelloAoo	livello AOO
	 * @param codiceTipo		id dell'entità Tipo
	 * @return 					<em>it.corteconti.sisp.sample.model.Tipo</em>
	 */
	@Query("SELECT DISTINCT ctt.tipo FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito = :codiceAmbito AND ctt.categoria.codiceCategoria = :codiceCategoria AND ctt.codiceLivelloAoo = :codiceLivelloAoo AND ctt.tipo.codiceTipo = :codiceTipo ORDER BY ctt.tipo.ordineTipo ASC")
	public Tipo getFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAooAndTipo(@Param("codiceAmbito") String codiceAmbito,
																						  @Param("codiceCategoria") String codiceCategoria,
																						  @Param("codiceLivelloAoo") String codiceLivelloAoo,
																						  @Param("codiceTipo") String codiceTipo);
}
