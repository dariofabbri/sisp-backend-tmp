package it.corteconti.sisp.sample.service.validator;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

/**
 * Service Base Validator 
 * @version 1.0
 */
@Service
public class BaseValidatorService {
	
	
	// -- Costanti chiavi messaggi validazione generici
	protected final static String KEY_MSG_ERR_VALID_INPUT_DEFAULT = "msg.err.valid.input.default";
	protected final static String KEY_MSG_ERR_VALID_BUSINESS_DEFAULT = "msg.err.valid.business.default";
	protected final static String KEY_MSG_VALIDATION_ERROR_REQUIRED = "validation.error.required";
	protected final static String KEY_MSG_VALIDATION_ERROR_INVALID_DATE = "validation.error.invalid.date";
	protected final static String KEY_MSG_VALIDATION_ERROR_FUTURE_DATE = "validation.error.future.date";
	
	
	
	protected static ResourceBundle resourceBundle = ResourceBundle.getBundle("validatorMessages", Locale.getDefault());
	
	
}
