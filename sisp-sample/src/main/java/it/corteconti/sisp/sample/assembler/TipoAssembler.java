package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.TipoDto;
import it.corteconti.sisp.sample.model.Tipo;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Tipo</em>
 * @version 1.0
 */
public class TipoAssembler {
	
	
	/**
     * Costruttore privato, impedisce l'instanziazione
     */
	private TipoAssembler() {}
	
	
	
	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 * @param tipo	Entità <em>it.corteconti.sisp.sample.model.Tipo</em>
	 * @return 		<em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 */
	public static TipoDto assembleDto(Tipo tipo) {
		
		TipoDto tipoDto = new TipoDto();
		
		tipoDto.setIdTipo(tipo.getCodiceTipo());
		tipoDto.setDescrizioneTipo(tipo.getDescrizioneTipo());
		
		return tipoDto;
	}
	
	/**
	 * Ritorna un'entità <em>it.corteconti.sisp.sample.model.Tipo</em>
	 * @param dto	dto <em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 * @return		<em>it.corteconti.sisp.sample.model.Tipo</em>
	 */
	public static Tipo disassembleDto(TipoDto dto) {
		
		Tipo tipo = new Tipo();
		
		tipo.setCodiceTipo(dto.getIdTipo());
		tipo.setDescrizioneTipo(dto.getDescrizioneTipo());
		
		return tipo;
	}

}
