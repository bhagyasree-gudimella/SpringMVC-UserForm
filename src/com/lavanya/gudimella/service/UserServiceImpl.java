package com.lavanya.gudimella.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanya.gudimella.dao.UserDao;
import com.lavanya.gudimella.dto.User;
import com.lavanya.gudimella.exceptions.UserFormValidationException;
import com.lavanya.gudimella.validations.UserFormValidation;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * This method is used to add user into the database using user
	 * data access object interface
	 * @param user
	 * @return int
	 */
	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	/**
	 * This method is used to get the users list from database
	 * using user data access object interface
	 * @return usersList
	 */
	@Override
	public List<User> getUsersList() {
		return userDao.getUsersList();
	}

	/**
	 * This method is used to update the user necessary fields 
	 * using user data access object interface
	 * @param address
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 * @param phone-number
	 * @param bank_name
	 * @param account_details
	 * @param email_address
	 * @return int
	 */
	@Override
	public int updateUser(String address, String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details, String email_address) {
		return userDao.updateUser(address, city, state, country, zipcode, phone_number, bank_name, account_details, email_address);
	}

	/**
	 * This method is used to delete the user necessary fields 
	 * using user data access object interface
	 * @param email_address
	 * @return int
	 */
	@Override
	public int deleteUser(String email_address) {
		return userDao.deleteUser(email_address);
	}
	
	/**
	 * This method is used to find user
	 * using user data access object interface
	 * @param email_address
	 * @return boolean
	 */
	@Override
	public boolean findUser(String email_address) {
		return userDao.findUser(email_address);
	}

	/**
	 * This method is used to validate details entered by user in the personal info form 
	 * @param first_name
	 * @param middle_name
	 * @param last_name
	 * @param email_address
	 * @return result
	 * @throws UserFormValidationException 
	 */
	@Override
	public void personalInfoFormValidation(String first_name, String middle_name, String last_name, String email_address) throws UserFormValidationException {
		String result = null;
		UserFormValidation userFormValidation =  new UserFormValidation();
		result = userFormValidation.validatePersonalInfoForm(first_name, middle_name, last_name, email_address);
		if(result!=null) {
			UserFormValidationException userFormValidationException = new UserFormValidationException();
			userFormValidationException.setErrorMessage(result);
			throw userFormValidationException;
		}
	}

	/**
	 * This method is used to validate details entered by user in the contact info form 
	 * @param address
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 * @param phone-number
	 * @return result
	 * @throws UserFormValidationException 
	 */
	@Override
	public void contactInfoFormValidation(String address, String city, String state, String country, String zipcode,
			String phone_number) throws UserFormValidationException {
		String result = null;
		UserFormValidation userFormValidation =  new UserFormValidation();
		result = userFormValidation.validateContactInfoForm(address, city, state, country, zipcode, phone_number);
		if(result!=null) {
			UserFormValidationException userFormValidationException = new UserFormValidationException();
			userFormValidationException.setErrorMessage(result);
			throw userFormValidationException;
		}
	}

	/**
	 * This method is used to validate details entered by user in the bank info form 
	 * @param bank_name
	 * @param account_details
	 * @param email_address
	 * @return result
	 * @throws UserFormValidationException 
	 */
	@Override
	public void bankInfoFormValidation(String bank_name, String account_details, String ssn_number) throws UserFormValidationException {
		String result = null;
		UserFormValidation userFormValidation =  new UserFormValidation();
		result = userFormValidation.validateBankInfoForm(bank_name, account_details, ssn_number);
		if(result!=null) {
			UserFormValidationException userFormValidationException = new UserFormValidationException();
			userFormValidationException.setErrorMessage(result);
			throw userFormValidationException;
		}
	}

	/**
	 * This method is used to validate email address entered by the user
	 * @param email_address
	 * @return result
	 * @throws UserFormValidationException 
	 */
	@Override
	public void validateEmail(String email_address) throws UserFormValidationException {
		String result = null;
		UserFormValidation userFormValidation =  new UserFormValidation();
		result = userFormValidation.validateEmailAddress(email_address);
		if(result!=null) {
			UserFormValidationException userFormValidationException = new UserFormValidationException();
			userFormValidationException.setErrorMessage(result);
			throw userFormValidationException;
		}
	}

	/**
	 * This method is used to validate the user details entered in the update form 
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 * @param phone-number
	 * @param bank_name
	 * @param account_details
	 * @return result
	 * @throws UserFormValidationException 
	 */
	@Override
	public void updateUserFormValidation(String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details) throws UserFormValidationException {
		String result = null;
		UserFormValidation userFormValidation =  new UserFormValidation();
		result = userFormValidation.updateUserFormvalidation(city, state, country, zipcode, phone_number, bank_name, account_details);
		if(result!=null) {
			UserFormValidationException userFormValidationException = new UserFormValidationException();
			userFormValidationException.setErrorMessage(result);
			throw userFormValidationException;
		}
	}
}
