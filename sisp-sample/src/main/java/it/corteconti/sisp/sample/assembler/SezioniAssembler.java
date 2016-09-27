package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.SezioniDto;
import it.corteconti.sisp.sample.model.Sezioni;

public class SezioniAssembler {

	public static SezioniDto assembleDto(Sezioni sezione) {
		
		SezioniDto dto = new SezioniDto();
		dto.setIdSezione(sezione.getId());
		dto.setDescrizioneSezione(sezione.getDescrizioneSezione());
		dto.setLivelloSezione(sezione.getLivello());
		
		return dto;
	}
}
