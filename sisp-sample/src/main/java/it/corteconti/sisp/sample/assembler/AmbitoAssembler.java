package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.AmbitoDto;
import it.corteconti.sisp.sample.model.Ambito;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Ambito</em>
 * @version 1.0
 */
public class AmbitoAssembler {
	
	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.AmbitoDto</em>
	 * @param categoria	Entità <em>it.corteconti.sisp.sample.model.Ambito</em>
	 * @return 			<em>it.corteconti.sisp.sample.dto.AmbitoDto</em>
	 */
	public static AmbitoDto assembleDto(Ambito ambito) {
		AmbitoDto ambitoDto = new AmbitoDto();
		
		ambitoDto.setCodiceAmbito(ambito.getCodiceAmbito());
		ambitoDto.setDescrizioneAmbito(ambito.getDescrizioneAmbito());
		
		return ambitoDto;
	}


}
