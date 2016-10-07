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
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Service Entità <em>it.corteconti.sisp.sample.model.Tipo</em>
 * @version 1.0
 */
@Service
@Transactional
public class TipoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TipoService.class);
	
	@Autowired
	private SezioneService sezioneService;
	@Autowired
	private TipoRepository tipoRepository;
	
	
	/**
	 * <p>Ritorna una lista di dto <em>it.corteconti.sisp.sample.dto.TipoDto</em></p>
	 * @param idSezione		id dell'entità Sezione
	 * @param idAmbito		id dell'entità Ambito
	 * @param idCategoria	id dell'entità Categoria
	 * @return				<em>java.util.List<it.corteconti.sisp.sample.dto.TipoDto></em>
	 */
	public List<TipoDto> findTipiBySezioneAndAmbitoAndCategoria(Long idSezione, String idAmbito, String idCategoria) {
		
		// -- Recupero entità Sezione a fronte dell'id
		SezioneDto sezDto = sezioneService.findSezioniById(idSezione);
		// -- Recupero lista entità Tipo a fronte dell'id ambito, id categoria, livello AOO
		List<Tipo> lista = tipoRepository.findFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAoo(idAmbito, 
				idCategoria, ""+sezDto.getLivelloSezione());
		// -- Verifica valorizzazione della lista
		if ( ValidationUtil.isNullOrEmpty(lista) ) {
			// logging
			LOG.debug("-- Tipi non trovati.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipo with Ambito {0} and Sezione {1} and Categoria {2} not found.", idAmbito, idSezione, idCategoria));
		}
		// logging
		LOG.debug("-- lista, size [" + lista.size() + "]");
		// -- Lista di ritorno
		List<TipoDto> dtoList = new ArrayList<>();
		
		lista.forEach(t -> {
			// -- Assembler, Tipo -> TipoDto
			TipoDto tipoDto = TipoAssembler.assembleDto(t);
			dtoList.add(tipoDto);
		});
		
		return dtoList;
	}
	
	/**
	 * <p>Ritorna il dto dell'entità <em>it.corteconti.sisp.sample.model.Tipo</em></p>
	 * @param idSezione		id dell'entità Sezione
	 * @param idAmbito		id dell'entità Ambito
	 * @param idCategoria	id dell'entità Categoria
	 * @param idTipo		id dell'entità Tipo
	 * @return				<em>it.corteconti.sisp.sample.dto.TipoDto</em>
	 */
	public TipoDto getTipiBySezioneAndAmbitoAndCategoriaAndTipo(Long idSezione , String idAmbito, String idCategoria, String idTipo) {
		
		// -- Recupero entità Sezione a fronte dell'id
		SezioneDto sezDto = sezioneService.findSezioniById(idSezione);
		// -- Recupero Tipo a fronte dell'id ambito, id categoria, livello AOO, id tipo
		Tipo tipo = tipoRepository.getFromCategoriaTipoTipologiaByIdAmbitoAndIdCategoriaAndLivelloAooAndTipo(idAmbito, 
				idCategoria, ""+sezDto.getLivelloSezione(), idTipo);
		// -- Verifica valorizzazione oggetto
		if (tipo == null) {
			LOG.debug("Tipo non trovato.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipo with Ambito {0} and Sezione {1} and Categoria {2} and Tipo {3} not found.", 
							idAmbito, idSezione, idCategoria, idTipo));
		}
		
		// Dto di ritorno
		TipoDto tipoDto = TipoAssembler.assembleDto(tipo);
		return tipoDto;
	}
	
	
}
