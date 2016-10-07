package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corteconti.sisp.sample.model.Categoria;

/**
 * Repository per Entità <em>it.corteconti.sisp.sample.model.Categoria</em>
 * @version 1.0
 */
public interface CategoriaRepository extends CrudRepository<Categoria, String> {
	
	/**
	 * Ritorna una lista di entità <em>it.corteconti.sisp.sample.model.Categoria</em>
	 * @param codiceAmbito		id dell'entità Ambito
	 * @param codiceLivelloAoo	livello AOO
	 * @return 					<em>java.util.List<it.corteconti.sisp.sample.model.Categoria></em>
	 */
	@Query("SELECT DISTINCT ctt.categoria FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito = :codiceAmbito AND ctt.codiceLivelloAoo = :codiceLivelloAoo ORDER BY ctt.categoria.ordineCategoria ASC")
	public List<Categoria> findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAoo(@Param("codiceAmbito") String codiceAmbito,
																				 @Param("codiceLivelloAoo") String codiceLivelloAoo);
	
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Categoria</em>
	 * @param codiceAmbito		id dell'entità Ambito
	 * @param codiceLivelloAoo	livello AOO
	 * @param categoriaId		id dell'entità Categoria
	 * @return 					<em>it.corteconti.sisp.sample.model.Categoria</em>
	 */
	@Query("SELECT DISTINCT ctt.categoria FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito = :codiceAmbito AND ctt.codiceLivelloAoo = :codiceLivelloAoo AND ctt.categoria.codiceCategoria = :codiceCategoria ORDER BY ctt.categoria.ordineCategoria ASC")
	public Categoria findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooAndIdCategoria(@Param("codiceAmbito") String codiceAmbito,
																						 @Param("codiceLivelloAoo") String codiceLivelloAoo,
																						 @Param("codiceCategoria") String codiceCategoria);
	
}
