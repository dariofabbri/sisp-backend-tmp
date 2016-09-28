package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.model.Sezione;

public class SezioneAssembler {

	public static SezioneDto assembleDto(Sezione sezione) {
		
		SezioneDto dto = new SezioneDto();
		dto.setIdSezione(sezione.getId());
		dto.setDescrizioneSezione(sezione.getDescrizioneSezione());
		dto.setLivelloSezione(sezione.getLivello());
		
		return dto;
	}
}
