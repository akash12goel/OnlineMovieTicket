package com.sapient.bookshowsmgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.bookshowsmgmt.constants.SeatStatus;
import com.sapient.bookshowsmgmt.exception.SeatBookedException;
import com.sapient.bookshowsmgmt.exception.TheaterNotFoundException;
import com.sapient.bookshowsmgmt.model.Screen;
import com.sapient.bookshowsmgmt.repository.ScreenRepository;
import com.sapient.bookshowsmgmt.repository.SeatRepository;

@Service
public class ScreenService {
	@Autowired
	private ScreenRepository screenRepository;

	public Screen getScreenById(Long id) {
		return screenRepository.findById(id)
				.orElseThrow(() -> new TheaterNotFoundException("Screen not found with id: " + id));
	}

	public List<Screen> getScreenByTheaterId(Long theaterId) {
		return screenRepository.findByTheaterId(theaterId);
	}

	public Screen addScreen(Screen screen) {
		return screenRepository.save(screen);
	}

	public Screen updateScreen(Long id, Screen screen) {
		Screen existingScreen = getScreenById(id);
		existingScreen.setScreenName(screen.getScreenName());
		existingScreen.setDescription(screen.getDescription());
		existingScreen.setSeats(screen.getSeats());
		return screenRepository.save(existingScreen);
	}

	public Integer bookedSeats(Long screenId, List<Long> seatIds) {
		// List<Long> seatIdList = screen.getSeats().stream().map(e ->
		// e.getId()).collect(Collectors.toList());
		int updatesRecords = screenRepository.updateSeatsStaus(SeatStatus.SEAT_BOOKED, seatIds);
		System.out.println("Number of records updated " + updatesRecords);
		if (updatesRecords < 1) {
			throw new SeatBookedException("Issue while booking seat please retry");
		}
		return updatesRecords;
	
	}

	public Optional<Screen> bookedTentativeSeats(Long screenId, List<Long> seatIds) {

		int updatesRecords = screenRepository.updateSeatsStaus(SeatStatus.SEAT_RESERVED, seatIds);
		System.out.println("Number of records updated " + updatesRecords);
		if (updatesRecords < 1) {
			throw new SeatBookedException("Issue while booking seat please retry");
		}
		Optional<Screen> screenUpdate = screenRepository.findById(screenId);

		return screenUpdate;
	}

	public Screen findAvailableSeatsInScreen(long screenId) {
		return screenRepository.findByIdAndSeats_SeatStatus(screenId, SeatStatus.SEAT_NOT_BOOKED);
	}

	public List<Screen> findAvailableSeatsInTheater(long theaterId) {
		return screenRepository.findByTheaterId_AndSeats_SeatStatus(theaterId, SeatStatus.SEAT_NOT_BOOKED);
	}
}
