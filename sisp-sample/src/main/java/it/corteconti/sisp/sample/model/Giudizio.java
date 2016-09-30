package it.corteconti.sisp.sample.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entità relativa alla tabella <em>GIUDIZIO</em>
 * @versione 1.0
 */
@Entity
@Table(name = "GIUDIZIO")
public class Giudizio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_GIUDIZIO")
	private Long id;
	
	@Column(name="NUMERO")
	private Long numero;
	
	@Column(name="DATA_APERTURA")
	private Date dataApertura;
	
	@Column(name="DESCRIZIONE")
	private String descrizione;
	
	@Column(name="NOTE")
	private String note;
	
	@Column(name="AOO")
	private Long aoo;
	
	@ManyToMany(mappedBy="listaGiudizi")
	private List<Oggetto> listaOggetti;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORIA_CODICE_CATEGORIA")
	private Categoria categoria;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_CODICE_TIPO")
	private Tipo tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPOLOGIA_CODICE_TIPOLOGIA")
	private Tipologia tipologia;
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("numero", numero)
				.append("dataApertura", dataApertura)
				.append("descrizione", descrizione)
				.append("note", note)
				.append("aoo", aoo)
				.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getAoo() {
		return aoo;
	}

	public void setAoo(Long aoo) {
		this.aoo = aoo;
	}

	public List<Oggetto> getListaOggetti() {
		return listaOggetti;
	}

	public void setListaOggetti(List<Oggetto> listaOggetti) {
		this.listaOggetti = listaOggetti;
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

	
	
}
