package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * 
 * <p>La classe rappresenta l'entità categoria<p>
 * @version 1.0
 *
 */
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
	
	@Id
	@Column(name = "CODICE_CATEGORIA")
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
