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

/**
 * Rest Entit� <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */

@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "giudizioResource")
public class GiudizioResource {
	
	@Autowired
	private GiudizioService service;
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Giudizio
	 * @param id
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */	
	@RequestMapping(value = "/giudizi/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idGiudizio, restituisce l'entita'�Giudizio.", response = GiudizioDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entita'�Giudizio indicata"), })
	public ResponseEntity<GiudizioDto> get(
			@ApiParam(value = "Specifica l'id dell'entita'�da ritornare")
			@PathVariable("id") Long id) {
		
		GiudizioDto thing = service.findGiudizioById(id);
		return new ResponseEntity<GiudizioDto>(thing, HttpStatus.OK);
	}
	
	

}
