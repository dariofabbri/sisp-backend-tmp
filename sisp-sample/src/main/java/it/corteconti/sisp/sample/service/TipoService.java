package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.TipoAssembler;
import it.corteconti.sisp.sample.dao.TipoRepository;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.dto.TipoDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Tipo;

@Service
@Transactional
public class TipoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TipoService.class);
	
	@Autowired
	private SezioneService sezioniService;
	@Autowired
	private TipoRepository tipoRepository;
	
	//@HystrixCommand(fallbackMethod = "findOneFallback")
	public List<TipoDto> findTipiBySezioneAndAmbitoAndCategoria(Long idSezione , String idAmbito, String idCategoria) {
		
		SezioneDto sezDto = sezioniService.findSezioniById(idSezione);
		List<Tipo> lista = tipoRepository.findFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAoo(idAmbito, 
				idCategoria, ""+sezDto.getLivelloSezione());
		if (lista == null || lista.isEmpty()) {
			LOG.debug("Tipi non trovati.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipo with Ambito {0} and Sezione {1} and Categoria {2} not found.", idAmbito, idSezione, idCategoria));
		}
		
		List<TipoDto> listaTipiDto = new ArrayList<TipoDto>();
		
		lista.forEach(t -> {
			TipoDto tipoDto = TipoAssembler.assembleDto(t);
			listaTipiDto.add(tipoDto);
		});
		
		return listaTipiDto;
	}
	
	public TipoDto getTipiBySezioneAndAmbitoAndCategoriaAndTipo(Long idSezione , String idAmbito, String idCategoria, String idTipo) {
		
		SezioneDto sezDto = sezioniService.findSezioniById(idSezione);
		Tipo tipo = tipoRepository.getFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAooAndTipo(idAmbito, 
				idCategoria, ""+sezDto.getLivelloSezione(), idTipo);
		if (tipo == null) {
			LOG.debug("Tipo non trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipo with Ambito {0} and Sezione {1} and Categoria {2} and Tipo {3} not found.", 
							idAmbito, idSezione, idCategoria, idTipo));
		}
		
		TipoDto tipoDto = TipoAssembler.assembleDto(tipo);
		return tipoDto;
	}
	
}
