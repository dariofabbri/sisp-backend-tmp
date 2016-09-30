package it.corteconti.sisp.sample.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "CONTATORI")
public class Contatore {
	
	@Id
	@Column(name="CODICE_CONTATORE")
	private Long codiceContatore;
	
	@Column(name="VALORE_CONTATORE")
	private Long valoreContatore;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SEZIONI_CONTATORI", 
             joinColumns = { @JoinColumn(name = "CODICE_CONTATORE") }, 
             inverseJoinColumns = { @JoinColumn(name = "CODICE_SEZIONE") })
    private List<Sezione> sezioni;
	
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("codiceContatore", codiceContatore)
				.append("valoreContatore", this.valoreContatore)
				.toString();
	}
	
	
	public Long getCodiceContatore() {
		return codiceContatore;
	}
	
	public void setCodiceContatore(Long codiceContatore) {
		this.codiceContatore = codiceContatore;
	}
	
	public Long getValoreContatore() {
		return valoreContatore;
	}
	
	public void setValoreContatore(Long valoreContatore) {
		this.valoreContatore = valoreContatore;
	}
	
	public List<Sezione> getSezioni() {
		return sezioni;
	}
	
	public void setSezioniContatori(List<Sezione> sezioni) {
		this.sezioni = sezioni;
	}
	
	
}
