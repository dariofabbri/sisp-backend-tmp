package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.corteconti.sisp.sample.model.Oggetto;
/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Oggetto</em>
 * @version 1.0
 */
public interface OggettoRepository extends CrudRepository<Oggetto, Long> {
	
	/**
	 * <p>Cerca gli oggetti relativi ad una determinata sezione<p>
	 * @param sezioneId
	 * @return <em>java.util.List<it.corteconti.sisp.sample.model.Oggetto></em>
	 */
	@Query("SELECT DISTINCT o FROM Oggetto o WHERE o.sezione.id=?1")
	public List<Oggetto> findListOggettoByIdSezione(Long sezioneId);
	
	/**
	 * <p>Cerca l'oggetto di una determinata sezione per codice dell'oggetto<p>
	 * @param sezioneId
	 * @param idOggetto
	 * @return <em>it.corteconti.sisp.sample.model.Oggetto</em>
	 */
	@Query("SELECT DISTINCT o FROM Oggetto o WHERE o.sezione.id=?1 AND o.codiceOggetto=?2")
	public Oggetto findListOggettoByIdSezioneAndIdOggetto(Long sezioneId, Long idOggetto);

}
