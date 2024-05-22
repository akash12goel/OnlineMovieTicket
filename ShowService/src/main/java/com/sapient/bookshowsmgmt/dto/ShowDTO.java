package com.sapient.bookshowsmgmt.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ShowDTO {

	@JsonProperty("showId")
	private Long id;

	@JsonProperty("movieName")
	private String movieTitle;

	@JsonProperty("theaterName")
	private Long theaterName;

	@JsonProperty("screenName")
	private Long screenName;
	@JsonProperty("seats")
	private List<Long> seatList;

	@JsonProperty("showTime")
	private LocalDateTime showTime;

}
