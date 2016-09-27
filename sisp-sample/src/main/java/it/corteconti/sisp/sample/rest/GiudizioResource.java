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
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.service.GiudizioService;

@RestController
@RequestMapping(
		value = "/giudizio-api/giudizi",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Risorsa di esempio: giudizio")
public class GiudizioResource {
	
	@Autowired
	private GiudizioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce l'entità di tipo giudizio indicata.", response = GiudizioDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità giudizio indicata"), })
	public ResponseEntity<GiudizioDto> get(
			@ApiParam(value = "Specifica l'id dell'entità da ritornare")
			@PathVariable("id") Long id) {
		
		GiudizioDto thing = service.findOne(id);
		return new ResponseEntity<GiudizioDto>(thing, HttpStatus.OK);
	}
	
	

}
