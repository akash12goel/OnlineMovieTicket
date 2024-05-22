package com.sapient.bookshowsmgmt.response;

import java.util.List;

import lombok.Data;

@Data
public class BookingSeatResponse {

	private String theaterName;
	private String screenName;

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

	public List<Integer> getBookedSeatNumber() {
		return bookedSeatNumber;
	}

	public void setBookedSeatNumber(List<Integer> bookedSeatNumber) {
		this.bookedSeatNumber = bookedSeatNumber;
	}

}
