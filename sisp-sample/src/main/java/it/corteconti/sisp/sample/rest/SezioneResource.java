package it.corteconti.sisp.sample.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.service.SezioneService;

/**
 * Rest Entità <em>it.corteconti.sisp.sample.model.Sezione</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Sezione")
public class SezioneResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(SezioneResource.class);
	
	@Autowired
	private SezioneService service;
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Sezione
	 * @param sezioneId		id dell'entità Sezione
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.SezioneDto</em>
	 */	
	@RequestMapping(value = "/sezioni/{sezioneId}", method = RequestMethod.GET)
	@ApiOperation(value = "Sezione", notes = "Dato idSezione, restituisce l'entità Sezione.", response = SezioneDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Sezione"),
	@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<SezioneDto> get(
			@ApiParam(value = "Specifica l'id sezione",required = true)
			@PathVariable("sezioneId") Long sezioneId) {
		
		LOG.debug("-- Sezione -> sezioneId: 	[" + sezioneId + "]");
		
		SezioneDto thing = service.findSezioniById(sezioneId);
		return new ResponseEntity<>(thing, HttpStatus.OK);
	}
}