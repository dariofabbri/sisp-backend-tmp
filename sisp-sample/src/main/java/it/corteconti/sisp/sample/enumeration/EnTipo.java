package it.corteconti.sisp.sample.enumeration;

/**
 * Elenco dei Tipi.
 * @version 1.0
 */
public enum EnTipo {
	
	CORREZIONE_ERRORE_MATERIALE(new String("1")),
	SOSPENSIVA(new String("10")),
	ALTRO(new String("11")),
	ISTANZA_DI_NULLITÀ(new String("12")),
	ISTANZA_DI_DEFINIZIONE_AGEVOLATA(new String("13")),
	DISSEQUESTRO(new String("15")),
	INTERPRETAZIONE(new String("3")),
	MERITO(new String("4")),
	OTTEMPERANZA(new String("5")),
	RECLAMO(new String("7")),
	INCIDENTALE(new String("70")),
	REVOCAZIONE(new String("8")),
	SOSPENSIVA_CAUTELARE(new String("80")),
	SEQUESTRO(new String("9")),
	DECISIONE(new String("90"));
	
	/**
	 * Attributo
	 */
	final private String localValue;
	
	
	/**
	 * Costruttore parametrico
	 */
	private EnTipo(String arg0) {
		this.localValue = arg0;
	}
	
	
	/**
	 * Metodo getter
	 */
	public String getValue() {
		return this.localValue;
	}
	
	
}
