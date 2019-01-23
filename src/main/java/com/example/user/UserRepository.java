package com.example.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>  {

	public List<User> findAll();
	public User findUserByEmail(String email);
	public User save(User user);
	
}
