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
import it.corteconti.sisp.sample.dto.OggettoDto;
import it.corteconti.sisp.sample.service.OggettoService;

@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE  })
@Api(description = "Servizio entità Oggetto")
public class OggettoResource {
	
	@Autowired
	private OggettoService oggettoService;
	

	/**
	 * <p>Ritorna una stringa JSON che rappresenta una lista di oggetti di tipo <em>it.corteconti.sisp.sample.dto.OggettoDto</em><p>
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @return Response HTTP, JSON <em>java.util.List<it.corteconti.sisp.sample.dto.OggettoDto></em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/oggetti", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione ritorna una lista di entità Oggetto.", response = OggettoDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista entità Oggetto"), })
	public ResponseEntity<List<OggettoDto>> getOggetti(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId){

		List<OggettoDto> listaOggetti = oggettoService.findOggettoBySezione(sezioneId);
		return new ResponseEntity<List<OggettoDto>>(listaOggetti, HttpStatus.OK);

	}
	
	/**
	 * <p>Ritorna una stringa JSON che rapprensenta un oggetto di tipo <em>it.corteconti.sisp.sample.dto.OggettoDto</em><p>
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @return Response HTTP, JSON <em>it.corteconti.sisp.sample.dto.OggettoDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/oggetti/{idOggetto}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e oggettoId ritorna un entità Oggetto.", response = OggettoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità Oggetto"), })
	public ResponseEntity<OggettoDto> getOggetto(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id oggetto")
			@PathVariable("idOggetto") Long idOggetto){

		OggettoDto oggetto = oggettoService.findOggettoBySezioneAndIdOggetto(sezioneId,idOggetto);
		return new ResponseEntity<OggettoDto>(oggetto, HttpStatus.OK);

	}

}
