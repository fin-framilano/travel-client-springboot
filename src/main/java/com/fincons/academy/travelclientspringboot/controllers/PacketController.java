package com.fincons.academy.travelclientspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.academy.travelclientspringboot.entities.dto.PacketDto;
import com.fincons.academy.travelclientspringboot.services.PacketService;

@RestController
@RequestMapping("/packets")
public class PacketController {

	private PacketService packetService;
	
	public PacketController(
			
			@Qualifier("packetServiceImpl") PacketService packetService
			) {
		this.packetService = packetService;
	}
	
	@GetMapping
	public ResponseEntity<List<PacketDto>> findAll() {
		List<PacketDto> packetsList = packetService.findAll();
		if (packetsList != null) {
			return new ResponseEntity<List<PacketDto>>(packetsList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PacketDto>>(HttpStatus.NO_CONTENT);
		}
	}


	@GetMapping("/{id}")
	public ResponseEntity<PacketDto> findById(@PathVariable("id") Long id) {
		PacketDto packetDto = packetService.findById(id);
		return packetDto != null ? 
				new ResponseEntity<PacketDto>(packetDto, HttpStatus.OK) : new ResponseEntity<PacketDto>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		System.out.println("Eliminazione di " + id);
		packetService.deleteById(id);
	}
	
	@PostMapping
	public Long create(@RequestBody PacketDto packet) {
		return packetService.create(packet);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PacketDto> update(@PathVariable("id")Long id, @RequestBody PacketDto packet) {
		return new ResponseEntity<PacketDto>(packetService.update(id, packet), HttpStatus.OK);
	}
	

}
