package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "TIPO")
public class Tipo {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "CODICE_TIPO")
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
