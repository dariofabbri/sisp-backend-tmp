package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.model.Tipologia;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Tipologia</em>
 * @version 1.0
 */
public class TipologiaAssembler {

	/**
     * Costruttore privato, impedisce l'instanziazione
     */
	private TipologiaAssembler(){
	}
	
	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 * @param tipologia	Entità <em>it.corteconti.sisp.sample.model.Tipologia</em>
	 * @return 			<em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 */
	public static TipologiaDto assembleDto(Tipologia tipologia) {
		
		TipologiaDto tipologiaDto = new TipologiaDto();
		
		tipologiaDto.setIdTipologia(tipologia.getCodiceTipologia());
		tipologiaDto.setDescrizioneTipologia(tipologia.getDescrizioneTipologia());
		
		return tipologiaDto;
	}
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Tipologia</em>
	 * @param dto	dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 * @return		<em>it.corteconti.sisp.sample.model.Tipologia</em>
	 */
	public static Tipologia disassembleDto(TipologiaDto dto) {
		
		Tipologia tipologia = new Tipologia();
		
		tipologia.setCodiceTipologia(dto.getIdTipologia());
		tipologia.setDescrizioneTipologia(dto.getDescrizioneTipologia());
		
		return tipologia;
	}
	
	
}
