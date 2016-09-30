package it.corteconti.sisp.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Entità relativa alla tabella <em>THING</em>
 * @versione 1.0
 */
@Entity
@Table(name = "THING")
public class Thing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="LASTUPDATE")
	private Date lastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("description", description)
				.append("lastUpdate", lastUpdate)
				.toString();
	}
}
