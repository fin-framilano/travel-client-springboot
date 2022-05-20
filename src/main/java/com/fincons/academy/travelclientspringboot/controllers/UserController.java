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
import org.springframework.web.bind.annotation.RestController;

import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;
import com.fincons.academy.travelclientspringboot.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(
			
			@Qualifier("userServiceImpl") UserService userService
			) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> usersList = userService.findAll();
		if (usersList != null) {
			return new ResponseEntity<List<UserDto>>(usersList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
		}
	}


	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
		UserDto userDto = userService.findById(id);
		return userDto != null ? 
				new ResponseEntity<UserDto>(userDto, HttpStatus.OK) : new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/mail/{mail}")
	public ResponseEntity<UserDto> findByEmail(@PathVariable("mail") String mail) {
		UserDto userDto = userService.findByEmail(mail);
		return userDto != null ?
				new ResponseEntity<UserDto>(userDto, HttpStatus.OK) : new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	
	@PostMapping
	public Long create(@RequestBody UserDto user) {
		return userService.create(user);
	}
	

}
