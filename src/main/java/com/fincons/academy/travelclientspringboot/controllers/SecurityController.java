package com.fincons.academy.travelclientspringboot.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.academy.travelclientspringboot.entities.dto.LoginDto;
import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;
import com.fincons.academy.travelclientspringboot.services.SecurityService;

@RestController
@RequestMapping("/security")
public class SecurityController {

	private SecurityService securityService;
	
	public SecurityController(
			@Qualifier("securityServiceImpl") SecurityService securityService
			) {
		this.securityService = securityService;
	}
	
	@PostMapping
	public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto) {
		UserDto userDto = securityService.findUserByMailAndPassword(loginDto);
		if (userDto == null) return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	

}
