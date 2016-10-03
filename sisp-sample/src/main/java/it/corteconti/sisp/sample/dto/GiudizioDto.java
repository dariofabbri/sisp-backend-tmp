package it.corteconti.sisp.sample.dto;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GiudizioDto {

	private Long idGiudizio;
	private Long numero;
	private Date dataApertura;
	private String descrizione;
	private String note;
	private SezioneDto sezioneDto;
	private String testoQuesito;
	private String riferimentoAtto;
	private CategoriaDto categoriaDto;
	private TipoDto tipoDto;
	private TipologiaDto tipologiaDto;
	private List<OggettoDto> oggettoDtoList;
	
	
	
	public Long getIdGiudizio() {
		return idGiudizio;
	}
	public void setIdGiudizio(Long idGiudizio) {
		this.idGiudizio = idGiudizio;
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
	public SezioneDto getSezioneDto() {
		return sezioneDto;
	}
	public void setSezioneDto(SezioneDto sezioneDto) {
		this.sezioneDto = sezioneDto;
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
	public CategoriaDto getCategoriaDto() {
		return categoriaDto;
	}
	public void setCategoriaDto(CategoriaDto categoriaDto) {
		this.categoriaDto = categoriaDto;
	}
	public TipoDto getTipoDto() {
		return tipoDto;
	}
	public void setTipoDto(TipoDto tipoDto) {
		this.tipoDto = tipoDto;
	}
	public TipologiaDto getTipologiaDto() {
		return tipologiaDto;
	}
	public void setTipologiaDto(TipologiaDto tipologiaDto) {
		this.tipologiaDto = tipologiaDto;
	}
	public List<OggettoDto> getOggettoDtoList() {
		return oggettoDtoList;
	}
	public void setOggettoDtoList(List<OggettoDto> oggettoDtoList) {
		this.oggettoDtoList = oggettoDtoList;
	}

	
	public String toString() {
		return new ToStringBuilder(this)
				.append("idGiudizio", idGiudizio)
				.append("numero", numero)
				.append("dataApertura", dataApertura)
				.append("descrizione", descrizione)
				.append("note", note)
				.append("testoQuesito", testoQuesito)
				.append("riferimentoAtto", riferimentoAtto)
				.append("idSezione", sezioneDto.getIdSezione())
				.append("idCategoria", categoriaDto.getIdCategoria())
				.append("idTipo", tipoDto.getIdTipo())
				.append("idTipologia", tipologiaDto.getIdTipologia())
				.append("size oggettoDtoList", oggettoDtoList.size())
				.toString();
	}
	
}