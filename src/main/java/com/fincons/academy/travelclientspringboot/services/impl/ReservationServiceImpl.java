package com.fincons.academy.travelclientspringboot.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fincons.academy.travelclientspringboot.entities.Packet;
import com.fincons.academy.travelclientspringboot.entities.Reservation;
import com.fincons.academy.travelclientspringboot.entities.User;
import com.fincons.academy.travelclientspringboot.entities.dto.ReservationDto;
import com.fincons.academy.travelclientspringboot.repositories.PacketRepository;
import com.fincons.academy.travelclientspringboot.repositories.ReservationRepository;
import com.fincons.academy.travelclientspringboot.repositories.UserRepository;
import com.fincons.academy.travelclientspringboot.services.ReservationService;
import com.fincons.academy.travelclientspringboot.utils.ReservationUtils;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationRepository reservationRepository;
	private UserRepository userRepository;
	private PacketRepository packetRepository;
	
	public ReservationServiceImpl(
			ReservationRepository reservationRepository,
			UserRepository userRepository,
			PacketRepository packetRepository
			) {
		this.reservationRepository = reservationRepository;
		this.userRepository = userRepository;
		this.packetRepository = packetRepository;
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<ReservationDto> findAll() {
		List<Reservation> reservationsDvo = reservationRepository.findAll();
		if (reservationsDvo == null || reservationsDvo.size() == 0) {
			return null;
		} else {
			List<ReservationDto> reservationsDto = reservationsDvo.stream().map(
					p -> ReservationUtils.fromDVOtoDTO(p)
			).collect(Collectors.toList());
			return reservationsDto;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(Long id) {
		Reservation reservation = reservationRepository.findById(id).get();
		reservationRepository.delete(reservation);
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public ReservationDto findById(Long id) {
		Reservation reservationDvo;
		try {
			reservationDvo = reservationRepository.findById(id).get();			
		} catch(NoSuchElementException e) {
			return null;
		} 
		return ReservationUtils.fromDVOtoDTO(reservationDvo);	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Long create(ReservationDto reservation) {
		//Recupero il DVO dal DTO
		Reservation reservationDvo = ReservationUtils.fromDTOtoDVO(reservation);
		
		//Recupero i due campi correlati nel DB tramite FK, inietto le loro repository per recuperarlo
		User reservationUser = userRepository.findById(reservation.getUserId()).get();
		Packet reservationPacket = packetRepository.findById(reservation.getPacketId()).get();
		reservationDvo.setPacket(reservationPacket);
		reservationDvo.setUser(reservationUser);
		
		//Creo/salvo il nuovo reservation
		reservationDvo = reservationRepository.save(reservationDvo);
		return reservationDvo.getId();
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<ReservationDto> findReservationsByUserId(Long id_user) {
		List<Reservation> reservationsDvoList = reservationRepository.getReservationsByUserId(id_user);
		if (reservationsDvoList == null) return null;
		List<ReservationDto> reservationsDtoList = reservationsDvoList.stream().map(
				r -> ReservationUtils.fromDVOtoDTO(r)
				).collect(Collectors.toList());
		return reservationsDtoList;
	}
}
