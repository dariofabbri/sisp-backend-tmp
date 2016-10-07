package it.corteconti.sisp.sample.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Helper per le validazioni delle date
 * @version 1.0
 */
public class DateValidationUtil {
	
	
	/**
     * Costruttore privato, impedisce l'instanziazione
     */
	private DateValidationUtil() {}
	
	
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
