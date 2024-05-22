package com.sapient.bookshowsmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.bookshowsmgmt.constants.SeatStatus;
import com.sapient.bookshowsmgmt.model.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
	List<Screen> findByTheaterId(Long theaterId);

	// @Query("SELECT sc.theaterId,sc.id, FROM Screen sc join seat se on sc.id
	// =se.screen_id WHERE se.status ='SEAT_BOOKED'")
	Screen findByIdAndSeats_SeatStatus(Long screenId, SeatStatus status);

	List<Screen> findByTheaterId_AndSeats_SeatStatus(long theaterId, SeatStatus status);

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query("update Seat se set se.seatStatus = :seatSatusValue where se.id IN (:ids)")
	int updateSeatsStaus(@Param("seatSatusValue") SeatStatus seatSatus, @Param("ids") List<Long> seatIdList);

}