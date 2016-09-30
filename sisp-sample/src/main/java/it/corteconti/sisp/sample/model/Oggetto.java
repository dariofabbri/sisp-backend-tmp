package it.corteconti.sisp.sample.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * <p>La classe rappresenta l'entità oggetto<p>
 * @version 1.0
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
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GIUDIZIO_OGGETTO", 
             joinColumns = { @JoinColumn(name = "CODICE_OGGETTO") }, 
             inverseJoinColumns = { @JoinColumn(name = "ID_GIUDIZIO") })
	private List<Giudizio> listaGiudizi;
	
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
	public Sezione getSezione() {
		return sezione;
	}
	public void setSezione(Sezione sezione) {
		this.sezione = sezione;
	}
	public List<Giudizio> getListaGiudizi() {
		return listaGiudizi;
	}
	public void setListaGiudizi(List<Giudizio> listaGiudizi) {
		this.listaGiudizi = listaGiudizi;
	}

}
