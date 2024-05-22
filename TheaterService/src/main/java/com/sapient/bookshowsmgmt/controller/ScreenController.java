package com.sapient.bookshowsmgmt.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bookshowsmgmt.constants.SeatStatus;
import com.sapient.bookshowsmgmt.model.Screen;
import com.sapient.bookshowsmgmt.request.BookingSeatRequest;
import com.sapient.bookshowsmgmt.response.BookingSeatResponse;
import com.sapient.bookshowsmgmt.service.ScreenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/screen")
public class ScreenController {
	@Autowired
	private ScreenService screenService;

	@GetMapping("/{theaterId}")
	public List<Screen> getMovieHallbyTheaterId(@PathVariable long theaterId) {
		return screenService.getScreenByTheaterId(theaterId);
	}

	@PostMapping("/{theaterId}")
	public Screen addScreen(@Valid @RequestBody Screen screen, @PathVariable long theaterId) {
		return screenService.addScreen(screen);
	}

	@GetMapping("/findSeatByScreenId/{screenId}")
	public Screen findAvailableSeatsInScreen(@PathVariable long screenId) {
		return screenService.findAvailableSeatsInScreen(screenId);
	}

	@GetMapping("/findSeastByTheaterId/{theaterId}")
	public List<Screen> findAvailableSeatsInTheater(@PathVariable long theaterId) {
		return screenService.findAvailableSeatsInTheater(theaterId);
	}

	/*
	 * @PutMapping("/reserveFinalSeats") public Screen
	 * reserveFinalSeats(@Valid @RequestBody Screen screen) { return
	 * screenService.bookedSeats(screen).get();
	 * 
	 * }
	 */

	@PatchMapping("/reserveFinalSeats")
	public BookingSeatResponse reserveFinalSeats(@Valid @RequestBody BookingSeatRequest bookingSeatRequest) {
		Long screenId = bookingSeatRequest.getScreenId();
		List<Long> seatIds = bookingSeatRequest.getSeatIds();

		int update = screenService.bookedSeats(screenId, seatIds);
		Screen screenUpdate = screenService.getScreenById(screenId);
		// System.out.println(screenUpdate.getScreenName());
		// System.out.println(screenUpdate.getTheater().getTheaterName());
		List<Integer> seatNumbers = screenUpdate.getSeats().stream()
				.filter(e -> seatIds.contains(e.getId()) && e.getSeatStatus().equals(SeatStatus.SEAT_BOOKED))
				.map(x -> x.getSeatNumber()).collect(Collectors.toList());
		// seatNumbers.stream().forEach(x -> System.out.println(x));
		BookingSeatResponse bookingSeatResponse = new BookingSeatResponse();
		bookingSeatResponse.setScreenName(screenUpdate.getScreenName());
		bookingSeatResponse.setTheaterName(screenUpdate.getTheater().getTheaterName());
		bookingSeatResponse.setBookedSeatNumber(seatNumbers);
		return bookingSeatResponse;

	}

	@PutMapping("/reserveTentativeSeats")
	public Screen reserveTentativeSeats(@Valid @RequestBody BookingSeatRequest bookingSeatRequest) {
		Long screenId = bookingSeatRequest.getScreenId();
		List<Long> seatIds = bookingSeatRequest.getSeatIds();
		return screenService.bookedTentativeSeats(screenId, seatIds).get();

	}
}
