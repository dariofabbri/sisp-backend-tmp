package it.corteconti.sisp.sample.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Rest Entità <em>it.corteconti.sisp.sample.model.Tipologia</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Tipologia")
public class TipologiaResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(TipologiaResource.class);
	
	@Autowired
	private TipologiaService tipologiaService;
	
	/**
	 * Ritorna una stringa JSON che rappresenta una lista di oggetti Tipologia
	 * @param sezioneId		id dell'entità Sezione
	 * @param ambitoId		id dell'entità Ambito
	 * @param categoriaId	id dell'entità Categoria
	 * @param tipoId 		id dell'entità Tipo
	 * @return Response HTTP, stringa JSON che rappresenta una lista di dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 */	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}/tipologie", method = RequestMethod.GET)
	@ApiOperation(value = "Tipologie", 
	notes = "Dato idSezione, idAmbito, idCategoria, idTipo, restituisce una lista di entità Tipologia.", 
	response = TipologiaDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista entità Tipologia"),
	@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<List<TipologiaDto>> getTipologie(
			@ApiParam(value = "Specifica l'id sezione",required = true)
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito",required = true)
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id categoria",required = true)
			@PathVariable("categoriaId") String categoriaId,			
			@ApiParam(value = "Specifica l'id tipo",required = true)
			@PathVariable("tipoId") String tipoId){
		
		LOG.debug("-- Tipologia -> sezioneId:  [" + sezioneId + "]");
		LOG.debug("-- Tipologia -> ambitoId:   [" + ambitoId + "]");
		LOG.debug("-- Tipologia -> categoriaId:[" + categoriaId + "]");
		LOG.debug("-- Tipologia -> tipoId:     [" + tipoId + "]");

		List<TipologiaDto> listaTipologia = tipologiaService.getTipologie(
				sezioneId, 
				ambitoId, 
				categoriaId, 
				tipoId);
		return new ResponseEntity<>(listaTipologia, HttpStatus.OK);

	}
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Tipologia
	 * @param sezioneId		id dell'entità Sezione
	 * @param ambitoId		id dell'entità Ambito
	 * @param categoriaId	id dell'entità Categoria
	 * @param tipoId		id dell'entità Tipo
	 * @param tipologiaId 	id dell'entità Tipologia
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 */	
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}/tipologie/{tipologiaId}", 
			method = RequestMethod.GET)
	@ApiOperation(value = "Tipologia", 
		notes = "Dato idSezione, idAmbito, idCategoria, idTipo, idTipologia, restituisce l'entità Tipologia.", 
		response = TipologiaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Tipologia"),
	@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<TipologiaDto> getTipologia(
			@ApiParam(value = "Specifica l'id sezione",required = true)
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito",required = true)
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id categoria",required = true)
			@PathVariable("categoriaId") String categoriaId,
			@ApiParam(value = "Specifica l'id tipo",required = true)
			@PathVariable("tipoId") String tipoId,			
			@ApiParam(value = "Specifica l'id tipologia",required = true)
			@PathVariable("tipologiaId") String tipologiaId) {
		
		LOG.debug("-- Tipologia -> sezioneId:  [" + sezioneId + "]");
		LOG.debug("-- Tipologia -> ambitoId:   [" + ambitoId + "]");
		LOG.debug("-- Tipologia -> categoriaId:[" + categoriaId + "]");
		LOG.debug("-- Tipologia -> tipoId:     [" + tipoId + "]");
		LOG.debug("-- Tipologia -> tipologiaId:[" + tipologiaId + "]");

		TipologiaDto tipologia = tipologiaService.getTipologia(sezioneId, ambitoId, categoriaId, tipoId, tipologiaId);
		return new ResponseEntity<>(tipologia, HttpStatus.OK);
	}
}