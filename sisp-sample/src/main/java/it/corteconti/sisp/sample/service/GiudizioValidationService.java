package it.corteconti.sisp.sample.service;

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
import it.corteconti.sisp.util.ValidationUtil;

/**
 * Service Validation Entità <em>it.corteconti.sisp.sample.model.Giudizio</em> 
 * @version 1.0
 */
@Service
public class GiudizioValidationService {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(GiudizioValidationService.class);
	
	@Autowired
	private SezioneRepository sezioneRepository;
	@Autowired
	private CategoriaTipoTipologiaRepository categoriaTipoTipologiaRepository;
	
	
	// -- Costanti
	//private static final String MSG_ERR_VALID_REQUEST = "Errore validazione request";
	private static final String MSG_ERR_VALID_INPUT = "Errore validazione di input";
	private static final String MSG_ERR_VALID_BUSINESS = "Errore validazione di business";
	//private static final String MSG_ERR_VALID_REQUEST_DTO_GIUDIZIO = "Oggetto Giudizio non presente nella request";
	//private static final String MSG_ERR_VALID_REQUEST_ID_SEZIONE = "Id Sezione non presente nella request";
	//private static final String MSG_ERR_VALID_REQUEST_ID_AMBITO = "Id Ambito non presente nella request";
	private static final String MSG_ERR_VALID_INPUT_DATA_APERTURA_OBLIGATORY = "La Data Apertura è obbligatoria";
	private static final String MSG_ERR_VALID_INPUT_DATA_APERTURA_INVALID = "La Data Apertura non è valida";
	private static final String MSG_ERR_VALID_INPUT_ID_CATEGORIA_OBLIGATORY = "L'Id Categoria è obbligatorio";
	private static final String MSG_ERR_VALID_INPUT_ID_TIPO_OBLIGATORY = "L'Id Tipo è obbligatorio";
	private static final String MSG_ERR_VALID_BUSINESS_COUNT_CATEGORIA_TIPO_TIPOLOGIA = "Non è possibile creare il giudizio: categoria, tipo, tipologia non permessi";
	
	
//	/**
//	 * Esegue la validazione della REQUEST
//	 * @param dto		dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
//	 * @param idSezione	id dell'entità Sezione
//	 * @param idAmbito	id dell'entità Ambito
//	 */
//	protected void validationRequest(GiudizioDto dto, Long idSezione, String idAmbito) {
//		
//		boolean isvalid = true;
//		// -- Lista messaggi errori validazione request
//		List<String> errorList = new ArrayList<String>();
//		
//		if ( dto == null ) {
//			errorList.add(MSG_ERR_VALID_REQUEST_DTO_GIUDIZIO);
//			isvalid = false;
//		}
//		
//		if ( ValidationUtil.isNullOrZero(idSezione) ) {
//			errorList.add(MSG_ERR_VALID_REQUEST_ID_SEZIONE);
//			isvalid = false;
//		}
//		
//		if ( ValidationUtil.isBlankOrNullOrZero(idAmbito) ) {
//			errorList.add(MSG_ERR_VALID_REQUEST_ID_AMBITO);
//			isvalid = false;
//		}
//		
//		
//		// -- Controllo finale validazione
//		if ( !isvalid ) {
//			LOG.debug("-- Errore Validazione REQUEST.");
//			ValidationException ve = new ValidationException(MSG_ERR_VALID_REQUEST);
//			ve.setValidationErrors(errorList);
//			throw ve;
//		}
//	}
	
	/**
	 * Esegue la validazione di input per la POST
	 * @param dto	dto <em>it.corteconti.sisp.sample.dto.GiudizioDto</em>
	 */
	protected void validationInput(GiudizioDto dto) {
		
		boolean isvalid = true;
		// -- Lista messaggi errori validazione input
		List<String> errorList = new ArrayList<String>();
		
		// -- Data Apertura obbligatoria
		if ( dto.getDataApertura() == null ) {
			errorList.add(MSG_ERR_VALID_INPUT_DATA_APERTURA_OBLIGATORY);
			isvalid = false;
			
		} else {
			// -- Verifica validità della data inserita
			if ( !ValidationUtil.isValidDate(dto.getDataApertura()) ) {
				errorList.add(MSG_ERR_VALID_INPUT_DATA_APERTURA_INVALID);
				isvalid = false;
			}
		}
			
		// -- Id Categoria obbligatorio
		if ( ValidationUtil.isBlankOrNullOrZero(dto.getCategoria().getIdCategoria()) ) {
			errorList.add(MSG_ERR_VALID_INPUT_ID_CATEGORIA_OBLIGATORY);
			isvalid = false;
		}
		
		// -- Id Tipo obbligatorio
		if ( ValidationUtil.isBlankOrNullOrZero(dto.getTipo().getIdTipo()) ) {
			errorList.add(MSG_ERR_VALID_INPUT_ID_TIPO_OBLIGATORY);
			isvalid = false;
		}
		
		// -- Controllo finale validazione
		if ( !isvalid ) {
			LOG.debug("-- Errore Validazione di INPUT.");
			ValidationException ve = new ValidationException(MSG_ERR_VALID_INPUT);
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
		List<String> errorList = new ArrayList<String>();
		
		// -- Recupero livello AOO dalla Sezione
		Sezione sezione = this.sezioneRepository.findOne(idSezione);
		// -- COUNT 'CategoriaTipoTipologia' in base alla presenza dell'Id Tipologia
		int count = 0;
		if ( dto.getTipologia() != null && !ValidationUtil.isBlankOrNullOrZero(dto.getTipologia().getIdTipologia()) ) {
			// -- Id Tipologia presente
			count = this.categoriaTipoTipologiaRepository.countByTipoAndCategoriaAndAmbitoAndTipologiaAndLivelloAoo(
					dto.getTipo().getIdTipo(), dto.getCategoria().getIdCategoria(), 
					idAmbito, dto.getTipologia().getIdTipologia(), ""+sezione.getLivello()).intValue();
			
		} else {
			// -- Id Tipologia non presente
			count = this.categoriaTipoTipologiaRepository.countByTipoAndCategoriaAndAmbitoAndLivelloAoo(
					dto.getTipo().getIdTipo(), dto.getCategoria().getIdCategoria(), idAmbito, ""+sezione.getLivello()).intValue();
		}
		
		/*
		 * SE count >= 1 validazione superata,
		 * SE count == 0 errore
		 */
		if ( count == 0 ) {
			errorList.add(MSG_ERR_VALID_BUSINESS_COUNT_CATEGORIA_TIPO_TIPOLOGIA);
			isvalid = false;
		}
		
		// -- Controllo finale validazione
		if ( !isvalid ) {
			LOG.debug("-- Errore Validazione di BUSINESS.");
			ValidationException ve = new ValidationException(MSG_ERR_VALID_BUSINESS);
			ve.setValidationErrors(errorList);
			throw ve;
		}
	}
	

}
