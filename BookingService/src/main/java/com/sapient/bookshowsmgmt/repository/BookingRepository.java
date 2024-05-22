package com.sapient.bookshowsmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.bookshowsmgmt.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
