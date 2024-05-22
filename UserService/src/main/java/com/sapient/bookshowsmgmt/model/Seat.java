package com.sapient.bookshowsmgmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer seatNumber;
	@ManyToOne
	@JoinColumn(name = "moviehall_id", nullable = false)
	private Screen screen;

	@Enumerated(EnumType.STRING)
	private String seatStatus;

}