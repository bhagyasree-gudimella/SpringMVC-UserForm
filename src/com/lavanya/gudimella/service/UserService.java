package com.lavanya.gudimella.service;

import java.util.List;

import com.lavanya.gudimella.dto.User;
import com.lavanya.gudimella.exceptions.UserFormValidationException;

public interface UserService {
	
	public int addUser(User user);
	
	public List<User> getUsersList();
	
	public int updateUser(String address, String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details, String email_address);
	
	public int deleteUser(String email_address);
	
	public boolean findUser(String email_address);
	
	public void personalInfoFormValidation(String first_name, String mmiddle_name, String last_name, String email_address) throws UserFormValidationException;
	
	public void contactInfoFormValidation(String address, String city, String state, String country, String zipcode, String phone_number)  throws UserFormValidationException;
	
	public void bankInfoFormValidation(String bank_name, String account_details, String ssn_number) throws UserFormValidationException;
	
	public void validateEmail(String email_address) throws UserFormValidationException;
	
	public void updateUserFormValidation(String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details) throws UserFormValidationException;
}
