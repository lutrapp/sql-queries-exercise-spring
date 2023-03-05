package com.lutrapp.queries.dto;

import com.lutrapp.queries.projections.ArtistMinProjection;

public class ArtistMinDTO {
	
	private String name;
	
	public ArtistMinDTO() {
	}

	public ArtistMinDTO(String name) {
		this.name = name;
	}
	
	public ArtistMinDTO(ArtistMinProjection projection) {
		this.name = projection.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
