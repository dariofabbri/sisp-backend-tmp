package it.corteconti.sisp.sample.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.service.GiudizioService;

/**
 * Rest Entità <em>it.corteconti.sisp.sample.model.Giudizio</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Giudizio")
public class GiudizioResource {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(GiudizioResource.class);
	
	@Autowired
	private GiudizioService service;
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Giudizio
	 * @param idGiudizio	id dell'entità Giudizio
	 * @return 				Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */	
	@RequestMapping(value = "/giudizi/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Giudizio", notes = "Dato idGiudizio, restituisce l'entità Giudizio.", response = GiudizioDto.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK") }
	)
	public ResponseEntity<GiudizioDto> getGiudizio(
			@ApiParam(value = "Specifica l'id dell'entità da ritornare", required = true)
			@PathVariable("id") Long idGiudizio) {
		
		GiudizioDto giudizio = service.getGiudizio(idGiudizio);
		return new ResponseEntity<>(giudizio, HttpStatus.OK);
	}
	
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Giudizio
	 * @param numero		contatore
	 * @param tipoId		id dell'entità Tipo
	 * @param categoriaId	id dell'entità Categoria
	 * @return				Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/giudizi", method = RequestMethod.GET)
	@ApiOperation(value = "Giudizio per numero, idTipo, idCategoria in query string", notes = "Dato numero, idTipo, idCategoria in query string, restituisce l'entità Giudizio.", response = GiudizioDto.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK") }
	)
	public ResponseEntity<GiudizioDto> getGiudizioBySezioneAndNumeroAndTipoAndCategoria(
			@ApiParam(value = "Specifica l'id sezione", required = true)
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica il contatore", required = true)
			@RequestParam("numero") Long numero,
			@ApiParam(value = "Specifica l'id dell'entità tipo", required = true)
			@RequestParam("tipoId") String tipoId,
			@ApiParam(value = "Specifica l'id dell'entità categoria", required = true)
			@RequestParam("categoriaId") String categoriaId) {
		
		GiudizioDto giudizio = service.getBySezioneAndNumeroAndTipoAndCategoria(sezioneId, numero, tipoId, categoriaId);
		return new ResponseEntity<>(giudizio, HttpStatus.OK);
	}
	
	
	/**
	 * Crea un'entità Giudizio
	 * @param sezioneId		id dell'entità Sezione
	 * @param ambitoId		id dell'entità Ambito
	 * @param giudizioDto	dto Giudizio
	 * @return 				Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/giudizi", method = RequestMethod.POST)
	@ApiOperation(value = "Inserimento di un nuovo Giudizio", notes = "Creazione entità Giudizio", response = GiudizioDto.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")}
	)
	public ResponseEntity<GiudizioDto> save(
			@ApiParam(value = "Specifica l'id sezione", required = true)
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito", required = true)
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica il dto giudizio", required = true)
			@RequestBody GiudizioDto giudizioDto,
			UriComponentsBuilder ucBuilder) {
		
		LOG.debug("-- [Giudizio, POST] -> START -----------------------------------------");
		LOG.debug("-- [GiudizioDto] -> REQ: [" + giudizioDto.toString() + "]");
		GiudizioDto dto = service.save(giudizioDto, sezioneId, ambitoId);
		LOG.debug("-- [GiudizioDto] -> RES: [" + dto.toString() + "]");
		LOG.debug("-- [Giudizio, POST] -> END   -----------------------------------------");
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/giudizio-api/giudizi/{id}").buildAndExpand(dto.getIdGiudizio()).toUri());
		return new ResponseEntity<>(dto, headers, HttpStatus.CREATED);
	}
	
	
}
