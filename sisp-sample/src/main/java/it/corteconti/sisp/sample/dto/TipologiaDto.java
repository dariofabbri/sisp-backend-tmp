package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dto relativo alla tabella <em>TIPOLOGIA</em>
 * @version 1.0
 */
@ApiModel
public class TipologiaDto {
	

	private String idTipologia;
	private String descrizioneTipologia;
	
	
	@ApiModelProperty(position = 1, required = false)
	public String getIdTipologia() {
		return idTipologia;
	}
	
	public void setIdTipologia(String idTipologia) {
		this.idTipologia = idTipologia;
	}
	
	@ApiModelProperty(position = 2, required = false)
	public String getDescrizioneTipologia() {
		return descrizioneTipologia;
	}
	
	public void setDescrizioneTipologia(String descrizioneTipologia) {
		this.descrizioneTipologia = descrizioneTipologia;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("idTipologia", idTipologia)
				.append("descrizioneTipologia", descrizioneTipologia)
				.toString();
	}

}
