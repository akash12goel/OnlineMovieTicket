package com.sapient.bookshowsmgmt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.bookshowsmgmt.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId);
    List<Show> findByTheaterId(Long theaterId);
    List<Show> findByShowTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
