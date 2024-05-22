package com.sapient.bookshowsmgmt.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("theaterName")
	@NotEmpty(message = "Theater Name is required")
	@Size(min = 1, max = 100, message = "Theater Name must be between 1 and 10" + "0 characters")
	private String theaterName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	@JsonProperty("address")
	private Address address;

	// @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval =
	// true, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "theater_id")
	@JsonProperty("screens")
	private Set<Screen> screens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Screen> getScreens() {
		return screens;
	}

	public void setScreens(Set<Screen> screens) {
		this.screens = screens;
	}
	

}
