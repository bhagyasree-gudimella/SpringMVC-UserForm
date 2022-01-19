package com.lavanya.gudimella.dao;

import java.util.List;

import com.lavanya.gudimella.dto.User;

public interface UserDao {
	public int addUser(User user); 
	
	public List<User> getUsersList(); 
	
	public int updateUser(String address, String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details, String email_address);
	
	public int deleteUser(String email_address);
	
	public boolean findUser(String email_address);
}
