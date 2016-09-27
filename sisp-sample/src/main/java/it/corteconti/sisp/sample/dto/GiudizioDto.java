package it.corteconti.sisp.sample.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GiudizioDto {

	private Long id;
	private Long numero;
	private Date dataApertura;
	private String descrizione;
	private String note;
	private Long aoo;

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
}