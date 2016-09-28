package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.CategoriaAssembler;
import it.corteconti.sisp.sample.assembler.TipologiaAssembler;
import it.corteconti.sisp.sample.dao.CategoriaRepository;
import it.corteconti.sisp.sample.dao.TipologiaRepository;
import it.corteconti.sisp.sample.dto.CategoriaDto;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Categoria;
import it.corteconti.sisp.sample.model.Tipologia;

@Service
@Transactional
public class TipologiaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TipologiaService.class);
	
	@Autowired
	private SezioneService sezioniService;
	@Autowired
	private TipologiaRepository tipologiaRepository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public List<TipologiaDto> findTipologieBySezioneAndAmbitoAndCategoriaAndTipo(Long idSezione , String idAmbito , String idCategoria , String idTipo) {
		
		SezioneDto sezDto = sezioniService.findSezioniById(idSezione);
		List<Tipologia> lista = tipologiaRepository.findFromTipologiaByLivelloAooAndIdAmbitoAndIdCategoriaAndIdTipo(""+sezDto.getLivelloSezione(), idAmbito, idCategoria, idTipo);
		if (lista == null || lista.isEmpty()) {
			LOG.debug("Tipologie non trovate.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipologie with Sezione {0} and Ambito {1} and Categoria {2} and Tipo {3} not found.", idSezione, idAmbito, idCategoria, idTipo));
		}
		
		List<TipologiaDto> listaTipologieDto = new ArrayList<TipologiaDto>();
		
		lista.forEach(t -> {
			TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(t);
			listaTipologieDto.add(tipologiaDto);
		});
		
		return listaTipologieDto;
	}
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public List<TipologiaDto> findTipologieBySezioneAndAmbitoAndCategoriaAndTipoAndIdTipologia(Long idSezione , String idAmbito , String idCategoria , String idTipo , String idTipologia) {
		
		SezioneDto sezDto = sezioniService.findSezioniById(idSezione);
		List<Tipologia> lista = tipologiaRepository.findFromTipologiaByLivelloAooAndIdAmbitoAndIdCategoriaAndIdTipoAndIdTipologia(""+sezDto.getLivelloSezione(), idAmbito, idCategoria, idTipo, idTipologia);
		if (lista == null || lista.isEmpty()) {
			LOG.debug("Tipologie non trovate.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipologie with Sezione {0} and Ambito {1} and Categoria {2} and Tipo {3} and Tipologia {4} not found.", idSezione, idAmbito, idCategoria, idTipo, idTipologia));
		}
		
		List<TipologiaDto> listaTipologieDto = new ArrayList<TipologiaDto>();
		
		lista.forEach(t -> {
			TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(t);
			listaTipologieDto.add(tipologiaDto);
		});
		
		return listaTipologieDto;
	}
	
}
