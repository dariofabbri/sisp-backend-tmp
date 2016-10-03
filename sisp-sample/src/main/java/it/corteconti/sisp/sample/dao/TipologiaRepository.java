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
	 * <p>Ritorna una lista di oggetti Tipologia, dato livello AOO , codice ambito , codice categoria e codice tipo.<p>
	 * @param codiceLivelloAoo
	 * @param codiceAmbito
	 * @param codiceCategoria
	 * @param codiceTipo 
	 * @return listaTipologie
	 */
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo=?1 AND ctt.ambito.codiceAmbito=?2 AND ctt.categoria.codiceCategoria=?3 AND ctt.tipo.codiceTipo=?4 ")
	public List<Tipologia> getTipologie(String codiceLivelloAoo, String codiceAmbito, String codiceCategoria, String codiceTipo);
	
	
	
	/**
	 * <p>Ritorna un oggetto di tipo Tipologia, dato livello AOO , codice ambito , codice categoria , codice tipo e codice tipologia.<p>
	 * @param codiceLivelloAoo
	 * @param codiceAmbito
	 * @param codiceCategoria
	 * @param codiceTipo
	 * @param codiceTipologia 
	 * @return tipologia
	 */
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo=?1 AND ctt.ambito.codiceAmbito=?2 AND ctt.categoria.codiceCategoria=?3 AND ctt.tipo.codiceTipo=?4 AND ctt.tipologia.codiceTipologia=?5")
	public Tipologia getTipologia(String codiceLivelloAoo, String codiceAmbito, String codiceCategoria, String codiceTipo, String codiceTipologia);

}
