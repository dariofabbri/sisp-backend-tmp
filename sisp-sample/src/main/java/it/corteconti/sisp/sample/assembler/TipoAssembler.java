package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.TipoDto;
import it.corteconti.sisp.sample.model.Tipo;

public class TipoAssembler {

	public static TipoDto assembleDto(Tipo tipo) {
		TipoDto tipoDto = new TipoDto();
		
		tipoDto.setIdTipo(tipo.getCodiceTipo());
		tipoDto.setDescrizioneTipo(tipo.getDescrizioneTipo());
		
		return tipoDto;
	}


}
