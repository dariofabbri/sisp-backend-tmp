package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dto relativo alla tabella <em>AMBITO</em>
 * @version 1.0
 */
@ApiModel
public class AmbitoDto {
	

	private String codiceAmbito; 
	private String descrizioneAmbito;
	
	
	@ApiModelProperty(position = 1, required = true)
	public String getCodiceAmbito() {
		return codiceAmbito;
	}
	
	public void setCodiceAmbito(String codiceAmbito) {
		this.codiceAmbito = codiceAmbito;
	}
	
	@ApiModelProperty(position = 2, required = false)
	public String getDescrizioneAmbito() {
		return descrizioneAmbito;
	}
	
	public void setDescrizioneAmbito(String descrizioneAmbito) {
		this.descrizioneAmbito = descrizioneAmbito;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceAmbito", codiceAmbito)
				.append("descrizioneAmbito", descrizioneAmbito)
				.toString();
	}
	
	
}
