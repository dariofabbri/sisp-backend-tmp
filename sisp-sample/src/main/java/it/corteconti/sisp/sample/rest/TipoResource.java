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
@Api(description = "TipoResource")
public class TipoResource {
	
	@Autowired
	private TipoService tipoService;
	
	/**
	 * Ritorna una stringa JSON che rappresenta una lista di oggetti Tipo
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @return Response HTTP, stringa JSON che rappresenta una lista di dto <em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione, idAmbito, idCategoria, restituisce una lista di entità Tipo.", response = TipoDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Tipo indicata"), })
	public ResponseEntity<List<TipoDto>> getList(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
	        @ApiParam(value = "Specifica l'id categoria")
	        @PathVariable("categoriaId") String categoriaId) {
		
		List<TipoDto> listaTipi = tipoService.findTipiBySezioneAndAmbitoAndCategoria(sezioneId, ambitoId, categoriaId);
		return new ResponseEntity<List<TipoDto>>(listaTipi, HttpStatus.OK);
	}
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Tipo
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @param tipoId
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}/tipi/{tipoId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione, idAmbito, idCategoria, idTipo, restituisce l'entità Tipo.", response = TipoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Tipo indicata"), })
	public ResponseEntity<TipoDto> get(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
	        @ApiParam(value = "Specifica l'id categoria")
	        @PathVariable("categoriaId") String categoriaId,
	        @ApiParam(value = "Specifica l'id tipo")
	        @PathVariable("tipoId") String tipoId) {
		
		TipoDto dto = tipoService.getTipiBySezioneAndAmbitoAndCategoriaAndTipo(sezioneId, ambitoId, categoriaId, tipoId);
		return new ResponseEntity<TipoDto>(dto, HttpStatus.OK);
	}
}