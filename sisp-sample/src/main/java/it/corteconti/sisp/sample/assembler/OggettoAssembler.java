package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.OggettoDto;
import it.corteconti.sisp.sample.model.Oggetto;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Oggetto</em>
 * @version 1.0
 */
public class OggettoAssembler {
	
	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.OggettoDto</em>
	 * @param tipo	Entità <em>it.corteconti.sisp.sample.model.Oggetto</em>
	 * @return 		<em>it.corteconti.sisp.sample.dto.OggettoDto</em>
	 */
	public static OggettoDto assembleDto(Oggetto oggetto) {
		OggettoDto oggettoDto = null;
		
		if(oggetto!=null){
			
			oggettoDto = new OggettoDto();
			oggettoDto.setIdOggetto(oggetto.getCodiceOggetto());
			oggettoDto.setDescrizioneOggetto(oggetto.getDescrizioneOggetto());
			
		}
		
		return oggettoDto;
	}

}
