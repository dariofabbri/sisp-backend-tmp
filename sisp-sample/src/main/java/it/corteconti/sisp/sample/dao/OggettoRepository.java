package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corteconti.sisp.sample.model.Oggetto;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Oggetto</em>
 * @version 1.0
 */
public interface OggettoRepository extends CrudRepository<Oggetto, Long> {
	
	
	/**
	 * <p>Cerca gli oggetti relativi ad una determinata sezione<p>
	 * @param sezioneId	id dell'entità Sezione
	 * @return 			<em>java.util.List<it.corteconti.sisp.sample.model.Oggetto></em>
	 */
	@Query("SELECT DISTINCT o FROM Oggetto o WHERE o.sezione.id = :sezioneId")
	public List<Oggetto> findListOggettoByIdSezione(@Param("sezioneId") Long sezioneId);
	
	
	/**
	 * <p>Cerca l'oggetto di una determinata sezione per codice dell'oggetto<p>
	 * @param sezioneId	id dell'entità Sezione
	 * @param oggettoId	id dell'entità Oggetto
	 * @return 			<em>it.corteconti.sisp.sample.model.Oggetto</em>
	 */
	@Query("SELECT DISTINCT o FROM Oggetto o WHERE o.sezione.id = :sezioneId AND o.codiceOggetto = :oggettoId")
	public Oggetto findOggettoByIdSezioneAndIdOggetto(@Param("sezioneId") Long sezioneId,
													  @Param("oggettoId") Long oggettoId);

}
