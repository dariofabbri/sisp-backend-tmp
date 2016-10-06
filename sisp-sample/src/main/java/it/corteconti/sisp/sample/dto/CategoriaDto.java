package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * Dto relativo alla tabella <em>CATEGORIA</em>
 * @version 1.0
 */
@ApiModel
public class CategoriaDto {

	private String idCategoria; 
	private String descrizioneCategoria;
	
	
	@ApiModelProperty(position = 1, required = true)
	public String getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	@ApiModelProperty(position = 2, required = true)
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
