package com.sapient.bookshowsmgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.bookshowsmgmt.exception.TheaterNotFoundException;
import com.sapient.bookshowsmgmt.model.Theater;
import com.sapient.bookshowsmgmt.repository.TheaterRepository;

@Service
public class TheaterService {
	Logger logger = LoggerFactory.getLogger(TheaterService.class);
	@Autowired
	private TheaterRepository theaterRepository;

	public List<Theater> getAllTheaters() {
		return theaterRepository.findAll();
	}

	public Theater getTheaterById(Long id) {
		return theaterRepository.findById(id)
				.orElseThrow(() -> new TheaterNotFoundException("Theater not found with id: " + id));
	}

	public Theater getTheaterByName(String name) {
		return theaterRepository.findByTheaterName(name);
	}

	public Theater addTheater(Theater theater) {
		logger.trace("Theater added started");
		theater = theaterRepository.save(theater);
		// logger.trace("Theater added with id {0}", theater.getId());
		return theater;
	}

	public Theater updateTheater(Long id, Theater theater) {
		Theater existingTheater = getTheaterById(id);
		existingTheater.setTheaterName(theater.getTheaterName());
		existingTheater.setAddress(theater.getAddress());
		return theaterRepository.save(existingTheater);
	}

	public void deleteTheater(Long id) {
		Theater theater = getTheaterById(id);
		theaterRepository.delete(theater);
	}
}
