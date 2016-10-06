package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dto relativo alla tabella <em>OGGETTO</em>
 * @version 1.0
 */
@ApiModel
public class OggettoDto {

	private Long idOggetto;
	private String descrizioneOggetto;
	
	
	@ApiModelProperty(position = 1, required = false)
	public Long getIdOggetto() {
		return idOggetto;
	}
	
	public void setIdOggetto(Long idOggetto) {
		this.idOggetto = idOggetto;
	}
	
	@ApiModelProperty(position = 2, required = false)
	public String getDescrizioneOggetto() {
		return descrizioneOggetto;
	}
	
	public void setDescrizioneOggetto(String descrizioneOggetto) {
		this.descrizioneOggetto = descrizioneOggetto;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("idOggetto", idOggetto)
				.append("descrizioneOggetto", descrizioneOggetto)
				.toString();
	}
	
	
}
