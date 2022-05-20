package com.fincons.academy.travelclientspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fincons.academy.travelclientspringboot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(name="select u from User u where u.mail = :mail", nativeQuery=true)
	User findByMail(String mail);

	@Query(name="select u from User u where u.mail = :mail and u.password = :password", nativeQuery=true)
	User findUserByMailAndPassword(String mail, String password);
}
