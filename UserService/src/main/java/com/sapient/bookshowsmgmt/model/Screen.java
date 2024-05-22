package com.sapient.bookshowsmgmt.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "name is required")
	@Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
	private String name;

	private String description;

	@ManyToOne
	@JoinColumn(name = "theater_id", nullable = false)
	private Theater theater;

	@OneToMany(mappedBy = "screen")
	private Set<Seat> seatList;

}