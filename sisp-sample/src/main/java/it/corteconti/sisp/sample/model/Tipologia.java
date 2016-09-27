package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "TIPOLOGIA")
public class Tipologia {

	@Column(name="CODICE_TIPOLOGIA")
	private String codiceTipologia;
	
	@Column(name="DESCRIZIONE_TIPOLOGIA")
	private String descrizioneTipologia;
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceTipologia", codiceTipologia)
				.append("descrizioneTipologia", descrizioneTipologia)
				.toString();
	}
	
	
	public String getCodiceTipologia() {
		return codiceTipologia;
	}

	public void setCodiceTipologia(String codiceTipologia) {
		this.codiceTipologia = codiceTipologia;
	}

	public String getDescrizioneTipologia() {
		return descrizioneTipologia;
	}

	public void setDescrizioneTipologia(String descrizioneTipologia) {
		this.descrizioneTipologia = descrizioneTipologia;
	}

	
}
