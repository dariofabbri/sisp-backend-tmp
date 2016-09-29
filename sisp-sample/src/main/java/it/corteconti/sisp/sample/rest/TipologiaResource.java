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

@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "TipologiaResource")
public class TipologiaResource {
	
	@Autowired
	private TipologiaService tipologiaService;
	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}/tipologie", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione , idAmbito , idCategoria e idTipo.", response = TipologiaDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entita' tipologia indicata"), })
	public ResponseEntity<List<TipologiaDto>> getTipologieBySezioneAmbitoCategoriaTipo(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id categoria")
			@PathVariable("categoriaId") String categoriaId,			
			@ApiParam(value = "Specifica l'id tipo")
			@PathVariable("tipoId") String tipoId){

		List<TipologiaDto> listaTipologiaAmbito = tipologiaService.findTipologieBySezioneAndAmbitoAndCategoriaAndTipo(sezioneId, ambitoId, categoriaId, tipoId);
		return new ResponseEntity<List<TipologiaDto>>(listaTipologiaAmbito, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}/tipologie/{tipologiaId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione , idAmbito , idCategoria , idTipo e idTipologia.", response = TipologiaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entita' tipologia indicata"), })
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

		TipologiaDto tipologiaAmbito = tipologiaService.findTipologiaBySezioneAndAmbitoAndCategoriaAndTipoAndIdTipologia(sezioneId, ambitoId, categoriaId, tipoId, tipologiaId);
		return new ResponseEntity<TipologiaDto>(tipologiaAmbito, HttpStatus.OK);

	}

}