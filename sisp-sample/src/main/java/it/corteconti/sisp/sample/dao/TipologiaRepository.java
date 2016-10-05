package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corteconti.sisp.sample.model.Tipologia;

/**
 * Repository Entità <em>it.corteconti.sisp.sample.model.Tipologia</em>
 * @version 1.0
 */
public interface TipologiaRepository extends CrudRepository<Tipologia, String> {
	
	/**
	 * <p>Ritorna una lista di oggetti <em>it.corteconti.sisp.sample.model.Tipologia</em> , dato livello AOO , codice ambito , codice categoria e codice tipo.<p>
	 * @param codiceLivelloAoo		codice livello dell'entità Sezione
	 * @param codiceAmbito			id dell'entità Ambito
	 * @param codiceCategoria		id dell'entità Categoria
	 * @param codiceTipo 			id dell'entità Tipo
	 * @return listaTipologie		<em>java.util.List<it.corteconti.sisp.sample.model.Tipologia></em>
	 */
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo=?1 AND ctt.ambito.codiceAmbito=?2 AND ctt.categoria.codiceCategoria=?3 AND ctt.tipo.codiceTipo=?4 ORDER BY ctt.tipologia.descrizioneTipologia ASC")
	public List<Tipologia> getTipologie(String codiceLivelloAoo, String codiceAmbito, String codiceCategoria, String codiceTipo);
	
	/**
	 * <p>Ritorna un oggetto <em>it.corteconti.sisp.sample.model.Tipologia</em> , dato livello AOO , codice ambito , codice categoria , codice tipo e codice tipologia.<p>
	 * @param codiceLivelloAoo		codice livello dell'entità Sezione
	 * @param codiceAmbito			id dell'entità Ambito
	 * @param codiceCategoria		id dell'entità Categoria
	 * @param codiceTipo			id dell'entità Tipo
	 * @param codiceTipologia 		id dell'entità Tipologia
	 * @return tipologia			<em>it.corteconti.sisp.sample.model.Tipologia</em>
	 */
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo=?1 AND ctt.ambito.codiceAmbito=?2 AND ctt.categoria.codiceCategoria=?3 AND ctt.tipo.codiceTipo=?4 AND ctt.tipologia.codiceTipologia=?5 ORDER BY ctt.tipologia.descrizioneTipologia ASC")
	public Tipologia getTipologia(String codiceLivelloAoo, String codiceAmbito, String codiceCategoria, String codiceTipo, String codiceTipologia);

}
