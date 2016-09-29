package it.corteconti.sisp.sample.rest;

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
	
	@Autowired
	private ThingService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce l'entità di tipo thing indicata.", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità thing indicata"), })
	public ResponseEntity<ThingDto> get(
			@ApiParam(value = "Specifica l'id dell'entità da ritornare")
			@PathVariable("id") Long id) {
		
		ThingDto thing = service.findOne(id);
		return new ResponseEntity<ThingDto>(thing, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/thing", method = RequestMethod.POST)
	@ApiOperation(value = "", notes = "Creazione entita' Thing", response = ThingDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = ""), })
	public ResponseEntity<Void> save(
			@ApiParam(value = "Oggetto Thing da creare")
			@RequestBody ThingDto thingDto,
			UriComponentsBuilder ucBuilder) {
		
		
		System.out.println(">>>>>>>>>>>>>>>  THING" + thingDto.getDescription());
		System.out.println(">>>>>>>>>>>>>>>  THING" + thingDto.getLastUpdate());
		thingDto.setId(new Long(3));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/giudizio-api/thing/{id}").buildAndExpand(thingDto.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
