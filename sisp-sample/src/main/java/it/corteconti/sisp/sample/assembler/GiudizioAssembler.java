package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.model.Giudizio;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */
public class GiudizioAssembler {

	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 * @param tipo	Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
	 * @return 		<em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
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
