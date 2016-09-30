package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.GiudizioAssembler;
import it.corteconti.sisp.sample.dao.GiudizioRepository;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Giudizio;

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Giudizio</em> 
 * @version 1.0
 */

@Service
public class GiudizioService {
	
	private static final Logger LOG = LoggerFactory.getLogger(GiudizioService.class);

	@Autowired
	private GiudizioRepository repository;
	
	/**
	 * <p>Ritorna un dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em></p>
	 * @param id			id dell'entità Giudizio
	 * @return				<em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	public GiudizioDto findGiudizioById(Long id) {

		// -- Recupero entità Giudizio a fronte dell'id			
		Giudizio giudizio = repository.findOne(id);
		
		// -- Verifica valorizzazione oggetto
		if(giudizio == null) {
			// logging	
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Giudizio {0} not found.", id));
		}
		
		// logging	
		LOG.debug(MessageFormat.format("Trovato il seguente giudizio: {0}", giudizio));
		
		// -- Assembler, Giudizio -> GiudizioDto			
		return GiudizioAssembler.assembleDto(giudizio);
	}
	
}
