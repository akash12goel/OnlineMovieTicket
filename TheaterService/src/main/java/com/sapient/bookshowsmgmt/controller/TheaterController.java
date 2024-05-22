package com.sapient.bookshowsmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bookshowsmgmt.model.Theater;
import com.sapient.bookshowsmgmt.service.TheaterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
	@Autowired
	private TheaterService theaterService;

	@GetMapping
	public List<Theater> getAllTheaters() {
		return theaterService.getAllTheaters();
	}

	@GetMapping("/{id}")
	public Theater getTheaterById(@PathVariable Long id) {
		return theaterService.getTheaterById(id);
	}

	@GetMapping("/name/{name}")
	public Theater getTheaterByName(@PathVariable String name) {
		return theaterService.getTheaterByName(name);
	}

	@PostMapping
	public Theater addTheater(@Valid @RequestBody Theater theater) {
		return theaterService.addTheater(theater);
	}

	@PutMapping("/{id}")
	public Theater updateTheater(@PathVariable Long id, @Valid @RequestBody Theater theater) {
		return theaterService.updateTheater(id, theater);
	}

	@DeleteMapping("/{id}")
	public void deleteTheater(@PathVariable Long id) {
		theaterService.deleteTheater(id);
	}

}
