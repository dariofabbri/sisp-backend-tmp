package it.corteconti.sisp.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Rest Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Giudizio")
public class GiudizioResource {
	
	@Autowired
	private GiudizioService service;
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Giudizio
	 * @param idGiudizio id dell'entità Giudizio
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */	
	@RequestMapping(value = "/giudizi/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idGiudizio, restituisce l'entità Giudizio.", response = GiudizioDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Giudizio"), })
	public ResponseEntity<GiudizioDto> getGiudizio(
			@ApiParam(value = "Specifica l'id dell'entità da ritornare")
			@PathVariable("id") Long idGiudizio) {
		
		GiudizioDto giudizio = service.getGiudizio(idGiudizio);
		return new ResponseEntity<GiudizioDto>(giudizio, HttpStatus.OK);
	}
	
	
	/**
	 * Crea un'entità Giudizio
	 * @param giudizioDto l'oggetto dto da creare
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	@RequestMapping(value = "/giudizio", method = RequestMethod.POST)
	@ApiOperation(value = "", notes = "Creazione entità Giudizio", response = GiudizioDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità creata"), })
	public ResponseEntity<GiudizioDto> save(
			@ApiParam(value = "Oggetto Giudizio da creare")
			@RequestBody GiudizioDto giudizioDto) {
		
		//LOG.debug("-- Thing -> description: [" + thingDto.getDescription() + "]");
		//LOG.debug("-- Thing -> last update: [" + thingDto.getLastUpdate() + "]");
		
		service.save(giudizioDto);
		return new ResponseEntity<GiudizioDto>(giudizioDto, HttpStatus.OK);
	}
	
	
}
