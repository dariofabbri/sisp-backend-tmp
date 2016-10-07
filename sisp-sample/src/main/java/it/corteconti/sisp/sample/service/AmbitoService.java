package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.AmbitoAssembler;
import it.corteconti.sisp.sample.dao.AmbitoRepository;
import it.corteconti.sisp.sample.dto.AmbitoDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Ambito;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Ambito</em>
 * @version 1.0
 */


@Service
@Transactional
public class AmbitoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AmbitoService.class);
	
	@Autowired
	private AmbitoRepository ambitoRepository;
	
	
	
	/**
	 * <p>Restituisce la lista completa di oggetti ambito<p>
	 * @return listaAmbitiDto
	 */
	public List<AmbitoDto> getAmbiti() {
		
		// -- Recupero lista entità Ambito		
		List<Ambito> lista = (List<Ambito>) ambitoRepository.findAll();
		
		// -- Verifica valorizzazione della lista
		if (ValidationUtil.isNullOrEmpty(lista)) {
			// logging
			LOG.debug("Ambiti non trovate.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Ambiti not found.",""));
		}
		
		// logging
		LOG.debug("lista Ambito recuperata, contiene "+ lista.size()+" elementi.");
		
		// -- Lista di ritorno
		List<AmbitoDto> listaAmbitiDto = new ArrayList<>();
		
		// -- Assembler, Ambito -> AmbitoDto
		lista.forEach(a -> {
			AmbitoDto ambitoDto = AmbitoAssembler.assembleDto(a);
			listaAmbitiDto.add(ambitoDto);
		});
		
		return listaAmbitiDto;
	}
	

	
	/**
	 * <p>Ritorna un dto <em>it.corteconti.sisp.sample.dto.AmbitoDto</em></p>
	 * @param idAmbito		id dell'entità Ambito
	 * @return				<em>it.corteconti.sisp.sample.dto.AmbitoDto</em>
	 */
	public AmbitoDto getAmbito(String idAmbito) {
		
		// -- Recupero  Ambito a fronte dell'id ambito		
		Ambito ambito = ambitoRepository.findOne(idAmbito);
		
		// -- Verifica valorizzazione oggetto		
		if (ambito == null ) {
			// logging			
			LOG.debug("Ambito non trovata.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Ambito with Ambito {0}  not found.", idAmbito));
		}
		
		// logging	
		LOG.debug(MessageFormat.format("Trovato il seguente ambito: {0}", ambito.getDescrizioneAmbito() ));
		
		// Dto di ritorno		
		AmbitoDto ambitoDto = AmbitoAssembler.assembleDto(ambito);
		
		return ambitoDto;
	}
	
}
