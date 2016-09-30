package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.OggettoDto;
import it.corteconti.sisp.sample.model.Oggetto;

public class OggettoAssembler {
/**
 * <p>Assembla un OggettoDto dato per parametro un Oggetto <p>
 * @param oggetto
 * @return oggettoDto
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
