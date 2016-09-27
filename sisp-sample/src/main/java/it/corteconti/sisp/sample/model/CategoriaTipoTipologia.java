package it.corteconti.sisp.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "CATEGORIA_TIPO_TIPOLOGIA")
public class CategoriaTipoTipologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIA_TIPO_TIPOLOGIA")
	private Long id;
	
	@Column(name="CODICE_LIVELLO_AOO")
	private String codiceLivelloAoo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODICE_CATEGORIA", nullable=false)
	private Categoria categoria;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODICE_TIPO", nullable=false)
	private Tipo tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODICE_TIPOLOGIA", nullable=false)
	private Tipologia tipologia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODICE_AMBITO", nullable=false)
	private Ambito ambito;	
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("codiceLivelloAoo", this.codiceLivelloAoo)
				.append("codiceCategoria", this.categoria.getCodiceCategoria())
				.append("codiceTipo", this.tipo.getCodiceTipo())
				.append("codiceTipologia", this.tipologia.getCodiceTipologia())
				.append("codiceAmbito", this.ambito.getCodiceAmbito())
				.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceLivelloAoo() {
		return codiceLivelloAoo;
	}

	public void setCodiceLivelloAoo(String codiceLivelloAoo) {
		this.codiceLivelloAoo = codiceLivelloAoo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public Ambito getAmbito() {
		return ambito;
	}

	public void setAmbito(Ambito ambito) {
		this.ambito = ambito;
	}
	
	
}
