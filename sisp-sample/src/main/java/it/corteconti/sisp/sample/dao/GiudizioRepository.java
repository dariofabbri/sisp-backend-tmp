package it.corteconti.sisp.sample.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Giudizio;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */
public interface GiudizioRepository extends CrudRepository<Giudizio, Long> {
	
	/**
	 * Ritorna un oggetto <em>it.corteconti.sisp.sample.model.Giudizio</em>
	 * @param numero		contatore
	 * @param idTipo		id dell'entità Tipo
	 * @param idCategoria	id dell'entità Categoria
	 * @return				<em>it.corteconti.sisp.sample.model.Giudizio</em>
	 */
	@Query("FROM Giudizio g WHERE g.numero = ?1 AND g.tipo.codiceTipo = ?2 AND g.categoria.codiceCategoria = ?3")
	public Giudizio getByNumeroAndTipoAndCategoria(Long numero, String idTipo, String idCategoria);
	
}
