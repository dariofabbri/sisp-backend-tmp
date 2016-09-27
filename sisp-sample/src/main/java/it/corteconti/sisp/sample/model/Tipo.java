package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "TIPO")
public class Tipo {

	@Column(name="CODICE_TIPO")
	private String codiceTipo;
	
	@Column(name="DESCRIZIONE_TIPO")
	private String descrizioneTipo;
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceTipo", codiceTipo)
				.append("descrizioneTipo", descrizioneTipo)
				.toString();
	}
	
	
	public String getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(String codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	public String getDescrizioneTipo() {
		return descrizioneTipo;
	}

	public void setDescrizioneTipo(String descrizioneTipo) {
		this.descrizioneTipo = descrizioneTipo;
	}

	
}
