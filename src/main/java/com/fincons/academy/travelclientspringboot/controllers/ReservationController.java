package com.fincons.academy.travelclientspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.academy.travelclientspringboot.entities.dto.ReservationDto;
import com.fincons.academy.travelclientspringboot.services.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(

			@Qualifier("reservationServiceImpl") ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping("/")
	public ResponseEntity<List<ReservationDto>> findAll() {
		List<ReservationDto> reservationsList = reservationService.findAll();
		if (reservationsList != null) {
			return new ResponseEntity<List<ReservationDto>>(reservationsList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ReservationDto>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReservationDto> findById(@PathVariable("id") Long id) {
		ReservationDto reservationDto = reservationService.findById(id);
		return reservationDto != null ? new ResponseEntity<ReservationDto>(reservationDto, HttpStatus.OK)
				: new ResponseEntity<ReservationDto>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		reservationService.deleteById(id);
	}

	@PostMapping
	public Long create(@RequestBody ReservationDto reservation) {
		return reservationService.create(reservation);
	}

	@GetMapping
	public ResponseEntity<List<ReservationDto>> findReservationsByUserId(@RequestParam("id_user") Long id_user) {
		List<ReservationDto> reservationsList = reservationService.findReservationsByUserId(id_user);
		if (reservationsList == null)
			return new ResponseEntity<List<ReservationDto>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<ReservationDto>>(reservationsList, HttpStatus.ACCEPTED);
	}

}
