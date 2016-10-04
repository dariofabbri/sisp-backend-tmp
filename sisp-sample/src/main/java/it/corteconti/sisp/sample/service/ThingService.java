package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.ThingAssembler;
import it.corteconti.sisp.sample.dao.ThingRepository;
import it.corteconti.sisp.sample.dto.ThingDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Thing;

@Service
@Transactional
public class ThingService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThingService.class);

	@Autowired
	private ThingRepository repository;
	
	/**
	 * Richiamato dalla GET
	 * @param id
	 * @return
	 */
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public ThingDto findOne(Long id) {
		
		Thing thing = this.repository.findOne(id);
		LOG.debug(MessageFormat.format("Trovato il seguente thing: {0}", thing));
		
		if(thing == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Thing {0} not found.", id));
		}
		
		return ThingAssembler.assembleDto(thing);
	}
	
	/**
	 * Richiamato dalla POST
	 * @param thingDto
	 */
	public ThingDto save(ThingDto thingDto) {
		
		if (thingDto == null) {
			throw new ResourceNotFoundException(
					MessageFormat.format("Non è possibile salvare l'oggetto {0}", Thing.class.getName() ));
		}
		
		Thing thing = this.repository.save(ThingAssembler.disassembleDto(thingDto));
		thingDto.setId(thing.getId());
		
		return thingDto;
	}
	
	/**
	 * Richiamato dalla PUT
	 * @param thingDto
	 */
	public ThingDto update(ThingDto thingDto) {
		
		if (thingDto == null || thingDto.getId() == null) {
			throw new ResourceNotFoundException(
					MessageFormat.format("Thing {0} uneditable, not found", thingDto.getId() ));
		}
		
		Thing tmp = ThingAssembler.disassembleDto(thingDto);
		// -- Recupero entità
		Thing thingDb = this.repository.findOne(tmp.getId());
		
		// -- Update
		if (tmp.getDescription() != null && !tmp.getDescription().equals(""))
			thingDb.setDescription(tmp.getDescription());
		if (tmp.getLastUpdate() != null)
			thingDb.setLastUpdate(tmp.getLastUpdate());
		
		return ThingAssembler.assembleDto(thingDb);
	}
	
	/**
	 * Richiamato dalla DELETE
	 * @param thingDto
	 */
	public ThingDto delete(Long id) {
		
		// -- Recupero entità
		Thing thingDb = this.repository.findOne(id);
		if (thingDb == null || thingDb.getId() == null) {
			throw new ResourceNotFoundException(
					MessageFormat.format("Thing {0} uneditable, not found", id ));
		}
		// -- Delete
		this.repository.delete(thingDb);
		return ThingAssembler.assembleDto(thingDb);
	}
	/**
	 * service per il HTTP method patch
	 * @param id
	 * @param description
	 * @return
	 */

	public ThingDto patchThingForDescription(Long id, String description) {
		
		Thing thingDb = this.repository.findOne(id);
		thingDb.setDescription(description);
		
		return ThingAssembler.assembleDto(thingDb);
		
	}
	
     
	
	
//	public ThingDto findOneFallback(Long id) {
//		
//		LOG.info("Circuit breaker: findOneFallback");
//		
//		throw new RuntimeException("Circuit breaker");
//	}
}
