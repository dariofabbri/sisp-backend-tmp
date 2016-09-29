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
import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.service.TipologiaService;

/**
 * Rest Entit� <em>it.corteconti.sisp.sample.model.Tipologia</em>
 * @version 1.0
 */

@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Risorsa di esempio: tipologia")
public class TipologiaResource {
	
	@Autowired
	private TipologiaService tipologiaService;
	
	/**
	 * Ritorna una stringa JSON che rappresenta una lista di oggetti Tipologia
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @param tipoId 
	 * @return Response HTTP, stringa JSON che rappresenta una lista di dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 */	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}/tipologie", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce le entità di tipologia in base a : idSezione , idAmbito , idCategoria e idTipo.", response = TipologiaDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità tipologia indicata"), })
	public ResponseEntity<List<TipologiaDto>> getTipologieBySezioneAmbitoCategoriaTipo(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id categoria")
			@PathVariable("categoriaId") String categoriaId,			
			@ApiParam(value = "Specifica l'id tipo")
			@PathVariable("tipoId") String tipoId){

		List<TipologiaDto> listaTipologia = tipologiaService.findTipologieBySezioneAndAmbitoAndCategoriaAndTipo(sezioneId, ambitoId, categoriaId, tipoId);
		return new ResponseEntity<List<TipologiaDto>>(listaTipologia, HttpStatus.OK);

	}
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Tipologia
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @param tipoId
	 * @param tipologiaId 
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 */	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}/tipologie/{tipologiaId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce l'entità di tipologia in base a : idSezione , idAmbito , idCategoria , idTipo e idTipologia.", response = TipologiaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità tipologia indicata"), })
	public ResponseEntity<TipologiaDto> getTipologiaBySezioneAmbitoCategoriaTipoIdTipologia(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id categoria")
			@PathVariable("categoriaId") String categoriaId,
			@ApiParam(value = "Specifica l'id tipo")
			@PathVariable("tipoId") String tipoId,			
			@ApiParam(value = "Specifica l'id tipologia")
			@PathVariable("tipologiaId") String tipologiaId){

		TipologiaDto tipologia = tipologiaService.findTipologiaBySezioneAndAmbitoAndCategoriaAndTipoAndIdTipologia(sezioneId, ambitoId, categoriaId, tipoId, tipologiaId);
		return new ResponseEntity<TipologiaDto>(tipologia, HttpStatus.OK);

	}

}