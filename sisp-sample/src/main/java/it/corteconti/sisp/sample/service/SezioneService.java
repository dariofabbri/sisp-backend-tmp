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

@Service
public class SezioneService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SezioneService.class);

	@Autowired
	private SezioneRepository repository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public SezioneDto findSezioniById(Long id) {
		
		Sezione sezione = repository.findOne(id);
		LOG.debug(MessageFormat.format("Trovata la seguente sezione: {0}", sezione));
		
		if(sezione == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Sezione {0} not found.", id));
		}
		
		return SezioneAssembler.assembleDto(sezione);
	}
}
