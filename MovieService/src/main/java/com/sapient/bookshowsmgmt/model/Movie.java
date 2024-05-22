package com.sapient.bookshowsmgmt.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sapient.bookshowsmgmt.constants.MovieType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("movieId")
	private Long id;

	@NotEmpty(message = "Movie Title is required")
	@Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@NotEmpty(message = "Movie Genre is required")
	@Size(min = 1, max = 50, message = "Genre must be between 1 and 50 characters")
	@JsonProperty("genre")
	private String genre;

	@NotNull(message = "Duration is required")
	@JsonProperty("duration")
	private Integer duration; // Duration in minutes

	@JsonProperty("releaseDate")
	private Date releaseDate;

	@Enumerated(EnumType.STRING)
	@JsonProperty("movieLanguage")
	private MovieType movieType;

}