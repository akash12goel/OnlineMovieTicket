package com.sapient.bookshowsmgmt.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class BookingShowResponse {

	private String theaterName;
	private String screenName;
	private LocalDateTime showTime;

	private List<Integer> bookedSeatNumber;

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public List<Integer> getBookedSeatNumber() {
		return bookedSeatNumber;
	}

	public void setBookedSeatNumber(List<Integer> bookedSeatNumber) {
		this.bookedSeatNumber = bookedSeatNumber;
	}

}
