package it.corteconti.sisp.sample.enumeration;

/**
 * Elenco delle Categorie.
 * @version 1.0
 */
public enum EnCategoria {
	
	
	QUESTIONI_DI_MASSIMA("1"),
	CONTO("2"),
	ISTANZA_DI_PARTE("3"),
	PENSIONI_CIVILI("4"),
	PENSIONI_DI_GUERRA("5"),
	PENSIONI_MILITARI("6"),
	CONFLITTI_DI_COMPETENZA("7"),
	RESA_DI_CONTO("8"),
	RESPONSABILITA("9"),
	REGOLAMENTI_DI_COMPETENZA("10");
	
	
	/**
	 * Attributo
	 */
	final private String localValue;
	
	
	/**
	 * Costruttore parametrico
	 */
	private EnCategoria(String arg0) {
		this.localValue = arg0;
	}
	
	
	/**
	 * Metodo getter
	 */
	public String getValue() {
		return this.localValue;
	}
	
	
}
