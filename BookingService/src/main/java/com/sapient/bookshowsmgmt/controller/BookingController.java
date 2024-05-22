package com.sapient.bookshowsmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bookshowsmgmt.model.Booking;
import com.sapient.bookshowsmgmt.response.BookingResponse;
import com.sapient.bookshowsmgmt.response.RestResponse;
import com.sapient.bookshowsmgmt.service.BookingService;
import com.sapient.bookshowsmgmt.util.ServiceUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@Operation(summary = "Get All the bookings")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the booking", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class)) }) })
	@GetMapping
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@Operation(summary = "Get a booking by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the booking", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Booking not found", content = @Content) })
	@GetMapping("/{id}")
	public Booking getBookingById(@PathVariable Long id) {
		return bookingService.getBookingById(id);
	}

	@Operation(summary = "Book Ticket for a movie show")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "ticket booked successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Booking.class)) }),
			@ApiResponse(responseCode = "500", description = "Any microservice call failed", content = @Content) })
	@PostMapping
	public ResponseEntity<RestResponse<BookingResponse>> addBooking(@Valid @RequestBody Booking booking) {
		return ServiceUtil.prepareSuccessResponse(bookingService.addBooking(booking));
		// return bookingService.addBooking(booking);
	}

	@PutMapping("/{id}")
	public Booking updateBooking(@PathVariable Long id, @Valid @RequestBody Booking booking) {
		return bookingService.updateBooking(id, booking);
	}

	@DeleteMapping("/{id}")
	public void deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
	}
}
