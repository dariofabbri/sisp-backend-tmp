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
import it.corteconti.sisp.sample.dto.TipoDto;
import it.corteconti.sisp.sample.service.TipoService;

/**
 * Rest Entità <em>it.corteconti.sisp.sample.model.Tipo</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Tipo")
public class TipoResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(TipoResource.class);
	
	@Autowired
	private TipoService tipoService;
	
	/**
	 * Ritorna una stringa JSON che rappresenta una lista di oggetti Tipo
	 * @param sezioneId		id dell'entità Sezione
	 * @param ambitoId		id dell'entità Ambito
	 * @param categoriaId	id dell'entità Categoria
	 * @return Response HTTP, stringa JSON che rappresenta una lista di dto <em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione, idAmbito, idCategoria, restituisce una lista di entità Tipo.", response = TipoDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista entità Tipo"), })
	public ResponseEntity<List<TipoDto>> getTipi(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
	        @ApiParam(value = "Specifica l'id categoria")
	        @PathVariable("categoriaId") String categoriaId) {
		
		LOG.debug("-- Tipo -> sezioneId:  [" + sezioneId + "]");
		LOG.debug("-- Tipo -> ambitoId:   [" + ambitoId + "]");
		LOG.debug("-- Tipo -> categoriaId:[" + categoriaId + "]");		
		
		List<TipoDto> listaTipi = tipoService.findTipiBySezioneAndAmbitoAndCategoria(sezioneId, ambitoId, categoriaId);
		return new ResponseEntity<>(listaTipi, HttpStatus.OK);
	}
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Tipo
	 * @param sezioneId		id dell'entità Sezione
	 * @param ambitoId		id dell'entità Ambito
	 * @param categoriaId	id dell'entità Categoria
	 * @param tipoId		id dell'entità Tipo
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione, idAmbito, idCategoria, idTipo, restituisce l'entità Tipo.", response = TipoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Tipo"), })
	public ResponseEntity<TipoDto> getTipo(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
	        @ApiParam(value = "Specifica l'id categoria")
	        @PathVariable("categoriaId") String categoriaId,
	        @ApiParam(value = "Specifica l'id tipo")
	        @PathVariable("tipoId") String tipoId) {
		
		LOG.debug("-- Tipo -> sezioneId:  [" + sezioneId + "]");
		LOG.debug("-- Tipo -> ambitoId:   [" + ambitoId + "]");
		LOG.debug("-- Tipo -> categoriaId:[" + categoriaId + "]");
		LOG.debug("-- Tipo -> tipoId:     [" + tipoId + "]");		
		
		TipoDto dto = tipoService.getTipiBySezioneAndAmbitoAndCategoriaAndTipo(sezioneId, ambitoId, categoriaId, tipoId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}