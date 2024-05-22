package com.sapient.bookshowsmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.bookshowsmgmt.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	Movie findByTitle(String title);
}