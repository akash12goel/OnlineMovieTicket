package com.sapient.bookshowsmgmt.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Address {

	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String country;

}
