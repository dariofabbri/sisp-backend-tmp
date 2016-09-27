package it.corteconti.sisp.sample.rest;

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

@RestController
@RequestMapping(
		value = "/giudizio-api/sezioni",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Categoria")
public class CategorieResource {
	
	@RequestMapping(value = "/{sezioneId}/ambiti/{ambitoId}/categorie", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e idAmbito   .", response = SezioniDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità sezione indicata"), })
	public ResponseEntity<CategoriaArrayDto> getCategorie(
			@ApiParam(value = "Specifica l'id della sezione")
			@PathVariable("sezioneId") Long id,
			@ApiParam(value = "Specifica l'id di ambito")
			@PathVariable("ambitoId") Long ambitoId){
		
		CategoriaArrayDto categoriaAmbitoArray = null ;	//TODO da implementare 
		return new ResponseEntity<CategoriaArrayDto>(categoriaAmbitoArray, HttpStatus.OK);
	}

}