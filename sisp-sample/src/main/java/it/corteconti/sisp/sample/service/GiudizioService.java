package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.GiudizioAssembler;
import it.corteconti.sisp.sample.dao.GiudizioRepository;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Giudizio;

@Service
public class GiudizioService {
	
	private static final Logger LOG = LoggerFactory.getLogger(GiudizioService.class);

	@Autowired
	private GiudizioRepository repository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public GiudizioDto findGiudizioById(Long id) {
		
		Giudizio giudizio = repository.findOne(id);
		LOG.debug(MessageFormat.format("Trovato il seguente giudizio: {0}", giudizio));
		
		if(giudizio == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Giudizio {0} not found.", id));
		}
		
		return GiudizioAssembler.assembleDto(giudizio);
	}
	
//	public ThingDto findOneFallback(Long id) {
//		
//		LOG.info("Circuit breaker: findOneFallback");
//		
//		throw new RuntimeException("Circuit breaker");
//	}
}
