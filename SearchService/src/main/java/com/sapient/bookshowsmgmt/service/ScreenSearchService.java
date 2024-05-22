package com.sapient.bookshowsmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.bookshowsmgmt.model.Screen;
import com.sapient.bookshowsmgmt.repository.ScreenSearchRepository;

@Service
public class ScreenSearchService {
	@Autowired
	private ScreenSearchRepository screenSearchRepository;

	public Iterable<Screen> getScreens() {
		return screenSearchRepository.findAll();
	}

	public Iterable<Screen> findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(String screenName, String area,
			String city, String movieName, String movieTime) {
		return screenSearchRepository.findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(screenName, area, city,
				movieName, movieTime);
	}

	public Iterable<Screen> findByAreaAndCityAndMovieNameAndMovieTime(String area, String city, String movieName,
			String movieTime) {
		return screenSearchRepository.findByAreaAndCityAndMovieNameAndMovieTime(area, city, movieName, movieTime);
	}

	public Iterable<Screen> findByCityAndMovieNameAndMovieTime(String city, String movieName, String movieTime) {
		return screenSearchRepository.findByCityAndMovieNameAndMovieTime(city, movieName, movieTime);
	}

	public Iterable<Screen> findByMovieNameAndMovieTime(String movieName, String movieTime) {
		return screenSearchRepository.findByMovieNameAndMovieTime(movieName, movieTime);
	}

	public Iterable<Screen> findByMovieTime(String movieTime) {
		return screenSearchRepository.findByMovieTime(movieTime);
	}

	public Iterable<Screen> findByMovieName(String movieName) {
		return screenSearchRepository.findByMovieName(movieName);
	}

	public Iterable<Screen> findByCity(String city) {
		return screenSearchRepository.findByCity(city);
	}

	public Iterable<Screen> findByArea(String area) {
		return screenSearchRepository.findByArea(area);
	}

	public Iterable<Screen> findByScreenName(String screenName) {
		return screenSearchRepository.findByScreenName(screenName);
	}

	public Iterable<Screen> saveAllScreens(Iterable<Screens> product) {
		return screenSearchRepository.saveAll(product);
	}
}