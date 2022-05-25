package com.fincons.academy.travelclientspringboot.services;

import java.util.List;

import com.fincons.academy.travelclientspringboot.entities.dto.PacketDto;

public interface PacketService {

	List<PacketDto> findAll();

	PacketDto findById(Long id);

	Long create(PacketDto packet);

	void deleteById(Long id);

	PacketDto update(Long id, PacketDto packet);

}
