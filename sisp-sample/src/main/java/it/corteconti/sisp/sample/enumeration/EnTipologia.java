package it.corteconti.sisp.sample.enumeration;

/**
 * Elenco delle Tipologie.
 * @version 1.0
 */
public enum EnTipologia {
	
	
	AGGIO("1"),
	QUOTE_INESIGIBILI("2"),
	ALTRO("3"),
	ORDINARIA_DIRETTA_ALTRI_ENTI("4"),
	ORDINARIA_DIRETTA_STATO("5"),
	PRIVILEGIATA_DIRETTA_ALTRI_ENTI("6"),
	PRIVILEGIATA_DIRETTA_STATO("7"),
	REVERSIBILITA_ORDINARIA("8"),
	REVERSIBILITA_PRIVILEGIATA("9"),
	APPARTENENTI_ALLA_RSI("10"),
	CIVILI("11"),
	COLLATERALI("12"),
	CONIUGE_SUPERSTITE("13"),
	GENITORI_ED_ALLEVATORI("14"),
	MILITARI_ED_EQUIPARATI("15"),
	ORFANI_MAGGIORENNI("16"),
	PERSEGUITATI_POLITICI_RAZZIALI("17"),
	AVVERSO_ELENCHI_ISTAT("91"),
	PIANI_DI_RIEQUILIBRIO("92"),
	RENDICONTI_GRUPPI_CONSILIARI_REGIONALI("93"),
	DELIBERE_DI_IRREGOLARITA("94"),
	DELIBERE_DI_VIOLAZIONE_PATTO_DI_STABILITA("95"),
	CCNL_FONDAZIONI_LIRICHE("96"),
	ARGOMENTO_DEL_GIUDIZIO("97"),
	NON_PRESENTE("999");
	
	
	/**
	 * Attributo
	 */
	final private String localValue;
	
	
	/**
	 * Costruttore parametrico
	 */
	private EnTipologia(String arg0) {
		this.localValue = arg0;
	}
	
	
	/**
	 * Metodo getter
	 */
	public String getValue() {
		return this.localValue;
	}
	
	
}
