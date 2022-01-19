package com.lavanya.gudimella.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lavanya.gudimella.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * This method is used to add the user into the database
	 * @param user
	 */
	@Override
	public int addUser(User user) {
		int result = 0;
		String query = "insert into Person(first_name, middle_name, last_name, email_address, gender, address, city, state, country, zipcode, phone_number, bank_name, account_details, ssn_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		result = jdbcTemplate.update(query, user.getFirst_name(), user.getMiddle_name(), user.getLast_name(), user.getEmail_address(), user.getGender(), user.getAddress(), user.getCity(), user.getState(), user.getCountry(), user.getZipcode(), user.getPhone_number(), user.getBank_name(), user.getAccount_details(), user.getSsn_number());
		if(result>0) {
			System.out.println("User has been added successfully");
		}
		return result;
	}

	/**
	 * This method is used to get the users list from the database
	 * @return userList
	 */
	@Override
	public List<User> getUsersList() {
		List<User> usersList = new ArrayList<User>();
		String query = "select * from Person";
		usersList = jdbcTemplate.query(query, new UserRowMapper());	
		return usersList;
	}

	/**
	 * This method is used to update the user from the database
	 * @param address
	 * @param city
	 * @param state
	 * @param country
	 * @param zipcode
	 * @param phone-number
	 * @param bank_name
	 * @param account_details
	 * @param email_address
	 */
	@Override
	public int updateUser(String address, String city, String state, String country, String zipcode, String phone_number, String bank_name, String account_details, String email_address) {
		String query = "update Person set address=?, city=?, state=?, country=?, zipcode=?, phone_number=?, bank_name=?, account_details=? where email_address=?";
		int result = jdbcTemplate.update(query, address, city, state, country, zipcode, phone_number, bank_name, account_details, email_address);
		if(result>0) {
			System.out.println("User has been updated successfully");
		}
 		return result;
	}

	/**
	 * This method is used to delete the user necessary fields 
	 * using user data access object interface
	 * @param email_address
	 */
	@Override
	public int deleteUser(String email_address) {
		String query = "delete from Person where email_address=?";
		int result = jdbcTemplate.update(query, email_address);
		if(result>0) {
			System.out.println("User has been deleted successfully");
		}
		return result;
	}
	
	/**
	 * This method is used to find user
	 * using user data access object interface
	 * @param email_address
	 */
	@Override
	public boolean findUser(String email_address) {
		boolean userFound = false;
		List<User> usersList = new ArrayList<User>();
		String query = "select * from Person where email_address=?";
		usersList = jdbcTemplate.query(query, new UserRowMapper(), email_address);
		for(User user : usersList) {
			String email = user.getEmail_address();
			if(email.trim().equals(email_address.trim())) {
				userFound = true;
			}
		}
		return userFound;
	}
	
	/**
	 * This is the class row-mapper used to iterate through the rows inside the
	 * SQL database and returns a user object
	 * @return user
	 */
	private static final class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User user = new User();
			String first_name = resultSet.getString(2);
			String middle_name = resultSet.getString(3);
			String last_name = resultSet.getString(4);
			String email_address = resultSet.getString(5);
			String gender = resultSet.getString(6);
			String address = resultSet.getString(7);
			String city = resultSet.getString(8);
			String state = resultSet.getString(9);
			String country = resultSet.getString(10);
			String zipcode = resultSet.getString(11);
			String phone_number = resultSet.getString(12);
			String bank_name = resultSet.getString(13);
			String account_details = resultSet.getString(14);
			String ssn_number = resultSet.getString(15);
			
			user.setFirst_name(first_name);
			user.setMiddle_name(middle_name);
			user.setLast_name(last_name);
			user.setEmail_address(email_address);
			user.setGender(gender);
			user.setAddress(address);
			user.setCity(city);
			user.setState(state);
			user.setCountry(country);
			user.setZipcode(zipcode);
			user.setPhone_number(phone_number);
			user.setBank_name(bank_name);
			user.setAccount_details(account_details);
			user.setSsn_number(ssn_number);
		
			return user;
		}
	}
}
