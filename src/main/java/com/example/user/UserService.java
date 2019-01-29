package com.example.user;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//private List<User> users = new ArrayList<User>();
	
	public List<User> getAllUsers(){
		//return users;
		return userRepository.findAll();
	}
	
	public User getUserByEmail(String email) {
		/*
		User userByEmail = null;
		for (User user: users) {
			if (user.getEmail().equals(email)) {
				userByEmail=user;
				break;
			}
		}
		return userByEmail;
		*/
		return userRepository.findUserByEmail(email);
	}
	
	public void saveUser(User user) {
		//users.add(user);
		userRepository.save(user);
	}
}
