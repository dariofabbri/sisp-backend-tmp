package it.corteconti.sisp.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "CATEGORIA_TIPO_TIPOLOGIA")
public class CategoriaTipoTipologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CATEGORIA_TIPO_TIPOLOGIA")
	private Long id;
	
	@Column(name="CODICE_LIVELLO_AOO")
	private String codiceLivelloAoo;
	
	@Column(name="CODICE_CATEGORIA")
	private String codiceCategoria;	
	
	@Column(name="CODICE_TIPO")
	private String codiceTipo;
	
	@Column(name="CODICE_TIPOLOGIA")
	private String codiceTipologia;
	
	@Column(name="CODICE_AMBITO")
	private String codiceAmbito;	
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("codiceLivelloAoo", codiceLivelloAoo)
				.append("codiceCategoria", codiceCategoria)
				.append("codiceTipo", codiceTipo)
				.append("codiceTipologia", codiceTipologia)
				.append("codiceAmbito", codiceAmbito)
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

	public String getCodiceCategoria() {
		return codiceCategoria;
	}

	public void setCodiceCategoria(String codiceCategoria) {
		this.codiceCategoria = codiceCategoria;
	}

	public String getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(String codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	public String getCodiceTipologia() {
		return codiceTipologia;
	}

	public void setCodiceTipologia(String codiceTipologia) {
		this.codiceTipologia = codiceTipologia;
	}

	public String getCodiceAmbito() {
		return codiceAmbito;
	}

	public void setCodiceAmbito(String codiceAmbito) {
		this.codiceAmbito = codiceAmbito;
	}
	
	
	
}
