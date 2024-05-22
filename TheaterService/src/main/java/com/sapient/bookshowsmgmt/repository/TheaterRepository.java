package com.sapient.bookshowsmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.bookshowsmgmt.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    Theater findByTheaterName(String name);
    
}
