package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	/**
	 * <p>Ritorna una lista di di oggetti Categoria<p>
	 * @param codiceAmbito
	 * @param codiceLivelloAoo
	 * @return listaCategorie
	 */
	
	@Query("SELECT DISTINCT ctt.categoria FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.codiceLivelloAoo=?2")
	public List<Categoria> findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAoo(String codiceAmbito, String codiceLivelloAoo);
	
	/**
	 * <p>Ritorna un oggetto di tipo Categoria, dato codice ambito, codice livello AOO e id categoria.<p>
	 * @param codiceAmbito
	 * @param codiceLivelloAoo
	 * @param categoriaId
	 * @return categoria
	 */
	
	@Query("SELECT DISTINCT ctt.categoria FROM CategoriaTipoTipologia ctt WHERE ctt.ambito.codiceAmbito=?1 AND ctt.codiceLivelloAoo=?2 AND ctt.categoria.codiceCategoria=?3")
	public Categoria findFromCategoriaTipoTipologiaByIdAmbitoAndLivelloAooAndIdCategoria(String codiceAmbito, String codiceLivelloAoo, String categoriaId);
	
}
