package com.fincons.academy.travelclientspringboot.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fincons.academy.travelclientspringboot.entities.User;
import com.fincons.academy.travelclientspringboot.entities.dto.LoginDto;
import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;
import com.fincons.academy.travelclientspringboot.repositories.UserRepository;
import com.fincons.academy.travelclientspringboot.services.SecurityService;
import com.fincons.academy.travelclientspringboot.utils.UserUtils;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	private UserRepository userRepository;
	
	public SecurityServiceImpl(
			@Qualifier("userRepository") UserRepository userRepository
			) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto findUserByMailAndPassword(LoginDto loginDto) {
		User userDvo = userRepository.findUserByMailAndPassword(loginDto.getMail(), loginDto.getPassword());
		if (userDvo == null) return null;
		UserDto userDto = UserUtils.fromDVOtoDTO(userDvo);
		return userDto;
	}

}
