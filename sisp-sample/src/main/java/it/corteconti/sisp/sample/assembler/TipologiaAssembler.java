package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.model.Tipologia;

public class TipologiaAssembler {

	public static TipologiaDto assembleDto(Tipologia tipologia) {
		TipologiaDto tipologiaDto = new TipologiaDto();
		
		tipologiaDto.setIdTipologia(tipologia.getCodiceTipologia());
		tipologiaDto.setDescrizioneTipologia(tipologia.getDescrizioneTipologia());
		
		return tipologiaDto;
	}


}
