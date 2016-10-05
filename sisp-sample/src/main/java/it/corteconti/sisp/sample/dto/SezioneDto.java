package it.corteconti.sisp.sample.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Dto che rappresenta un oggetto di tipo Sezione<p>
 * @version 1.0
 *
 */
public class SezioneDto {

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

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", idSezione)
				.append("descrizioneSezione", descrizioneSezione)
				.append("livelloSezione", livelloSezione)
				.toString();
	}
}