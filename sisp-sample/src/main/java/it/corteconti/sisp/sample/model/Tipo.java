package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entità relativa alla tabella <em>TIPO</em>
 * @versione 1.0
 */
@Entity
@Table(name = "TIPO")
public class Tipo {
	
	@Id
	@Column(name = "CODICE_TIPO")
	private String codiceTipo;
	
	@Column(name="DESCRIZIONE_TIPO")
	private String descrizioneTipo;
	
	
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceTipo", codiceTipo)
				.append("descrizioneTipo", descrizioneTipo)
				.toString();
	}

	
}
