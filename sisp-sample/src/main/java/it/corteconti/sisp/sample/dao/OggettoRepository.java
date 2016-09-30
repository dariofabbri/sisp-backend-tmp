package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.corteconti.sisp.sample.model.Oggetto;

public interface OggettoRepository extends CrudRepository<Oggetto, Long> {
	/**
	 * Cerca gli oggetti relativi ad una determinata sezione
	 * @param sezioneId
	 * @return listaOggetti
	 */
	@Query("SELECT DISTINCT o FROM Oggetto o WHERE o.sezione.id=?1")
	public List<Oggetto> findListOggettoByIdSezione(Long sezioneId);
	
	/**
	 * cerca l'oggetto di una determinata sezione per codice dell'oggetto
	 * @param sezioneId
	 * @param idOggetto
	 * @return
	 */
	@Query("SELECT DISTINCT o FROM Oggetto o WHERE o.sezione.id=?1 AND o.codiceOggetto=?2")
	public Oggetto findListOggettoByIdSezioneAndIdOggetto(Long sezioneId, Long idOggetto);

}
