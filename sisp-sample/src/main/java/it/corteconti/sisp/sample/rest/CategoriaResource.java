package it.corteconti.sisp.sample.rest;

import java.util.List;

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
import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.service.CategoriaService;

@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "CategoriaResource")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e idAmbito.", response = CategoriaDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entita' categorie indicata"), })
	public ResponseEntity<List<CategoriaDto>> getCategorie(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId){

		List<CategoriaDto> listaCategoriaAmbito = categoriaService.findCategorieBySezioneAndAmbito(sezioneId, ambitoId);
		return new ResponseEntity<List<CategoriaDto>>(listaCategoriaAmbito, HttpStatus.OK);

	}

}