package com.sapient.bookshowsmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bookshowsmgmt.model.Show;
import com.sapient.bookshowsmgmt.request.BookingShowRequest;
import com.sapient.bookshowsmgmt.response.BookingShowResponse;
import com.sapient.bookshowsmgmt.service.ShowService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shows")
public class ShowController {
	@Autowired
	private ShowService showService;

	@GetMapping
	public List<Show> getAllShows() {
		return showService.getAllShows();
	}

	@GetMapping("/{id}")
	public Show getShowById(@PathVariable Long id) {
		return showService.getShowById(id);
	}

	@GetMapping("/movie/{movieId}")
	public List<Show> getShowsByMovieId(@PathVariable Long movieId) {
		return showService.getShowsByMovieId(movieId);
	}

	@GetMapping("/theater/{theaterId}")
	public List<Show> getShowsByTheaterId(@PathVariable Long theaterId) {
		return showService.getShowsByTheaterId(theaterId);
	}

	@GetMapping("/time-range")
	public List<Show> getShowsByTimeRange(@RequestParam LocalDateTime startTime, @RequestParam LocalDateTime endTime) {
		return showService.getShowsByTimeRange(startTime, endTime);
	}

	@PostMapping
	public Show addShow(@Valid @RequestBody Show show) {
		return showService.addShow(show);
	}

	@PutMapping("/{id}")
	public Show updateShow(@PathVariable Long id, @Valid @RequestBody Show show) {
		return showService.updateShow(id, show);
	}

	@PostMapping("/bookShowTicket")
	public BookingShowResponse bookShowTicket(@Valid @RequestBody BookingShowRequest bookingrequest) {
		Show show = showService.getShowById(bookingrequest.getShowId());
		return showService.bookShowTicket(show, bookingrequest.getSeatIds());

	}

	@DeleteMapping("/{id}")
	public void deleteShow(@PathVariable Long id) {
		showService.deleteShow(id);
	}
}
