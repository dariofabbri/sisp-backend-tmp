package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>Dto che rappresenta un oggetto di tipo Oggetto<p>
 * @version 1.0
 *
 */
public class OggettoDto {

	private Long idOggetto;
	private String descrizioneOggetto;
	
	public Long getIdOggetto() {
		return idOggetto;
	}
	public void setIdOggetto(Long idOggetto) {
		this.idOggetto = idOggetto;
	}
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
