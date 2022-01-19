package com.lavanya.gudimella.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormValidation {
	/**
	 * This method is used to validate the personal information form
	 * 
	 * @param first_name
	 * @param middle_name
	 * @param last_name
	 * @param email_address
	 * @return result
	 */
	public String validatePersonalInfoForm(String first_name, String middle_name, String last_name,
			String email_address) {
		String result = null;

		if (validateUserName(first_name, "First name") != null) {
			result = validateUserName(first_name, "First name");
		} else if (validateUserName(middle_name, "Middle name") != null) {
			result = validateUserName(middle_name, "Middle name");
		} else if (validateUserName(last_name, "Last name") != null) {
			result = validateUserName(last_name, "Last name");
		} else if (validateEmailAddress(email_address) != null) {
			result = validateEmailAddress(email_address);
		}

		return result;
	}

	/**
	 * This method is used to validate the contact information form
	 * 
	 * @param address
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 * @param phone_number
	 * @return result
	 */
	public String validateContactInfoForm(String address, String city, String state, String country, String zipcode, String phone_number) {
		String result = null;

		if (containsNumbers(city) || containsSpecialCharacters(city)) {
			result = "City name should contain only alphabets";
		} else if (containsNumbers(state) || containsSpecialCharacters(state)) {
			result = "State name should contain only alphabets";
		} else if (containsNumbers(country) || containsSpecialCharacters(country)) {
			result = "Country name should contain only alphabets";
		} else if (containsAlphabets(zipcode) || containsSpecialCharacters(zipcode)) {
			result = "ZIPCODE should contain only numbers";
		} else if (validateContactNumber(phone_number) != null) {
			result = validateContactNumber(phone_number);
		}
		return result;
	}

	/**
	 * This method is used to validate Bank information form
	 * 
	 * @param bank_name
	 * @param account_details
	 * @param ssn_number
	 * @return result
	 */
	public String validateBankInfoForm(String bank_name, String account_details, String ssn_number) {
		String result = null;
		if (containsNumbers(bank_name) || containsSpecialCharacters(bank_name)) {
			result = "Bank name can contain only Alphabets";
		} else if (containsAlphabets(account_details) || containsSpecialCharacters(account_details)) {
			result = "Account number should contain only Numbers";
		} else if (validateSSN(ssn_number) != null) {
			result = validateSSN(ssn_number);
		}
		return result;
	}
	
	/**
	 * This method is used to validate the update user form
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 * @param phone_number
	 * @param bank_name
	 * @param account_details
	 * @return result
	 */
	public String updateUserFormvalidation(String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details) {
		String result = null;
		
		if (containsNumbers(city) || containsSpecialCharacters(city)) {
			result = "City name should contain only alphabets";
		} else if (containsNumbers(state) || containsSpecialCharacters(state)) {
			result = "State name should contain only alphabets";
		} else if (containsNumbers(country) || containsSpecialCharacters(country)) {
			result = "Country name should contain only alphabets";
		} else if (containsAlphabets(zipcode) || containsSpecialCharacters(zipcode)) {
			result = "ZIPCODE should contain only numbers";
		} else if (validateContactNumber(phone_number) != null) {
			result = validateContactNumber(phone_number);
		} if (containsNumbers(bank_name) || containsSpecialCharacters(bank_name)) {
			result = "Bank name can contain only Alphabets";
		} else if (containsAlphabets(account_details) || containsSpecialCharacters(account_details)) {
			result = "Account number should contain only Numbers";
		}
		
		return result;
	}

	// person name validation
	public String validateUserName(String user_name, String input_name) {
		String result = null;
		user_name = user_name.trim();

		// first name validation
		if (user_name.equals("null")) {
			result = input_name + " cannot be null";
		} else if (user_name.isEmpty()) {
			result = input_name + " name cannot be empty";
		} else if (user_name.length() < 2) {
			result = input_name + " name should not be less than 2 characters";
		} else if (containsSpecialCharacters(user_name)) {
			result = input_name + " name should not contain any special characters";
		} else if (containsNumbers(user_name)) {
			result = input_name + " name should not contain numbers";
		}

		return result;
	}

	// person email address validation
	public String validateEmailAddress(String email_address) {
		String result = null;
		String email_regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(email_regex);
		Matcher matcher = pattern.matcher(email_address);

		if (email_address.equals("null")) {
			result = "Email address cannot be null";
		} else if (email_address.isEmpty()) {
			result = "Email address cannot be empty";
		} else if (!matcher.matches()) {
			result = "Please enter a valid email address";
		}
		return result;
	}

	// person contact number validation
	public String validateContactNumber(String contact_number) {
		String result = null;

		if (contact_number.equals("null")) {
			result = "Contact number cannot be null";
		} else if (contact_number.isEmpty()) {
			result = "Contact number cannot be empty";
		} else if (containsAlphabets(contact_number)) {
			result = "Contact number cannot contain Alphabets";
		} else if (containsSpecialCharacters(contact_number)) {
			result = "Contact number cannot contain special characters";
		} else if (contact_number.length() != 10) {
			result = "Contact number should exactly contain 10 digits";
		}

		return result;
	}

	// person SSN number validation
	public String validateSSN(String ssn_number) {
		String result = null;
		String regex = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ssn_number);

		if (ssn_number.equals("null")) {
			result = "SSN cannot be null";
		} else if (ssn_number.isEmpty()) {
			result = "SSN cannot be empty";
		} else if (!matcher.matches()) {
			result = "Please enter a valid SSN number";
		}

		return result;
	}

	// input field contains alphabets or not
	public boolean containsAlphabets(String input_field) {
		boolean containsAlphabets = false;
		;
		for (int i = 0; i < input_field.length(); i++) {
			char ch = input_field.charAt(i);
			if (Character.isLetter(ch)) {
				containsAlphabets = true;
			}
		}
		return containsAlphabets;
	}

	// input field contain numbers or not
	public boolean containsNumbers(String input_field) {
		boolean containsNumbers = false;
		;
		for (int i = 0; i < input_field.length(); i++) {
			char ch = input_field.charAt(i);
			if (Character.isDigit(ch)) {
				containsNumbers = true;
			}
		}
		return containsNumbers;
	}

	// input field contain special characters or not
	public boolean containsSpecialCharacters(String input_field) {
		boolean containsSpecialCharacters = false;
		;
		for (int i = 0; i < input_field.length(); i++) {
			char ch = input_field.charAt(i);
			if (!Character.isLetterOrDigit(ch)) {
				containsSpecialCharacters = true;
			}
		}
		return containsSpecialCharacters;
	}
}
