package it.corteconti.sisp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Helper per le validazioni
 * @version 1.0
 */
public class ValidationUtil {
	
	
	// -- Costanti
	private static final String STRING_ZERO = "0";
	private static final int LENGHT_ZERO = 0;
	
	
	/**
     * Costruttore privato, impedisce l'instanziazione
     */
	private ValidationUtil() {}
	
	
	/**
	 * Verifica se una stringa è <em>null</em> o <em>blank</em>
	 * @param arg0	La stringa passata in input
	 * @return		<code>boolean</code> Ritorna <em>true</em> se la stringa è <em>null</em> o <em>blank</em>
	 */
	public static boolean isBlankOrNull(String arg0) {
		return arg0 == null || arg0.trim().length() == LENGHT_ZERO;
	}
	
	/**
	 * Verifica se una stringa è <em>null</em>, <em>blank</em> o uguale a zero
	 * @param arg0	La stringa passata in input
	 * @return		<code>boolean</code> Ritorna <em>true</em> se la stringa è <em>null</em>, <em>blank</em> o uguale a zero
	 */
	public static boolean isBlankOrNullOrZero(String arg0) {
		return arg0 == null || arg0.trim().length() == LENGHT_ZERO || arg0.trim().equals(STRING_ZERO);
	}
	
	/**
	 * Verifica se una collection è <em>null</em>
	 * @param arg0	La <em>collection</em> passata in input
	 * @return		<code>boolean</code> Ritorna <em>true</em> se la <em>collection</em> di oggetti è <em>null</em>
	 */
	public static boolean isNull(Collection<?> arg0) {
		return arg0 == null;
	}
	
	/**
	 * Verifica se un oggetto è <em>null</em>
	 * @param arg0	L'oggetto passato in input
	 * @return		<code>boolean</code> Ritorna <em>true</em> se l'oggetto è <em>null</em>
	 */
	public static boolean isNull(Object arg0) {
		return arg0 == null;
	}
	
	/**
	 * Verifica se una <em>collection</em> è <em>null</em> o vuota
	 * @param arg0	La <em>collection</em> passata in input.
	 * @return		<code>boolean</code> Ritorna <em>true</em> se la <em>collection</em> di oggetti è <em>null</em> o vuota
	 */
	public static boolean isNullOrEmpty(Collection<?> arg0) {
		return arg0 == null || arg0.isEmpty();
	}
	
	/**
	 * Verifica se un <em>array</em> di oggetti è <em>null</em> o ha una lunghezza pari a zero
	 * @param arg0	<em>Array</em> di oggetti passato in input
	 * @return		<code>boolean</code> Ritorna <em>true</em> se l'<em>array</em> di oggetti è <em>null</em> o ha una lunghezza pari a zero
	 */
	public static boolean isNullOrEmpty(Object[] arg0) {
		return arg0 == null || arg0.length == LENGHT_ZERO;
	}
	
	/**
	 * Verifica se un oggetto di tipo <code>java.lang.Integer</code> è <em>null</em> o uguale a zero
	 * @param arg0	L'oggetto passato in input.
	 * @return		<code>boolean</code> Ritorna <em>true</em> se l'oggetto è <em>null</em> o uguale a zero
	 */
	public static boolean isNullOrZero(Integer arg0) {
		return arg0 == null || arg0.toString().equals(STRING_ZERO);
	}
	
	/**
	 * Verifica se un oggetto di tipo <code>java.lang.Long</code> è <em>null</em> o uguale a zero
	 * @param arg0	L'oggetto passato in input
	 * @return		<code>boolean</code> Ritorna <em>true</em> se l'oggetto è <em>null</em> o uguale a zero
	 */
	public static boolean isNullOrZero(Long arg0) {
		return arg0 == null || arg0.toString().equals(STRING_ZERO);
	}
	
	/**
	 * Verifica la validità della data
	 * @param arg0	La data nel formato <em>java.util.Date</em>
	 * @return		<code>boolean</code> Ritorna <em>true</em> se la data è valida
	 */
	public static boolean isValidDate(Date arg0) {
		String data = DateUtil.dateFormat(arg0, DateUtil.DATE_FORMAT_STANDARD);
		SimpleDateFormat df = new SimpleDateFormat(DateUtil.DATE_FORMAT_STANDARD);
		try {
			df.parse(data);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	/**
	 * Verifica se una data è futura rispetto alla data odierna
	 * @param arg0	La data nel formato <em>java.util.Date</em>
	 * @return		<code>boolean</code> Ritorna <em>true</em> se la data è futura rispetto alla data odierna
	 */
	public static boolean isFutureDate(Date arg0) {
		// -- Date attuale
		Calendar oggi = Calendar.getInstance();
		oggi.set(oggi.get(Calendar.YEAR), oggi.get(Calendar.MONTH), oggi.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		// -- Data confronto
		Calendar confronto = Calendar.getInstance();
		confronto.setTime(arg0);
		confronto.set(confronto.get(Calendar.YEAR), confronto.get(Calendar.MONTH), confronto.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		if ( confronto.after(oggi) ) {
			return true;
		}
		return false;
	}
	

}
