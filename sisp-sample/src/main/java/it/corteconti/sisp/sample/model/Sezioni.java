package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "SEZIONI")
public class Sezioni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CODICE_SEZIONE")
	private Long id;
	
	@Column(name="DESCRIZIONE_SEZIONE")
	private String descrizioneSezione;
	
	@Column(name="LIVELLO")
	private Integer livello;
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("descrizioneSezione", descrizioneSezione)
				.append("livello", livello)
				.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizioneSezione() {
		return descrizioneSezione;
	}

	public void setDescrizioneSezione(String descrizioneSezione) {
		this.descrizioneSezione = descrizioneSezione;
	}

	public Integer getLivello() {
		return livello;
	}

	public void setLivello(Integer livello) {
		this.livello = livello;
	}

	
	
}
