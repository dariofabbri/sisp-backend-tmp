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
	
	
	/**
	 * <p>Ritorna una stringa JSON rapprenseta una lista di categorie<p>
	 * @param sezioneId
	 * @param ambitoId
	 * @return Response HTTP, JSON listaCategorie
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e idAmbito ritorna una lista di categorie.", response = CategoriaDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entita' categorie indicata"), })
	public ResponseEntity<List<CategoriaDto>> getCategorie(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId){

		List<CategoriaDto> listaCategoriaAmbito = categoriaService.findCategorieBySezioneAndAmbito(sezioneId, ambitoId);
		return new ResponseEntity<List<CategoriaDto>>(listaCategoriaAmbito, HttpStatus.OK);
	}

	/**
	 * <p>Ritorna una stringa JSON rappresentante una categoria<p>
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @return Response HTTP, JSON categoria
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e idAmbito e idCategoria ritorna la categoria selezionata.", response = CategoriaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità categoria indicata"), })
	public ResponseEntity<CategoriaDto> getCategoria(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id della categoria")
			@PathVariable("categoriaId") String categoriaId){


		CategoriaDto categoriaDto =  categoriaService.findByCategorieBySezioneAndAmbitoAndCategoria(sezioneId, ambitoId, categoriaId);
		return new ResponseEntity<CategoriaDto>(categoriaDto, HttpStatus.OK);
	}
}