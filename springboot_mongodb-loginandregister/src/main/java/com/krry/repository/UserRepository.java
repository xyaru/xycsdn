package com.krry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.krry.entity.User;


public interface UserRepository extends MongoRepository<User, String> {

	public User findByUsername(String username);
}
