package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Dto che rappresenta un oggetto di tipo Ambito<p>
 * @version 1.0
 *
 */
public class AmbitoDto {

	private String codiceAmbito; 
	private String descrizioneAmbito;
	
	public String getCodiceAmbito() {
		return codiceAmbito;
	}
	public void setCodiceAmbito(String codiceAmbito) {
		this.codiceAmbito = codiceAmbito;
	}
	public String getDescrizioneAmbito() {
		return descrizioneAmbito;
	}
	public void setDescrizioneAmbito(String descrizioneAmbito) {
		this.descrizioneAmbito = descrizioneAmbito;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceAmbito", codiceAmbito)
				.append("descrizioneAmbito", descrizioneAmbito)
				.toString();
	}
	
	
	
}
