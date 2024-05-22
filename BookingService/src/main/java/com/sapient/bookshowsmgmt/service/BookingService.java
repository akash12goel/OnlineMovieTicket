package com.sapient.bookshowsmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.sapient.bookshowsmgmt.exception.BookingNotFoundException;
import com.sapient.bookshowsmgmt.model.Booking;
import com.sapient.bookshowsmgmt.repository.BookingRepository;
import com.sapient.bookshowsmgmt.request.BookingRequest;
import com.sapient.bookshowsmgmt.response.BookingResponse;

import jakarta.jms.Queue;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue bookingQueue;
	@Autowired
	private Queue notificationQueue;
	@Value("${show.service.host}")
	private String hostName;
	@Value("${show.service.port}")
	private String port;

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id)
				.orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
	}

	@Transactional
	public BookingResponse addBooking(Booking booking) {
		System.out.println(hostName);
		// Call other microservices and perform distributed transaction using Saga
		// pattern here
		// Call Payment service first
		BookingRequest bookingRequest = new BookingRequest();
		bookingRequest.setShowId(booking.getShowId());
		bookingRequest.setSeatIds(booking.getSeatIds());
		StringBuilder stringBuilder = new StringBuilder(100);
		String url = stringBuilder.append("http://").append(hostName).append(":").append(port)
				.append("/shows/bookShowTicket").toString();

		// String url = "http://" + hostName + ":" + port + "/shows/bookShowTicket";

		BookingResponse bookingResponse = restTemplate.postForObject(url, bookingRequest, BookingResponse.class);
		try {
			bookingRepository.save(booking);
		} catch (Exception e) {
			// push the message in the queue for retry
			// jmsTemplate.convertAndSend(bookingQueue, booking);
		}
		// push the message in notification queue
		// jmsTemplate.convertAndSend(notificationQueue, booking);
		return bookingResponse;

	}

	public Booking updateBooking(Long id, Booking booking) {
		Booking existingBooking = getBookingById(id);
		existingBooking.setUserId(booking.getUserId());
		existingBooking.setShowId(booking.getShowId());
		// existingBooking.setNumberOfSeats(booking.getNumberOfSeats());
		existingBooking.setBookingTime(booking.getBookingTime());
		return bookingRepository.save(existingBooking);
	}

	public void deleteBooking(Long id) {
		Booking booking = getBookingById(id);
		bookingRepository.delete(booking);
	}
}
