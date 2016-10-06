package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dto relativo alla tabella <em>TIPO</em>
 * @versione 1.0
 */
@ApiModel
public class TipoDto {

	private String idTipo;
	private String descrizioneTipo;
	
	
	@ApiModelProperty(position = 1, required = true)
	public String getIdTipo() {
		return idTipo;
	}
	
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	
	@ApiModelProperty(position = 2, required = false)
	public String getDescrizioneTipo() {
		return descrizioneTipo;
	}
	
	public void setDescrizioneTipo(String descrizioneTipo) {
		this.descrizioneTipo = descrizioneTipo;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("idTipo", idTipo)
				.append("descrizioneTipo", descrizioneTipo)
				.toString();
	}
	
	
}
