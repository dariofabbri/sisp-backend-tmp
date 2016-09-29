package it.corteconti.sisp.sample.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.corteconti.sisp.sample.assembler.TipologiaAssembler;
import it.corteconti.sisp.sample.dao.TipologiaRepository;
import it.corteconti.sisp.sample.dto.SezioneDto;
import it.corteconti.sisp.sample.dto.TipologiaDto;
import it.corteconti.sisp.sample.exception.ResourceNotFoundException;
import it.corteconti.sisp.sample.model.Tipologia;

/**
 * Service Entit� <em>it.corteconti.sisp.sample.model.Tipologia</em> 
 * @version 1.0
 */

@Service
@Transactional
public class TipologiaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TipologiaService.class);
	
	@Autowired
	private SezioneService sezioniService;
	@Autowired
	private TipologiaRepository tipologiaRepository;
	
	/**
	 * <p>Ritorna una lista di dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em></p>
	 * @param idSezione		id dell'entit� Sezione
	 * @param idAmbito		id dell'entit� Ambito
	 * @param idCategoria	id dell'entit� Categoria
	 * @param idTipo		id dell'entit� Tipo
	 * @return				<em>java.util.List<it.corteconti.sisp.sample.dto.TipologiaDto></em>
	 */
	public List<TipologiaDto> findTipologieBySezioneAndAmbitoAndCategoriaAndTipo(Long idSezione , String idAmbito , String idCategoria , String idTipo) {

		// -- Recupero entit� Sezione a fronte dell'id		
		SezioneDto sezDto = sezioniService.findSezioniById(idSezione);
		
		// -- Recupero lista entit� Tipologia a fronte del livello AOO, id ambito, id categoria, id tipo
		List<Tipologia> lista = tipologiaRepository.findFromTipologiaByLivelloAooAndIdAmbitoAndIdCategoriaAndIdTipo(""+sezDto.getLivelloSezione(), idAmbito, idCategoria, idTipo);
		
		// -- Verifica valorizzazione della lista		
		if (lista == null || lista.isEmpty()) {
			// logging		
			LOG.debug("Tipologie non trovate.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipologie with Sezione {0} and Ambito {1} and Categoria {2} and Tipo {3} not found.", idSezione, idAmbito, idCategoria, idTipo));
		}
		
		// -- Lista di ritorno
		List<TipologiaDto> listaTipologieDto = new ArrayList<TipologiaDto>();
		
		// -- Assembler, Tipologia -> TipologiaDto
		lista.forEach(t -> {
			TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(t);
			listaTipologieDto.add(tipologiaDto);
		});
		
		return listaTipologieDto;
	}
	
	/**
	 * <p>Ritorna un dto <em>it.corteconti.sisp.sample.dto.TipologiaDto</em></p>
	 * @param idSezione		id dell'entit� Sezione
	 * @param idAmbito		id dell'entit� Ambito
	 * @param idCategoria	id dell'entit� Categoria
	 * @param idTipo		id dell'entit� Tipo
	 * @param idTipologia	id dell'entit� Tipologia
	 * @return				<em>it.corteconti.sisp.sample.dto.TipologiaDto</em>
	 */
	public TipologiaDto findTipologiaBySezioneAndAmbitoAndCategoriaAndTipoAndIdTipologia(Long idSezione , String idAmbito , String idCategoria , String idTipo , String idTipologia) {
		
		// -- Recupero entit� Sezione a fronte dell'id		
		SezioneDto sezDto = sezioniService.findSezioniById(idSezione);
		
		// -- Recupero  Tipologia a fronte del livello AOO, id ambito, id categoria, id tipo, id tipologia		
		Tipologia tipologia = tipologiaRepository.findFromTipologiaByLivelloAooAndIdAmbitoAndIdCategoriaAndIdTipoAndIdTipologia(""+sezDto.getLivelloSezione(), idAmbito, idCategoria, idTipo, idTipologia);
		
		// -- Verifica valorizzazione oggetto		
		if (tipologia == null ) {
			// logging			
			LOG.debug("Tipologia non trovata.");
			throw new ResourceNotFoundException(
					MessageFormat.format("Tipologia with Sezione {0} and Ambito {1} and Categoria {2} and Tipo {3} and Tipologia {4} not found.", idSezione, idAmbito, idCategoria, idTipo, idTipologia));
		}
		
		// Dto di ritorno		
		TipologiaDto tipologiaDto = TipologiaAssembler.assembleDto(tipologia);
		
		return tipologiaDto;
	}
	
}
