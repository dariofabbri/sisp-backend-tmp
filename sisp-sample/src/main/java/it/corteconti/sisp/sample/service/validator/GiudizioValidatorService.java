package it.corteconti.sisp.sample.service.validator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corteconti.sisp.sample.dao.CategoriaTipoTipologiaRepository;
import it.corteconti.sisp.sample.dao.SezioneRepository;
import it.corteconti.sisp.sample.dto.GiudizioDto;
import it.corteconti.sisp.sample.exception.ValidationException;
import it.corteconti.sisp.sample.model.Sezione;
import it.corteconti.sisp.sample.util.DateValidationUtil;
import it.corteconti.sisp.sample.util.ValidationUtil;

/**
 * Service Validation Entità <em>it.corteconti.sisp.sample.model.Giudizio</em> 
 * @version 1.0
 */
@Service
public class GiudizioValidatorService extends BaseValidatorService {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(GiudizioValidatorService.class);
	
	@Autowired
	private SezioneRepository sezioneRepository;
	@Autowired
	private CategoriaTipoTipologiaRepository categoriaTipoTipologiaRepository;
	
	
	// -- Costanti chiavi messaggi errore validazione file properties
	private static final String KEY_MSG_ERR_VALID_BUSINESS_COUNT_CATEGORIA_TIPO_TIPOLOGIA = "msg.err.valid.business.count.categoria.tipo.tipologia";
	
	
	
	/**
	 * Esegue la validazione di input per la POST
	 * @param dto	dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	protected void validationInput(GiudizioDto dto) {
		
		boolean isvalid = true;
		// -- Lista messaggi errori validazione input
		List<String> errorList = new ArrayList<>();
		
		// -- Data Apertura obbligatoria
		if ( dto.getDataApertura() == null ) {
			errorList.add(MessageFormat.format(resourceBundle.getString(KEY_MSG_VALIDATION_ERROR_REQUIRED), 
					(Object[]) new String[] {"Data Apertura"}));
			isvalid = false;
			
		} else {
			// -- Verifica validità della data inserita
			if ( !DateValidationUtil.isValidDate(dto.getDataApertura()) ) {
				errorList.add(MessageFormat.format(resourceBundle.getString(KEY_MSG_VALIDATION_ERROR_INVALID_DATE), 
						(Object[]) new String[] {"Data Apertura"}));
				isvalid = false;
				
			} else {
				// -- Verifica che la data non sia futura alla data odierna
				if ( DateValidationUtil.isFutureDate(dto.getDataApertura())) {
					errorList.add(MessageFormat.format(resourceBundle.getString(KEY_MSG_VALIDATION_ERROR_FUTURE_DATE), 
							(Object[]) new String[] {"Data Apertura"}));
					isvalid = false;
				}
			}
		}
			
		// -- Id Categoria obbligatorio
		if ( ValidationUtil.isNull(dto.getCategoria()) || ValidationUtil.isBlankOrNullOrZero(dto.getCategoria().getIdCategoria()) ) {
			errorList.add(MessageFormat.format(resourceBundle.getString(KEY_MSG_VALIDATION_ERROR_REQUIRED), 
					(Object[]) new String[] {"Id Categoria"}));
			isvalid = false;
		}
		
		// -- Id Tipo obbligatorio
		if ( ValidationUtil.isNull(dto.getTipo()) || ValidationUtil.isBlankOrNullOrZero(dto.getTipo().getIdTipo()) ) {
			errorList.add(MessageFormat.format(resourceBundle.getString(KEY_MSG_VALIDATION_ERROR_REQUIRED), 
					(Object[]) new String[] {"Id Tipo"}));
			isvalid = false;
		}
		
		// -- Controllo finale validazione
		if ( !isvalid ) {
			LOG.debug("-- Errore Validazione di INPUT.");
			ValidationException ve = new ValidationException(resourceBundle.getString(KEY_MSG_ERR_VALID_INPUT_DEFAULT));
			ve.setValidationErrors(errorList);
			throw ve;
		}
	}
	
	/**
	 * Esegue la validazione di business per la POST
	 * @param dto		dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 * @param idSezione	id dell'entità Sezione
	 * @param idAmbito	id dell'entità Ambito
	 */
	protected void validationBusiness(GiudizioDto dto, Long idSezione, String idAmbito) {
		
		boolean isvalid = true;
		// -- Lista messaggi errori validazione business
		List<String> errorList = new ArrayList<>();
		
		// -- Recupero livello AOO dalla Sezione
		Sezione sezione = this.sezioneRepository.findOne(idSezione);
		// -- COUNT 'CategoriaTipoTipologia' in base alla presenza dell'Id Tipologia
		int count;
		if ( !ValidationUtil.isNull(dto.getTipologia()) && !ValidationUtil.isBlankOrNullOrZero(dto.getTipologia().getIdTipologia()) ) {
			// -- Id Tipologia presente
			count = this.categoriaTipoTipologiaRepository.countByTipoAndCategoriaAndAmbitoAndTipologiaAndLivelloAoo(
					dto.getTipo().getIdTipo(), dto.getCategoria().getIdCategoria(), 
					idAmbito, dto.getTipologia().getIdTipologia(), Integer.toString(sezione.getLivello().intValue()));
			
		} else {
			// -- Id Tipologia non presente
			count = this.categoriaTipoTipologiaRepository.countByTipoAndCategoriaAndAmbitoAndLivelloAoo(
					dto.getTipo().getIdTipo(), dto.getCategoria().getIdCategoria(), idAmbito, Integer.toString(sezione.getLivello().intValue()));
		}
		
		/*
		 * SE count >= 1 validazione superata,
		 * SE count == 0 errore
		 */
		if ( count == 0 ) {
			errorList.add(resourceBundle.getString(KEY_MSG_ERR_VALID_BUSINESS_COUNT_CATEGORIA_TIPO_TIPOLOGIA));
			isvalid = false;
		}
		
		// -- Controllo finale validazione
		if ( !isvalid ) {
			LOG.debug("-- Errore Validazione di BUSINESS.");
			ValidationException ve = new ValidationException(resourceBundle.getString(KEY_MSG_ERR_VALID_BUSINESS_DEFAULT));
			ve.setValidationErrors(errorList);
			throw ve;
		}
	}
	

}
