package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * Dto relativo alla tabella <em>SEZIONI</em>
 * @version 1.0
 */
@ApiModel
public class SezioneDto {

	
	private Long idSezione;
	private String descrizioneSezione;
	private Integer livelloSezione;

	
	@ApiModelProperty(position = 1, required = false)
	public Long getIdSezione() {
		return idSezione;
	}

	public void setIdSezione(Long idSezione) {
		this.idSezione = idSezione;
	}

	@ApiModelProperty(position = 2, required = false)
	public String getDescrizioneSezione() {
		return descrizioneSezione;
	}

	public void setDescrizioneSezione(String descrizioneSezione) {
		this.descrizioneSezione = descrizioneSezione;
	}

	@ApiModelProperty(position = 3, required = false)
	public Integer getLivelloSezione() {
		return livelloSezione;
	}

	public void setLivelloSezione(Integer livelloSezione) {
		this.livelloSezione = livelloSezione;
	}

	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", idSezione)
				.append("descrizioneSezione", descrizioneSezione)
				.append("livelloSezione", livelloSezione)
				.toString();
	}
}