package it.corteconti.sisp.sample.enumeration;

/**
 * Elenco delle Sezioni.
 * @version 1.0
 */
public enum EnSezione {
	
	
	VALLE_D_AOSTA(new Long(1)),
	PIEMONTE(new Long(2)),
	LIGURIA(new Long(3)),
	LOMBARDIA(new Long(4)),
	VENETO(new Long(5)),
	TRENTINO_ALTO_ADIGE_TN(new Long(6)),
	FRIULI_VENEZIA_GIULIA(new Long(7)),
	EMILIA_ROMAGNA(new Long(8)),
	MARCHE(new Long(9)),
	TOSCANA(new Long(10)),
	UMBRIA(new Long(11)),
	LAZIO(new Long(12)),
	ABRUZZO(new Long(13)),
	MOLISE(new Long(14)),
	CAMPANIA(new Long(15)),
	BASILICATA(new Long(16)),
	PUGLIA(new Long(17)),
	CALABRIA(new Long(18)),
	SICILIA(new Long(19)),
	SARDEGNA(new Long(20)),
	TRENTINO_ALTO_ADIGE_BZ(new Long(21)),
	UFFICIO_DEL_RUOLO_GENERALE(new Long(30)),
	PRIMA_SEZIONE_CENTRALE_DI_APPELLO(new Long(31)),
	SECONDA_SEZIONE_CENTRALE_DI_APPELLO(new Long(32)),
	TERZA_SEZIONE_CENTRALE_DI_APPELLO(new Long(33)),
	SEZIONE_DI_APPELLO_PER_LA_SICILIA(new Long(34)),
	PROCURA_GENERALE(new Long(35)),
	PROCURA_GENERALE_PALERMO(new Long(36)),
	SEZIONI_RIUNITE(new Long(40));
	
	
	/**
	 * Attributo
	 */
	final private Long localValue;
	
	
	/**
	 * Costruttore parametrico
	 */
	private EnSezione(Long arg0) {
		this.localValue = arg0;
	}
	
	
	/**
	 * Metodo getter
	 */
	public Long getValue() {
		return this.localValue;
	}
	
	
}
