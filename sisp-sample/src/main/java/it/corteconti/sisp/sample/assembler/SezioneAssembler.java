package it.corteconti.sisp.sample.assembler;

import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.model.Sezione;

/**
 * Assembler Entità <em>it.corteconti.sisp.sample.model.Sezione</em>
 * @version 1.0
 */
public class SezioneAssembler {
	
	private SezioneAssembler(){
		
	}

	/**
	 * Ritorna un dto <em>it.corteconti.sisp.sample.dto.SezioneDto</em>
	 * @param sezione	Entità <em>it.corteconti.sisp.sample.model.Sezione</em>
	 * @return 			<em>it.corteconti.sisp.sample.dto.SezioneDto</em>
	 */
	public static SezioneDto assembleDto(Sezione sezione) {
		
		SezioneDto dto = new SezioneDto();
		dto.setIdSezione(sezione.getId());
		dto.setDescrizioneSezione(sezione.getDescrizioneSezione());
		dto.setLivelloSezione(sezione.getLivello());
		
		return dto;
	}
}
