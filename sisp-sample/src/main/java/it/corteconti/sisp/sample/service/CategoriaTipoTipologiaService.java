package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.assembler.CategoriaAssembler;
import it.corteconti.sisp.sample.assembler.GiudizioAssembler;
import it.corteconti.sisp.sample.dao.AmbitoRepository;
import it.corteconti.sisp.sample.dao.CategoriaRepository;
import it.corteconti.sisp.sample.dao.CategoriaTipoTipologiaRepository;
import it.corteconti.sisp.sample.dao.GiudizioRepository;
import it.corteconti.sisp.sample.dao.SezioniRepository;
import it.corteconti.sisp.sample.dao.TipoRepository;
import it.corteconti.sisp.sample.dao.TipologiaRepository;
import it.corteconti.sisp.sample.dto.CategoriaArrayDto;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Categoria;
import it.corteconti.sisp.sample.model.CategoriaTipoTipologia;
import it.corteconti.sisp.sample.model.Giudizio;
import it.corteconti.sisp.sample.model.Sezioni;

@Service
public class CategoriaTipoTipologiaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoriaTipoTipologiaService.class);

	@Autowired
	private CategoriaTipoTipologiaRepository categoriaTipoTipologiaRepository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public CategoriaArrayDto findOne(String livelloAoo , String idAmbito) {
		
		List<CategoriaTipoTipologia> lista = categoriaTipoTipologiaRepository.findByIdAmbitoAndLivelloAoo(idAmbito, livelloAoo);
		if(lista == null) {
			LOG.debug("Nessun oggetto trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Ambito {0} not found.", idAmbito));
		}
		return CategoriaAssembler.assembleArrayDto(lista);
	}
	
}
