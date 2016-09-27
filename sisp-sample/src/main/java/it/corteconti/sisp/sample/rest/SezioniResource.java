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
import it.corteconti.sisp.sample.dto.CategoriaArrayDto;
import it.corteconti.sisp.sample.dto.SezioniDto;
import it.corteconti.sisp.sample.service.CategoriaTipoTipologiaService;
import it.corteconti.sisp.sample.service.SezioniService;

@RestController
@RequestMapping(
		value = "/giudizio-api/sezioni",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Risorsa di esempio: sezione")
public class SezioniResource {
	
	@Autowired
	private SezioniService service;

	@RequestMapping(value = "/{sezioneId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce l'entità di tipo sezione indicata.", response = SezioniDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità sezione indicata"), })
	public ResponseEntity<SezioniDto> get(
			@ApiParam(value = "Specifica l'id dell'entità da ritornare")
			@PathVariable("sezioneId") Long id) {
		
		SezioniDto thing = service.findOne(id);
		return new ResponseEntity<SezioniDto>(thing, HttpStatus.OK);
	}

}
