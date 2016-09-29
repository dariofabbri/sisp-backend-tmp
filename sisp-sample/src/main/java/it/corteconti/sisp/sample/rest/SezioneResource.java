package it.corteconti.sisp.sample.rest;

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

@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "SezioneResource")
public class SezioneResource {
	
	@Autowired
	private SezioneService service;
	
	@RequestMapping(value = "/sezioni/{sezioneId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione, restituisce l'entita' Sezione.", response = SezioneDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entita' Sezione indicata"), })
	public ResponseEntity<SezioneDto> get(
			@ApiParam(value = "Specifica l'id dell'entita' da ritornare")
			@PathVariable("sezioneId") Long id) {
		
		SezioneDto thing = service.findSezioniById(id);
		return new ResponseEntity<SezioneDto>(thing, HttpStatus.OK);
	}
	
	

}
