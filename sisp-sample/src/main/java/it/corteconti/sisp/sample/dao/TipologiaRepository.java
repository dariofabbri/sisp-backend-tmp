package it.corteconti.sisp.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corteconti.sisp.sample.model.Tipo;
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
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo = :codiceLivelloAoo AND ctt.ambito.codiceAmbito = :codiceAmbito AND ctt.categoria.codiceCategoria = :codiceCategoria AND ctt.tipo.codiceTipo = :codiceTipo ORDER BY ctt.tipologia.descrizioneTipologia ASC")
	public List<Tipologia> getTipologie(@Param("codiceLivelloAoo") 	String codiceLivelloAoo, 
										@Param("codiceAmbito")		String codiceAmbito, 
										@Param("codiceCategoria")	String codiceCategoria, 
										@Param("codiceTipo")		String codiceTipo);
	
	/**
	 * <p>Ritorna un oggetto <em>it.corteconti.sisp.sample.model.Tipologia</em> , dato livello AOO , codice ambito , codice categoria , codice tipo e codice tipologia.<p>
	 * @param codiceLivelloAoo		codice livello dell'entità Sezione
	 * @param codiceAmbito			id dell'entità Ambito
	 * @param codiceCategoria		id dell'entità Categoria
	 * @param codiceTipo			id dell'entità Tipo
	 * @param codiceTipologia 		id dell'entità Tipologia
	 * @return tipologia			<em>it.corteconti.sisp.sample.model.Tipologia</em>
	 */
	@Query("SELECT DISTINCT ctt.tipologia FROM CategoriaTipoTipologia ctt WHERE ctt.codiceLivelloAoo = :codiceLivelloAoo AND ctt.ambito.codiceAmbito = :codiceAmbito AND ctt.categoria.codiceCategoria = :codiceCategoria AND ctt.tipo.codiceTipo = :codiceTipo AND ctt.tipologia.codiceTipologia = :codiceTipologia ORDER BY ctt.tipologia.descrizioneTipologia ASC")
	public Tipologia getTipologia(	@Param("codiceLivelloAoo") 	String codiceLivelloAoo, 
									@Param("codiceAmbito")		String codiceAmbito, 
									@Param("codiceCategoria")	String codiceCategoria, 
									@Param("codiceTipo")		String codiceTipo, 
									@Param("codiceTipologia")	String codiceTipologia);

}
