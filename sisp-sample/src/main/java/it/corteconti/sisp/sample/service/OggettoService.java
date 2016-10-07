package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.OggettoAssembler;
import it.corteconti.sisp.sample.dao.OggettoRepository;
import it.corteconti.sisp.sample.dto.OggettoDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Oggetto;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * 
 * Service Entità <em>it.corteconti.sisp.sample.model.Oggetto</em>
 * @version 1.0
 *
 */
@Service
@Transactional
public class OggettoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OggettoService.class);
	
	@Autowired
	private OggettoRepository oggettoRepository;
	
	/**
	 * <p>ritorna una lista di oggetti dto per id della sezione<p>
	 * @param sezioneId
	 * @return <em>java.util.List<it.corteconti.sisp.sample.dto.OggettoDto></em>
	 */
	public List<OggettoDto> findOggettoBySezione( Long sezioneId ) {
		
		List<OggettoDto> listaOggettiDto = new ArrayList<>();
		
		List<Oggetto> listaOggetti = oggettoRepository.findListOggettoByIdSezione(sezioneId);
		
		if(listaOggetti == null || listaOggetti.isEmpty()) {
			// logging	
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Non esistono oggetti per la sezione {0}.", sezioneId));
		}
		LOG.debug("lista Oggetto recuperata, contiene "+ listaOggetti.size() +" elementi.");
		
		listaOggetti.forEach( o ->{
			OggettoDto oggettoDto = OggettoAssembler.assembleDto(o);
			listaOggettiDto.add(oggettoDto);
		});
		
		return listaOggettiDto;
		
	}
	
	/**
	 * <p>ritorna una oggetto per id della sezione e dell'oggetto<p>
	 * @param sezioneId
	 * @param idOggetto
	 * @return <em>it.corteconti.sisp.sample.dto.OggettoDto</em>
	 */
	public OggettoDto findOggettoBySezioneAndIdOggetto(Long sezioneId, Long idOggetto) {
		
		Oggetto oggetto = oggettoRepository.findOggettoByIdSezioneAndIdOggetto(sezioneId,idOggetto);
		
		if( ValidationUtil.isNull(oggetto) || ValidationUtil.isNull(oggetto.getCodiceOggetto()) ) {
			// logging	
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Non esite oggetto {0} per la sezione {1}.", idOggetto, sezioneId ));
		}
		
		LOG.debug("Entità Oggetto recuperata, id : "+ oggetto.getCodiceOggetto());
		
		return OggettoAssembler.assembleDto( oggetto );
		
	}

}
