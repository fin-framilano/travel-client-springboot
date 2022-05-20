package com.fincons.academy.travelclientspringboot.utils;

import com.fincons.academy.travelclientspringboot.entities.Reservation;
import com.fincons.academy.travelclientspringboot.entities.dto.ReservationDto;

public class ReservationUtils {

	public static ReservationDto fromDVOtoDTO(Reservation r) {
		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setEndDate(r.getEndDate());
		reservationDto.setId(r.getId());
		reservationDto.setNrPeople(r.getNrPeople());
		reservationDto.setPacketId(r.getPacket().getId());
		reservationDto.setStartDate(r.getStartDate());
		reservationDto.setUserId(r.getUser().getId());
		return reservationDto;
	}
	
	public static Reservation fromDTOtoDVO(ReservationDto r) {
		Reservation reservation = new Reservation();
		reservation.setEndDate(r.getEndDate());
		reservation.setId(r.getId());
		reservation.setNrPeople(r.getNrPeople());
		reservation.setStartDate(r.getStartDate());
		return reservation;
	}

}
