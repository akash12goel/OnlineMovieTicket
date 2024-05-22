package com.sapient.bookshowsmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.bookshowsmgmt.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
   
    
}
