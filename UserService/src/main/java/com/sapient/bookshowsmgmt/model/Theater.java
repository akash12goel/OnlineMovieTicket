package com.sapient.bookshowsmgmt.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required")
	@Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
	private String name;

	@NotEmpty(message = "Address is required")
	private Address address;

	@OneToMany(mappedBy = "theater")
	private Set<Screen> screenList;

}
