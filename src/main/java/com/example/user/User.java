package com.example.user;

import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String email;
	private List<String> favorites;
	
	public User() {

	}
	
	public User(String email, List<String> favorites) {
		super();
		this.email = email;
		this.favorites = favorites;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}

}
