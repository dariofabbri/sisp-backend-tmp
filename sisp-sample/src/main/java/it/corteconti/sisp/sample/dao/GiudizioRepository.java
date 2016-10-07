package it.corteconti.sisp.sample.dao;

import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Giudizio;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */
public interface GiudizioRepository extends CrudRepository<Giudizio, Long> {
	
	
	/**
	 * Ritorna un oggetto <em>it.corteconti.sisp.sample.model.Giudizio</em>
	 * @param idSezione		id dell'entità Sezione
	 * @param numero		contatore
	 * @param idTipo		id dell'entità Tipo
	 * @param idCategoria	id dell'entità Categoria
	 * @return				<em>it.corteconti.sisp.sample.model.Giudizio</em>
	 */
	public Giudizio findByIdSezioneAndNumeroAndTipoCodiceTipoAndCategoriaCodiceCategoria(Long idSezione, Long numero, String idTipo, String idCategoria);
	
}
