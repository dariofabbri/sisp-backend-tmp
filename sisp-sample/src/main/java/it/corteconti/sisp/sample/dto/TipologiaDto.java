package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Dto che rappresenta un oggetto di tipo Tipologia<p>
 * @version 1.0
 *
 */
public class TipologiaDto {

	private String idTipologia;
	private String descrizioneTipologia;
	public String getIdTipologia() {
		return idTipologia;
	}
	public void setIdTipologia(String idTipologia) {
		this.idTipologia = idTipologia;
	}
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
