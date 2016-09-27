package it.corteconti.sisp.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "CATEGORIA")
public class Categoria {

	@Column(name="CODICE_CATEGORIA")
	private String codiceCategoria;
	
	@Column(name="DESCRIZIONE_CATEGORIA")
	private String descrizioneCategoria;
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceCategoria", codiceCategoria)
				.append("descrizioneCategoria", descrizioneCategoria)
				.toString();
	}

	public String getCodiceCategoria() {
		return codiceCategoria;
	}

	public void setCodiceCategoria(String codiceCategoria) {
		this.codiceCategoria = codiceCategoria;
	}

	public String getDescrizioneCategoria() {
		return descrizioneCategoria;
	}

	public void setDescrizioneCategoria(String descrizioneCategoria) {
		this.descrizioneCategoria = descrizioneCategoria;
	}
	
	
	
}
