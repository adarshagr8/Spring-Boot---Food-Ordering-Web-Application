package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Complaints;
import com.madhuram.web.entities.FAQ;
import com.madhuram.web.entities.Users;

@Repository
public class ComplaintsDao implements Dao<Complaints>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Complaints get(int id) {
		String sql = "select * from Complaints where ComplaintID = ?";
		try {
			return (Complaints) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Complaints.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Complaints t) {
		String sql = "insert into Complaints (RecordedTime, Subject, ComplaintMessage, Image, UserID, Status)" + 
				"values(?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql,
				t.getRecordedTime(),
				t.getSubject(),
				t.getComplaintMessage(),
				t.getImage(),
				t.getUserID(),
				t.getStatus());
	}

	@Override
	public void update(Complaints t) {
		String sql = "update Complaints set RecordedTime = ?, Subject = ?, ComplaintMessage = ?, Image = ?, UserID = ?, Status = ?" + 
				" where ComplaintID = ?";
		jdbcTemplate.update(sql,
				t.getRecordedTime(),
				t.getSubject(),
				t.getComplaintMessage(),
				t.getImage(),
				t.getUserID(),
				t.getStatus(),
				t.getComplaintID());
		
	}

	@Override
	public void delete(Complaints t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Complaints> getAll() {
		String sql = "select * from Complaints";
		try {
			List<Complaints> complaints = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Complaints.class));
			return complaints; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Complaints> getAllOfUser(Integer id) {
		String sql = "select * from Complaints where UserID = ?";
		try {
			List<Complaints> complaints = jdbcTemplate.query(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Complaints.class));
			return complaints; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void resolve(Integer id) {
		String sql = "update Complaints set Status = 'REVIEWED' where ComplaintID = ?";
		jdbcTemplate.update(sql, id);
	}
}
