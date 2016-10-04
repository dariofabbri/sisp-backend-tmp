package it.corteconti.sisp.sample.dto;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GiudizioDto {

	private Long idGiudizio;
	private Long numeroGiudizio;
	private Date dataApertura;
	private String descrizione;
	private String note;
	private SezioneDto sezione;
	private String testoQuesito;
	private String riferimentoAtto;
	private CategoriaDto categoria;
	private TipoDto tipo;
	private TipologiaDto tipologia;
	private List<OggettoDto> oggetti;
	
	
	
	
	public Long getIdGiudizio() {
		return idGiudizio;
	}

	public void setIdGiudizio(Long idGiudizio) {
		this.idGiudizio = idGiudizio;
	}

	public Long getNumeroGiudizio() {
		return numeroGiudizio;
	}

	public void setNumeroGiudizio(Long numeroGiudizio) {
		this.numeroGiudizio = numeroGiudizio;
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

	public SezioneDto getSezione() {
		return sezione;
	}

	public void setSezione(SezioneDto sezione) {
		this.sezione = sezione;
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

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

	public TipoDto getTipo() {
		return tipo;
	}

	public void setTipo(TipoDto tipo) {
		this.tipo = tipo;
	}

	public TipologiaDto getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaDto tipologia) {
		this.tipologia = tipologia;
	}

	public List<OggettoDto> getOggetti() {
		return oggetti;
	}

	public void setOggetti(List<OggettoDto> oggetti) {
		this.oggetti = oggetti;
	}
	
	
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("idGiudizio", idGiudizio)
				.append("numero", numeroGiudizio)
				.append("dataApertura", dataApertura)
				.append("descrizione", descrizione)
				.append("note", note)
				.append("testoQuesito", testoQuesito)
				.append("riferimentoAtto", riferimentoAtto)
				.append("idSezione", (sezione == null ? "" : sezione.getIdSezione()) )
				.append("idCategoria", (categoria == null ? "" : categoria.getIdCategoria()) )
				.append("idTipo", (tipo == null ? "" : tipo.getIdTipo()) )
				.append("idTipologia", (tipologia == null ? "" : tipologia.getIdTipologia()))
				.append("size oggettoDtoList", oggetti.size())
				.toString();
	}
	
	
}
