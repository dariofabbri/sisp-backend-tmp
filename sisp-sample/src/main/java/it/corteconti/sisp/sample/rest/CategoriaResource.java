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
import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.service.CategoriaService;
/**
 * Rest Entità <em>it.corteconti.sisp.sample.model.Categoria</em>
 * @version 1.0
 */
@RestController
@RequestMapping(
		value = "/giudizio-api",
		produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(description = "Servizio entità Categoria")
public class CategoriaResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoriaResource.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	/**
	 * <p>Ritorna una stringa JSON che rappresenta una lista di oggetti di tipo <em>it.corteconti.sisp.sample.dto.CategoriaDto</em><p>
	 * @param sezioneId
	 * @param ambitoId
	 * @return Response HTTP, JSON <em>java.util.List<it.corteconti.sisp.sample.dto.OggettoDto></em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e idAmbito ritorna una lista di categorie.", response = CategoriaDto.class, responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista entità Categoria"), })
	public ResponseEntity<List<CategoriaDto>> getCategorie(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId){
		
		LOG.debug("-- Categoria -> sezioneId: [" + sezioneId + "]");
		LOG.debug("-- Categoria -> ambitoId:  [" + ambitoId + "]");

		List<CategoriaDto> listaCategoriaAmbito = categoriaService.findCategorieBySezioneAndAmbito(sezioneId, ambitoId);
		return new ResponseEntity<List<CategoriaDto>>(listaCategoriaAmbito, HttpStatus.OK);
	}

	/**
	 * <p>Ritorna una stringa JSON rappresentante un oggetto di tipo  <em>it.corteconti.sisp.sample.dto.CategoriaDto</em><p>
	 * @param sezioneId
	 * @param ambitoId
	 * @param categoriaId
	 * @return Response HTTP, JSON <em>it.corteconti.sisp.sample.dto.CategoriaDto</em>
	 */
	@RequestMapping(value = "/sezioni/{sezioneId}/ambiti/{ambitoId}/categorie/{categoriaId}", method = RequestMethod.GET)
	@ApiOperation(value = "", notes = "Dato idSezione e idAmbito e idCategoria ritorna la categoria selezionata.", response = CategoriaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Entità categoria"), })
	public ResponseEntity<CategoriaDto> getCategoria(
			@ApiParam(value = "Specifica l'id sezione")
			@PathVariable("sezioneId") Long sezioneId,
			@ApiParam(value = "Specifica l'id ambito")
			@PathVariable("ambitoId") String ambitoId,
			@ApiParam(value = "Specifica l'id della categoria")
			@PathVariable("categoriaId") String categoriaId){
		
		LOG.debug("-- Categoria -> sezioneId:    [" + sezioneId + "]");
		LOG.debug("-- Categoria -> ambitoId:     [" + ambitoId + "]");
		LOG.debug("-- Categoria -> categoriaId:  [" + categoriaId + "]");		

		CategoriaDto categoriaDto =  categoriaService.findByCategorieBySezioneAndAmbitoAndCategoria(sezioneId, ambitoId, categoriaId);
		return new ResponseEntity<CategoriaDto>(categoriaDto, HttpStatus.OK);
	}
}