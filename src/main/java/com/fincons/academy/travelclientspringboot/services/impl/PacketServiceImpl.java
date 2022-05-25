package com.fincons.academy.travelclientspringboot.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fincons.academy.travelclientspringboot.entities.Packet;
import com.fincons.academy.travelclientspringboot.entities.dto.PacketDto;
import com.fincons.academy.travelclientspringboot.repositories.PacketRepository;
import com.fincons.academy.travelclientspringboot.services.PacketService;
import com.fincons.academy.travelclientspringboot.utils.PacketUtils;

@Service
public class PacketServiceImpl implements PacketService {

	private PacketRepository packetRepository;
	
	public PacketServiceImpl(
			PacketRepository packetRepository
			) {
		this.packetRepository = packetRepository;
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<PacketDto> findAll() {
		List<Packet> packetsDvo = packetRepository.findAll();
		if (packetsDvo == null) return null;
		else {
			List<PacketDto> packetsDto = packetsDvo.stream().map(
					p -> PacketUtils.fromDVOtoDTO(p)
			).collect(Collectors.toList());
			return packetsDto;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(Long id) {
		Packet packet = packetRepository.findById(id).get();
		packetRepository.delete(packet);
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public PacketDto findById(Long id) {
		Packet packetDvo;
		try {
			packetDvo = packetRepository.findById(id).get();			
		} catch(NoSuchElementException e) {
			return null;
		} 
		return PacketUtils.fromDVOtoDTO(packetDvo);	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Long create(PacketDto packet) {
		Packet packetDvo = PacketUtils.fromDTOtoDVO(packet);
		packetDvo = packetRepository.save(packetDvo);
		return packetDvo.getId();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PacketDto update(Long id, PacketDto packet) {
		Packet packetDvo = PacketUtils.fromDTOtoDVO(packet);
		packetDvo = packetRepository.saveAndFlush(packetDvo);
		return PacketUtils.fromDVOtoDTO(packetDvo);
	}
}
