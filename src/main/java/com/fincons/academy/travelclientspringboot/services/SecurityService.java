package com.fincons.academy.travelclientspringboot.services;

import com.fincons.academy.travelclientspringboot.entities.dto.LoginDto;
import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;

public interface SecurityService {

	UserDto findUserByMailAndPassword(LoginDto loginDto);

}
