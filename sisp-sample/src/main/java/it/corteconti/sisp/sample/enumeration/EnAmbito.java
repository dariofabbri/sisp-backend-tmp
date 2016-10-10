package it.corteconti.sisp.sample.enumeration;

/**
 * Elenco degli Ambiti.
 * @version 1.0
 */
public enum EnAmbito {
	
	
	PENSIONISTICA("1"),
	CONTABILITA("2"),
	SEZIONI_RIUNITE("3");
	
	
	/**
	 * Attributo
	 */
	final private String localValue;
	
	
	/**
	 * Costruttore parametrico
	 */
	private EnAmbito(String arg0) {
		this.localValue = arg0;
	}
	
	
	/**
	 * Metodo getter
	 */
	public String getValue() {
		return this.localValue;
	}
	
	
}
