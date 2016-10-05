package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Dto relativo alla tabella <em>TIPO</em>
 * @versione 1.0
 */
public class TipoDto {

	private String idTipo;
	private String descrizioneTipo;
	
	
	public String getIdTipo() {
		return idTipo;
	}
	
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	
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
