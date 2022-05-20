package com.fincons.academy.travelclientspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fincons.academy.travelclientspringboot.entities.Packet;

@Repository
public interface PacketRepository extends JpaRepository<Packet, Long>{

}
