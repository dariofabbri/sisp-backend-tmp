package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.ThingAssembler;
import it.corteconti.sisp.sample.dao.ThingRepository;
import it.corteconti.sisp.sample.dto.ThingDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Thing;

@Service
public class ThingService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThingService.class);

	@Autowired
	private ThingRepository repository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public ThingDto findOne(Long id) {
		
		Thing thing = repository.findOne(id);
		LOG.debug(MessageFormat.format("Trovato il seguente thing: {0}", thing));
		
		if(thing == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Thing {0} not found.", id));
		}
		
		return ThingAssembler.assembleDto(thing);
	}
	
	public void save(ThingDto thingDto) {
		
		if (thingDto == null) {
			throw new ResourceNotFoundException(
					MessageFormat.format("Non è possibile salvare l'oggetto {0}", Thing.class.getName() ));
		}
		
		Thing thing = repository.save(ThingAssembler.disassembleDto(thingDto));
		thingDto.setId(thing.getId());
	}
	
//	public ThingDto findOneFallback(Long id) {
//		
//		LOG.info("Circuit breaker: findOneFallback");
//		
//		throw new RuntimeException("Circuit breaker");
//	}
}
