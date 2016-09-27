package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.model.Giudizio;

public class GiudizioAssembler {

	public static GiudizioDto assembleDto(Giudizio giudizio) {
		
		GiudizioDto dto = new GiudizioDto();
		dto.setId(giudizio.getId());
		dto.setDescrizione(giudizio.getDescrizione());
		dto.setDataApertura(giudizio.getDataApertura());
		dto.setNote(giudizio.getNote());
		dto.setNumero(giudizio.getNumero());
		
		return dto;
	}
}
