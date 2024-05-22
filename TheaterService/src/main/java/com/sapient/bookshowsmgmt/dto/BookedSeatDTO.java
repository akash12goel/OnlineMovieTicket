package com.sapient.bookshowsmgmt.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookedSeatDTO {

	private Long theaterId;
	
	private Map<Long, List<Long>> screen_SeatMap;

}
