package it.corteconti.sisp.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Helper per le date
 * @version 1.0
 */
public class DateUtil {
	
	
	// -- Costanti
	public static final String DATE_FORMAT_STANDARD = "dd/MM/yyyy";
	public static final String DATE_FORMAT_EXTENDED = "dd/MM/yyyy HH:mm";
	
	
	/**
     * Costruttore privato, impedisce l'instanziazione
     */
	private DateUtil() {}
	
	
	/**
	 * Ritorna il mese di una data
	 * @param arg0	La data nel formato <em>java.util.Date</em>
	 * @return		<em>int</em>
	 */
	public static int getMonth(Date arg0) {
		Calendar c = new GregorianCalendar();
		c.setTime(arg0);
		int m = c.get(Calendar.MONTH);
		m = m + 1;
		return m;
	}
	
	/**
	 * Ritorna il giorno di una data
	 * @param arg0	La data nel formato <em>java.util.Date</em>
	 * @return		<em>int</em>
	 */
	public static int getDay(Date arg0) {
		Calendar c = new GregorianCalendar();
		c.setTime(arg0);
		int g = c.get(Calendar.DAY_OF_MONTH);
		return g;
	}
	
	/**
	 * Ritorna l'anno di una data
	 * @param arg0	La data nel formato <em>java.util.Date</em>
	 * @return		<em>int</em>
	 */
	public static int getYear(Date arg0) {
		Calendar c = new GregorianCalendar();
		c.setTime(arg0);
		int y = c.get(Calendar.YEAR);
		return y;
	}
	
	/**
	 * Ritorna la data secondo il formato specificato
	 * @param arg0	La data nel formato <em>java.lang.String</em>
	 * @param arg1	Il formato della data
	 * @return		<em>java.util.Date</em>
	 */
	public static Date dateFormat(String arg0, String arg1) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(arg1);
		Date date = formatter.parse(arg0, new ParsePosition(0));
		return date;
	}
	
	/**
	 * Ritorna la data in stringa e secondo il formato specificato
	 * @param arg0	La data nel formato <em>java.util.Date</em>
	 * @param arg1	Il formato della data
	 * @return		<em>java.util.Date</em>
	 */
	public static String dateFormat(Date arg0, String arg1) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(arg1);
		String strDate = formatter.format(arg0);
		return strDate;
	}
	
	
}
