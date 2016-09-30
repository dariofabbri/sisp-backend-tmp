package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Classe che modella la tabbella Oggetto
 *
 */
@Entity
@Table(name = "OGGETTO")
public class Oggetto {

	@Id
	@Column(name = "CODICE_OGGETTO")
	private Long codiceOggetto;
	
	@Column(name = "DESCRIZIONE_OGGETTO")
	private String descrizioneOggetto;
	
	@ManyToOne
    @JoinColumn(name="CODICE_SEZIONE")
	private Sezione sezione;
	
	public Long getCodiceOggetto() {
		return codiceOggetto;
	}
	public void setCodiceOggetto(Long codiceOggetto) {
		this.codiceOggetto = codiceOggetto;
	}
	public String getDescrizioneOggetto() {
		return descrizioneOggetto;
	}
	public void setDescrizioneOggetto(String descrizioneOggetto) {
		this.descrizioneOggetto = descrizioneOggetto;
	}

}
