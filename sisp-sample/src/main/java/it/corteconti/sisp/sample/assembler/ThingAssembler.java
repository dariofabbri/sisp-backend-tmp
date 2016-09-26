package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.ThingDto;
import it.corteconti.sisp.sample.model.Thing;

public class ThingAssembler {

	public static ThingDto assembleDto(Thing thing) {
		
//		ThingDto dto = new ThingDto(
//				thing.getId(),
//				thing.getDescription(),
//				thing.getLastUpdate());
		
		ThingDto dto = new ThingDto();
		dto.setId(thing.getId());
		dto.setDescription(thing.getDescription());
		dto.setLastUpdate(thing.getLastUpdate());
		
		return dto;
	}
}
