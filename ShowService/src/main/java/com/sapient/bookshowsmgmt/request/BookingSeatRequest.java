package com.sapient.bookshowsmgmt.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookingSeatRequest {
	@JsonProperty("screenId")
	private Long screenId;
	@JsonProperty("seatIds")
	private List<Long> seatIds;

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public List<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}

}
