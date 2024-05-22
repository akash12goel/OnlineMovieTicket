package com.sapient.bookshowsmgmt.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("showId")
	private Long id;

	@NotNull(message = "Movie ID is required")
	@JsonProperty("movieId")
	private Long movieId;

	@NotNull(message = "Theater ID is required")
	@JsonProperty("theaterId")
	private Long theaterId;

	@NotNull(message = "Screen ID is required")
	@JsonProperty("screenId")
	private Long screenId;

	@NotNull(message = "Show time is required")
	@JsonProperty("showTime")
	private LocalDateTime showTime;

	@NotNull(message = "Number of available seats is required")
	@JsonProperty("availableSeats")
	private Integer availableSeats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

}
