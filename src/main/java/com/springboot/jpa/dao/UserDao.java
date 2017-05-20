package com.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.domain.User;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, String> {

	@Query("SELECT u from User u WHERE u.emailAddress = :emailAddress")
	User findByEmailAddress(@Param("emailAddress") String emailAddress);
	
	@Query("from User")
	List<User> findAll();
}
