package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SezioniDto {

	private Long idSezione;
	private String descrizioneSezione;
	private Integer livelloSezione;

	public Long getIdSezione() {
		return idSezione;
	}

	public void setIdSezione(Long idSezione) {
		this.idSezione = idSezione;
	}

	public String getDescrizioneSezione() {
		return descrizioneSezione;
	}

	public void setDescrizioneSezione(String descrizioneSezione) {
		this.descrizioneSezione = descrizioneSezione;
	}

	public Integer getLivelloSezione() {
		return livelloSezione;
	}

	public void setLivelloSezione(Integer livelloSezione) {
		this.livelloSezione = livelloSezione;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("id", idSezione)
				.append("descrizioneSezione", descrizioneSezione)
				.append("livelloSezione", livelloSezione)
				.toString();
	}
}