package com.fincons.academy.travelclientspringboot.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fincons.academy.travelclientspringboot.entities.User;
import com.fincons.academy.travelclientspringboot.entities.dto.UserDto;
import com.fincons.academy.travelclientspringboot.repositories.UserRepository;
import com.fincons.academy.travelclientspringboot.services.UserService;
import com.fincons.academy.travelclientspringboot.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(
			UserRepository userRepository
			) {
		this.userRepository = userRepository;
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<UserDto> findAll() {
		List<User> usersDvo = userRepository.findAll();
		if (usersDvo == null || usersDvo.size() == 0) {
			return null;
		} else {
			List<UserDto> usersDto = usersDvo.stream().map(
					p -> UserUtils.fromDVOtoDTO(p)
			).collect(Collectors.toList());
			return usersDto;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public UserDto findById(Long id) {
		User userDvo;
		try {
			userDvo = userRepository.findById(id).get();			
		} catch(NoSuchElementException e) {
			return null;
		} 
		return UserUtils.fromDVOtoDTO(userDvo);	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Long create(UserDto user) {
		User userDvo = UserUtils.fromDTOtoDVO(user);
		userDvo = userRepository.save(userDvo);
		return userDvo.getId();
	}

	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public UserDto findByEmail(String mail) {
		User userDvo = userRepository.findByMail(mail);
		if (userDvo == null) return null;
		UserDto userDto = UserUtils.fromDVOtoDTO(userDvo);
		return userDto;
	}
}
