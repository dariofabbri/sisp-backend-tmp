package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Dto che rappresenta un oggetto di tipo Oggetto<p>
 * @version 1.0
 *
 */
public class CategoriaDto {

	private String idCategoria; 
	private String descrizioneCategoria;
	
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescrizioneCategoria() {
		return descrizioneCategoria;
	}
	public void setDescrizioneCategoria(String descrizioneCategoria) {
		this.descrizioneCategoria = descrizioneCategoria;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("idCategoria", idCategoria)
				.append("descrizioneCategoria", descrizioneCategoria)
				.toString();
	}
	
	
}
