package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Users;

@Repository
public class UserDao implements Dao<Users>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Users get(int id) {
		String sql = "select * from Users where UserID = ?";
		try {
			return (Users) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Users.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	public Users get(String email) {
		String sql = "select * from Users where EmailAddress = ?";
		try {
			return (Users) jdbcTemplate.queryForObject(sql,
					new Object[] {email},
                    new BeanPropertyRowMapper<>(Users.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public List<Users> getAll() {
		String sql = "select * from Users";
		try {
			List<Users> users = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Users.class));
			return users; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Users user) {
		if(get(user.getEmailAddress()) == null) {
			user.setAuthority("ROLE_" + user.getAuthority());
			String sql = "insert into Users (Name, EmailAddress, Password, PhoneNumber, Enabled, Authority, DOB, HouseNo, Street, Locality, Gender, CreatedDate)" + 
			"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			return jdbcTemplate.update(sql,
					user.getName(),
					user.getEmailAddress(),
					user.getPassword(),
					user.getPhoneNumber(),
					user.getEnabled(),
					user.getAuthority(),
					user.getDOB(),
					user.getHouseNo(),
					user.getStreet(),
					user.getLocality(),
					user.getGender(),
					user.getCreatedDate());
		}
		return 0;
	}

	@Override
	public void update(Users user) {
		if(get(user.getEmailAddress()) != null) {
			String sql = "update Users SET Name = ?, EmailAddress = ?, Password = ?, PhoneNumber = ?, Enabled = ?, Authority = ?, DOB = ?, HouseNo = ?, Street = ?, Locality = ?, Gender = ?, CreatedDate = ? " + 
			"where UserID = ?";
			jdbcTemplate.update(sql,
					user.getName(),
					user.getEmailAddress(),
					user.getPassword(),
					user.getPhoneNumber(),
					user.getEnabled(),
					user.getAuthority(),
					user.getDOB(),
					user.getHouseNo(),
					user.getStreet(),
					user.getLocality(),
					user.getGender(),
					user.getCreatedDate(),
					user.getUserID());
		}
	}

	public void updateUser(Users user) {
		if(get(user.getEmailAddress()) != null) {
			System.out.println(user);
			String sql = "update Users SET Name = ?, EmailAddress = ?, PhoneNumber = ?, DOB = ?, HouseNo = ?, Street = ?, Locality = ?, Gender = ?, CreatedDate = ? " + 
			"where UserID = ?";
			jdbcTemplate.update(sql,
					user.getName(),
					user.getEmailAddress(),
					user.getPhoneNumber(),
					user.getDOB(),
					user.getHouseNo(),
					user.getStreet(),
					user.getLocality(),
					user.getGender(),
					user.getCreatedDate(),
					user.getUserID());
		}
	}
	public int delete(Integer uid) {
		// TODO Auto-generated method stub
		String sql = "Delete from Users where UserID = ? ";
		return jdbcTemplate.update(sql, uid);
	}
	@Override
	public void delete(Users t) {
		// TODO Auto-generated method stub
		
	}
	
}
