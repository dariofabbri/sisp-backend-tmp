package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.SezioneAssembler;
import it.corteconti.sisp.sample.dao.SezioneRepository;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Sezione;

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Sezione</em> 
 * @version 1.0
 */
@Service
public class SezioneService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SezioneService.class);

	@Autowired
	private SezioneRepository repository;
	
	/**
	 * <p>Ritorna un dto <em>it.corteconti.sisp.sample.dto.SezioneDto</em></p>
	 * @param idSezione		id dell'entità Sezione
	 * @return				<em>it.corteconti.sisp.sample.dto.SezioneDto</em>
	 */
	public SezioneDto findSezioniById(Long id) {
		
		// -- Recupero entità Sezione a fronte dell'id			
		Sezione sezione = repository.findOne(id);
		
		// -- Verifica valorizzazione oggetto
		if(sezione == null) {
			// logging	
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Sezione {0} not found.", id));
		}
		
		// logging	
		LOG.debug(MessageFormat.format("Trovata la seguente sezione: {0}", sezione));
		
		// -- Assembler, Sezione -> SezioneDto		
		return SezioneAssembler.assembleDto(sezione);
	}
}
