package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "AMBITO")
public class Ambito {

	@Column(name="CODICE_AMBITO")
	private String codiceAmbito;
	
	@Column(name="DESCRIZIONE_AMBITO")
	private String descrizioneAmbito;
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceAmbito", codiceAmbito)
				.append("descrizioneAmbito", descrizioneAmbito)
				.toString();
	}

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
	
	

}
