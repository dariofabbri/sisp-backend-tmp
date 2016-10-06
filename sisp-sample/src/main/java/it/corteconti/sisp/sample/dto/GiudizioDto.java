package it.corteconti.sisp.sample.dto;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.corteconti.sisp.util.ValidationUtil;

/**
 * Dto relativo alla tabella <em>GIUDIZIO</em>
 * @versione 1.0
 */
@ApiModel
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
	
	
	
	@ApiModelProperty(position = 1, required = true)
	public Long getIdGiudizio() {
		return idGiudizio;
	}

	public void setIdGiudizio(Long idGiudizio) {
		this.idGiudizio = idGiudizio;
	}

	@ApiModelProperty(position = 2, required = true)
	public Long getNumeroGiudizio() {
		return numeroGiudizio;
	}

	public void setNumeroGiudizio(Long numeroGiudizio) {
		this.numeroGiudizio = numeroGiudizio;
	}
	
	@ApiModelProperty(position = 3, required = true, example = "1476914400000", notes = "data espressa in millisecondi")
	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}
	
	@ApiModelProperty(position = 4, required = false)
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@ApiModelProperty(position = 5, required = false)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@ApiModelProperty(position = 6, required = false)
	public SezioneDto getSezione() {
		return sezione;
	}

	public void setSezione(SezioneDto sezione) {
		this.sezione = sezione;
	}

	@ApiModelProperty(position = 7, required = false)
	public String getTestoQuesito() {
		return testoQuesito;
	}

	public void setTestoQuesito(String testoQuesito) {
		this.testoQuesito = testoQuesito;
	}

	@ApiModelProperty(position = 8, required = false)
	public String getRiferimentoAtto() {
		return riferimentoAtto;
	}

	public void setRiferimentoAtto(String riferimentoAtto) {
		this.riferimentoAtto = riferimentoAtto;
	}

	@ApiModelProperty(position = 9, required = true)
	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

	@ApiModelProperty(position = 10, required = true)
	public TipoDto getTipo() {
		return tipo;
	}

	public void setTipo(TipoDto tipo) {
		this.tipo = tipo;
	}

	@ApiModelProperty(position = 11, required = false)
	public TipologiaDto getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaDto tipologia) {
		this.tipologia = tipologia;
	}

	@ApiModelProperty(position = 12, required = false)
	public List<OggettoDto> getOggetti() {
		return oggetti;
	}

	public void setOggetti(List<OggettoDto> oggetti) {
		this.oggetti = oggetti;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("idGiudizio", idGiudizio)
				.append("numero", numeroGiudizio)
				.append("dataApertura", dataApertura)
				.append("descrizione", descrizione)
				.append("note", note)
				.append("testoQuesito", testoQuesito)
				.append("riferimentoAtto", riferimentoAtto)
				.append("sezione", sezione)
				.append("idCategoria", categoria)
				.append("tipo", tipo )
				.append("tipologia", tipologia)
				.append("size oggetti", ValidationUtil.isNull(oggetti) ? "null" : oggetti.size() )
				.toString();
	}
	
	
}
