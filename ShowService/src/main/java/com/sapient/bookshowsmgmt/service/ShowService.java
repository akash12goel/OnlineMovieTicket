package com.sapient.bookshowsmgmt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.bookshowsmgmt.exception.ShowNotFoundException;
import com.sapient.bookshowsmgmt.model.Show;
import com.sapient.bookshowsmgmt.repository.ShowRepository;
import com.sapient.bookshowsmgmt.request.BookingSeatRequest;
import com.sapient.bookshowsmgmt.response.BookingShowResponse;

@Service
public class ShowService {
	@Autowired
	private ShowRepository showRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${theater.service.host}")
	private String hostName;
	@Value("${theater.service.port}")
	private String port;

	public List<Show> getAllShows() {
		List<Show> showList = showRepository.findAll();

		return showList;
	}

	public Show getShowById(Long id) {
		return showRepository.findById(id)
				.orElseThrow(() -> new ShowNotFoundException("Show not found with id: " + id));
	}

	public List<Show> getShowsByMovieId(Long movieId) {
		return showRepository.findByMovieId(movieId);
	}

	public List<Show> getShowsByTheaterId(Long theaterId) {
		return showRepository.findByTheaterId(theaterId);
	}

	public List<Show> getShowsByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
		return showRepository.findByShowTimeBetween(startTime, endTime);
	}

	public Show updateShow(Long id, Show show) {
		Show existingShow = getShowById(id);
		existingShow.setMovieId(show.getMovieId());
		existingShow.setTheaterId(show.getTheaterId());
		existingShow.setShowTime(show.getShowTime());
		existingShow.setAvailableSeats(show.getAvailableSeats());
		return showRepository.save(existingShow);
	}

	public Show addShow(Show show) {
		return showRepository.save(show);
	}

	public BookingShowResponse bookShowTicket(Show show, List<Long> seatIds) {

		BookingSeatRequest bookingSeatRequest = new BookingSeatRequest();
		bookingSeatRequest.setScreenId(show.getScreenId());
		bookingSeatRequest.setSeatIds(seatIds);
		StringBuilder stringBuilder = new StringBuilder(100);
		String url = stringBuilder.append("http://").append(hostName).append(":").append(port)
				.append("screen/reserveFinalSeats").toString();
		// String url = "http://localhost:8082/screen/reserveFinalSeats";
		BookingShowResponse response = restTemplate.patchForObject(url, bookingSeatRequest, BookingShowResponse.class);
		response.setShowTime(show.getShowTime());

		// return bookingRepository.save(booking);

		return response;
	}

	public void deleteShow(Long id) {
		Show show = getShowById(id);
		showRepository.delete(show);
	}
}
