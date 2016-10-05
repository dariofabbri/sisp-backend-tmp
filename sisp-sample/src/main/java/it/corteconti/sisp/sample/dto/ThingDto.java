package it.corteconti.sisp.sample.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ThingDto {

	private Long id;
	private String description;
	private Date lastUpdate;
	
	public ThingDto(){
		//costruttore default
	}

	public ThingDto(Long id, String description, Date lastUpdate) {
		this.id = id;
		this.description = description;
		this.lastUpdate = lastUpdate;
	}

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

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("description", description)
				.append("lastUpdate", lastUpdate)
				.toString();
	}
}