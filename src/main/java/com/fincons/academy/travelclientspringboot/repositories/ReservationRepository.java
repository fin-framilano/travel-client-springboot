package com.fincons.academy.travelclientspringboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fincons.academy.travelclientspringboot.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	@Query(name="select r from Reservation r where r.id_user = :id_user", nativeQuery=true)
	List<Reservation> getReservationsByUserId(@Param(value = "id_user") Long id_user);
}
