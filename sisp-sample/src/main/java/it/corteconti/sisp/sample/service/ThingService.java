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
import it.corteconti.sisp.util.ValidationUtil;

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Thing</em> 
 * @version 1.0
 */
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
		
		this.controlloEsistenzaEntita(thing, String.valueOf(id));

		LOG.debug(MessageFormat.format("Trovato il seguente thing: {0}", thing));
		
		return ThingAssembler.assembleDto(thing);
	}
	
	/**
	 * Richiamato dalla POST
	 * @param thingDto
	 */
	public ThingDto save(ThingDto thingDto) {
		
		Thing thing = this.repository.save(ThingAssembler.disassembleDto(thingDto));
		thingDto.setId(thing.getId());
		
		return thingDto;
	}
	
	/**
	 * Richiamato dalla PUT
	 * @param thingDto
	 */
	public ThingDto update(ThingDto thingDto) {
		
		Thing tmp = ThingAssembler.disassembleDto(thingDto);
		// -- Recupero entità
		Thing thingDb = this.repository.findOne(tmp.getId());
		
		// -- controllo esistenza entità
		this.controlloEsistenzaEntita(thingDb, String.valueOf(thingDto.getId()));
		
		// -- Update
		String description = !ValidationUtil.isBlankOrNull(tmp.getDescription()) ? tmp.getDescription() : thingDb.getDescription() ;
		thingDb.setDescription(description);
		java.util.Date lastUpdate = !ValidationUtil.isNull(tmp.getLastUpdate()) ? tmp.getLastUpdate() : thingDb.getLastUpdate() ;
		thingDb.setLastUpdate(lastUpdate);
		
		return ThingAssembler.assembleDto(thingDb);
	}
	
	/**
	 * Richiamato dalla DELETE
	 * @param thingDto
	 */
	public ThingDto delete(Long id) {
		
		// -- Recupero entità
		Thing thingDb = this.repository.findOne(id);
		this.controlloEsistenzaEntita(thingDb, String.valueOf(id));
		
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
		
		// -- controllo esistenza entità
		this.controlloEsistenzaEntita(thingDb, String.valueOf(id));
		
		thingDb.setDescription(description);
		
		return ThingAssembler.assembleDto(thingDb);
		
	}
	
    public void controlloEsistenzaEntita(Object obj,String id){
		if(ValidationUtil.isNull(obj)) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Thing {0} not found.", id));
		}
    }
    
}
