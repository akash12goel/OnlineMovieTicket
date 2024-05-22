package com.sapient.bookshowsmgmt.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "User ID is required")
	private Long userId;

	@NotNull(message = "Show ID is required")
	private Long showId;

	@NotNull(message = "Number of seats is required")
	private Integer numberOfSeats;

	@NotNull(message = "Booking time is required")
	private LocalDateTime bookingTime;

	// Getters and setters
}
