package it.corteconti.sisp.sample.model;

import java.util.Date;

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
	@JoinColumn(name="CODICE_CATEGORIA")
	private Categoria categoria;	
	
	@Column(name="CODICE_TIPO")
	private Tipo tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODICE_TIPOLOGIA")
	private Tipologia tipologia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODICE_AMBITO")
	private Ambito ambito;	
	
//	public String toString() {
//		return new ToStringBuilder(this)
//				.append("id", id)
//				.append("codiceLivelloAoo", codiceLivelloAoo)
//				.append("codiceCategoria", codiceCategoria)
//				.append("codiceTipo", codiceTipo)
//				.append("codiceTipologia", codiceTipologia)
//				.append("codiceAmbito", codiceAmbito)
//				.toString();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
}
