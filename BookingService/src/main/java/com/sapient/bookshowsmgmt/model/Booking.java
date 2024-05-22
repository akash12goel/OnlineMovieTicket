package com.sapient.bookshowsmgmt.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("bookingId")
	private Long id;

	@NotNull(message = "User ID is required")
	@JsonProperty("userId")
	private Long userId;

	@NotNull(message = "Show ID is required")
	@JsonProperty("showId")
	private Long showId;

	@NotNull(message = "Seat Ids is required")
	@JsonProperty("seatNumbers")
	private List<Long> seatIds;

	@NotNull(message = "Booking time is required")
	@JsonProperty("bookingTime")
	private LocalDateTime bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getShowId() {
		return showId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public List<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	// Getters and setters
}
