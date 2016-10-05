package it.corteconti.sisp.util;

import java.util.Collection;

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
	

}
