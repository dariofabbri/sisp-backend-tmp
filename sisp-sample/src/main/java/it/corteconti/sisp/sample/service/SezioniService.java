package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.SezioniAssembler;
import it.corteconti.sisp.sample.dao.SezioniRepository;
import it.corteconti.sisp.sample.dto.SezioniDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Sezioni;

@Service
public class SezioniService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SezioniService.class);

	@Autowired
	private SezioniRepository repository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public SezioniDto findOne(Long id) {
		
		Sezioni sezione = repository.findOne(id);
		LOG.debug(MessageFormat.format("Trovata la seguente sezione: {0}", sezione));
		
		if(sezione == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Sezione {0} not found.", id));
		}
		
		return SezioniAssembler.assembleDto(sezione);
	}
}
