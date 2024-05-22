package com.sapient.bookshowsmgmt.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sapient.bookshowsmgmt.model.Screen;


public interface ScreenSearchRepository extends ElasticsearchRepository<Screen, Integer> {
        Iterable<Screen> findByScreenName(String screenName);
        Iterable<Screen> findByArea(String area);
        Iterable<Screen> findByCity(String city);
        Iterable<Screen> findByMovieName(String movieName);
        Iterable<Screen> findByMovieTime(String movieTime);
        Iterable<Screen> findByMovieNameAndMovieTime(String movieName, String movieTime);
        Iterable<Screen> findByCityAndMovieNameAndMovieTime(String city, String movieName, String movieTime);
        Iterable<Screen> findByAreaAndCityAndMovieNameAndMovieTime(String area, String city, String movieName, String movieTime);
        Iterable<Screen> findByScreenNameAndAreaAndCityAndMovieNameAndMovieTime(String screenName, String area, String city, String movieName, String movieTime);
}