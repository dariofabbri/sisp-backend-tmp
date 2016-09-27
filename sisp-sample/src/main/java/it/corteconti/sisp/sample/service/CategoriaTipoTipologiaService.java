package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.CategoriaAssembler;
import it.corteconti.sisp.sample.dao.CategoriaTipoTipologiaRepository;
import it.corteconti.sisp.sample.dto.CategoriaArrayDto;
import it.corteconti.sisp.sample.dto.SezioniDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;

@Service
public class CategoriaTipoTipologiaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoriaTipoTipologiaService.class);
	
	@Autowired
	private SezioniService sezioniService;
	@Autowired
	private CategoriaTipoTipologiaRepository categoriaTipoTipologiaRepository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public CategoriaArrayDto findOne(Long idSezione , String idAmbito) {
		
		SezioniDto sezDto = sezioniService.findOne(idSezione);
		List<CategoriaTipoTipologia> lista = categoriaTipoTipologiaRepository.findByIdAmbitoAndLivelloAoo(idAmbito, ""+sezDto.getLivelloSezione());
		if(lista == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Ambito {0} not found.", idAmbito));
		}
		return CategoriaAssembler.assembleArrayDto(lista);
	}
	
}
