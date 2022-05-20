package com.fincons.academy.travelclientspringboot.services;

import java.util.List;

import com.fincons.academy.travelclientspringboot.entities.dto.ReservationDto;

public interface ReservationService {

	Long create(ReservationDto reservation);

	ReservationDto findById(Long id);

	void deleteById(Long id);

	List<ReservationDto> findAll();

	List<ReservationDto> findReservationsByUserId(Long id_user);

}
