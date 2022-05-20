package com.fincons.academy.travelclientspringboot.utils;

import com.fincons.academy.travelclientspringboot.entities.User;
import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;

public class UserUtils {

	public static UserDto fromDVOtoDTO(User u) {
		UserDto userDto = new UserDto();
		userDto.setId(u.getId());
		userDto.setMail(u.getMail());
		userDto.setPassword(u.getPassword());
		userDto.setRole(u.getRole());
		return userDto;
	}
	
	public static User fromDTOtoDVO(UserDto u) {
		User user = new User();
		user.setId(u.getId());
		user.setMail(u.getMail());
		user.setPassword(u.getPassword());
		user.setRole(u.getRole());
		return user;
	}

}
