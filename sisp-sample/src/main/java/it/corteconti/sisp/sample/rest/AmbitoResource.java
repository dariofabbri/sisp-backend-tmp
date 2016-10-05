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
import it.corteconti.sisp.sample.dto.AmbitoDto;
import it.corteconti.sisp.sample.service.AmbitoService;

/**
 * Rest Entità <em>it.corteconti.sisp.sample.model.Ambito</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Ambito")
public class AmbitoResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(AmbitoResource.class);
	
	@Autowired
	private AmbitoService ambitoService;
	
	/**
	 * Ritorna una stringa JSON che rappresenta una lista di oggetti Ambito
	 * @return Response HTTP, stringa JSON che rappresenta una lista di dto <em>it.corteconti.sisp.sample.dto.AmbitoDto</em>
	 */
	@RequestMapping(value = "/ambiti/", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Restituisce la lista di entità Ambito.", response = AmbitoDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista entità Ambito"), })
	public ResponseEntity<List<AmbitoDto>> getAmbiti() {
		
		List<AmbitoDto> listaAmbiti = ambitoService.getAmbiti();
		return new ResponseEntity<>(listaAmbiti, HttpStatus.OK);
	}
	
	/**
	 * Ritorna una stringa JSON che rappresenta un oggetto Ambito
	 * @param ambitoId		id dell'entità Ambito
	 * @return Response HTTP, stringa JSON che rappresenta un dto <em>it.corteconti.sisp.sample.dto.AmbitoDto</em>
	 */
	@RequestMapping(value = "/ambiti/{ambitoId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idAmbito, restituisce l'entità Ambito.", response = AmbitoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Ambito"), })
	public ResponseEntity<AmbitoDto> getAmbito(
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId) {
		
		LOG.debug("-- Ambito -> ambitoId:  [" + ambitoId + "]");
		
		AmbitoDto dto = ambitoService.getAmbito(ambitoId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}