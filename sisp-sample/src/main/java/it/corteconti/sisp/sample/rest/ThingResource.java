package it.corteconti.sisp.sample.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.corteconti.sisp.sample.dto.ThingDto;
import it.corteconti.sisp.sample.service.ThingService;

@RestController
@RequestMapping(
		value = "/api/v1/things",//giudizio-api
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Risorsa di esempio: thing")
public class ThingResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThingResource.class);
	
	@Autowired
	private ThingService service;
	
	/**
	 * GET example
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce l'entità di tipo thing indicata.", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità thing indicata"), })
	public ResponseEntity<ThingDto> get(
			@ApiParam(value = "Specifica l'id dell'entità da ritornare")
			@PathVariable("id") Long id) {
		
		ThingDto thing = service.findOne(id);
		return new ResponseEntity<>(thing, HttpStatus.OK);
	}
	
	/**
	 * POST example
	 * @param thingDto
	 * @return
	 */
	@RequestMapping(value = "/thing", method = RequestMethod.POST)
	@ApiOperation(value = "", notes = "Creazione entità Thing", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità creata"), })
	public ResponseEntity<ThingDto> save(
			@ApiParam(value = "Oggetto Thing da creare")
			@RequestBody ThingDto thingDto,
			UriComponentsBuilder ucBuilder) {
		
		LOG.debug("-- Thing -> description: [" + thingDto.getDescription() + "]");
		LOG.debug("-- Thing -> last update: [" + thingDto.getLastUpdate() + "]");
		
		ThingDto dto = service.save(thingDto);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/v1/things/thing/{id}").buildAndExpand(dto.getId()).toUri());
		return new ResponseEntity<>(dto, headers, HttpStatus.CREATED);
	}
	
	/**
	 * PUT example
	 * @param thingDto
	 * @return
	 */
	@RequestMapping(value = "/thing/update", method = RequestMethod.PUT)
	@ApiOperation(value = "", notes = "Modifica entità Thing", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità modificata"), })
	public ResponseEntity<ThingDto> update(
			@ApiParam(value = "Oggetto Thing da modificare")
			@RequestBody ThingDto thingDto) {
		
		LOG.debug("-- Thing -> id: [" + thingDto.getId() + "]");
		LOG.debug("-- Thing -> description: [" + thingDto.getDescription() + "]");
		LOG.debug("-- Thing -> last update: [" + thingDto.getLastUpdate() + "]");
		
		ThingDto dto = service.update(thingDto);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	/**
	 * PATCH example
	 * @param thingDto
	 * @return
	 */
	@RequestMapping(value = "/thing/patch/{id}", method = RequestMethod.PATCH)
	@ApiOperation(value = "", notes = "Modifica entità Thing", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità modificata"), })
	public ResponseEntity<ThingDto> patchThingForDescription(
			@ApiParam(value = "description")
			@RequestBody ThingDto thingDto,
			@ApiParam(value = "id")
			@PathVariable("id") Long id) {
		
		
		LOG.debug("-- Thing -> description: [" + thingDto.getDescription() + "]");
		LOG.debug("-- Thing -> id: [" + id + "]");
		
		ThingDto result = service.patchThingForDescription(id,thingDto.getDescription());
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * DELETE example
	 * @param thingDto
	 * @return
	 */
	@RequestMapping(value = "/thing/delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "", notes = "Cancellazione entità Thing", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità cancellata"), })
	public ResponseEntity<ThingDto> delete(
			@ApiParam(value = "Oggetto Thing da cancellare")
			@PathVariable("id") long id) {
		
		LOG.debug("-- Thing -> id: [" + id + "]");	
		
		service.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}