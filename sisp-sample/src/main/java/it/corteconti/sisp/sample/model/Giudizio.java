package it.corteconti.sisp.sample.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@Column(name="TESTO_QUESITO")
	private String testoQuesito;
	
	@Column(name="RIFERIMENTO_ATTO")
	private String riferimentoAtto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORIA_CODICE_CATEGORIA")
	private Categoria categoria;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_CODICE_TIPO")
	private Tipo tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPOLOGIA_CODICE_TIPOLOGIA")
	private Tipologia tipologia;
	
	@Column(name="CODICE_SEZIONE")
	private Long idSezione;
	
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JoinTable(name = "GIUDIZIO_OGGETTO",
	        joinColumns = @JoinColumn(name = "ID_GIUDIZIO", referencedColumnName = "ID_GIUDIZIO"),
	        inverseJoinColumns = @JoinColumn(name = "CODICE_OGGETTO", referencedColumnName = "CODICE_OGGETTO"))
	private List<Oggetto> listaOggetti;
	 
	 
	
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

	public String getTestoQuesito() {
		return testoQuesito;
	}

	public void setTestoQuesito(String testoQuesito) {
		this.testoQuesito = testoQuesito;
	}

	public String getRiferimentoAtto() {
		return riferimentoAtto;
	}

	public void setRiferimentoAtto(String riferimentoAtto) {
		this.riferimentoAtto = riferimentoAtto;
	}

	public Long getIdSezione() {
		return idSezione;
	}

	public void setIdSezione(Long idSezione) {
		this.idSezione = idSezione;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("numero", numero)
				.append("dataApertura", dataApertura)
				.append("descrizione", descrizione)
				.append("note", note)
				.append("testoQuesito", testoQuesito)
				.append("riferimentoAtto", riferimentoAtto)
				.append("idSezione", idSezione)
				.append("idCategoria", categoria == null ? "" : categoria.getCodiceCategoria())
				.append("idTipo", tipo == null ? "" : tipo.getCodiceTipo())
				.append("idTipologia", tipologia == null ? "" : tipologia.getCodiceTipologia())
				.append("size listaOggetti", listaOggetti.size())
				.toString();
	}
	
	
}
