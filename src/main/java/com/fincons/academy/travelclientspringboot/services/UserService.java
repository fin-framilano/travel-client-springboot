package com.fincons.academy.travelclientspringboot.services;

import java.util.List;

import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;

public interface UserService {

	Long create(UserDto user);

	UserDto findById(Long id);

	void deleteById(Long id);

	List<UserDto> findAll();

	UserDto findByEmail(String mail);

}
