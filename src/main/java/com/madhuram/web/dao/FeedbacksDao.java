package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Feedbacks;

@Repository
public class FeedbacksDao implements Dao<Feedbacks>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Feedbacks get(int id) {
		String sql = "select * from Feedbacks where FeedbackID = ?";
		try {
			return (Feedbacks) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Feedbacks.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Feedbacks t) {
		String sql = "insert into Feedbacks (RecordedTime, Subject, FeedbackMessage, UserID, Status)" + 
				"values(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql,
				t.getRecordedTime(),
				t.getSubject(),
				t.getFeedbackMessage(),
				t.getUserID(),
				t.getStatus());
	}

	@Override
	public void update(Feedbacks t) {
		String sql = "update Feedbacks set RecordedTime = ?, Subject = ?, FeedbackMessage = ?, UserID = ?, Status = ?" + 
				" where FeedbackID = ?";
		jdbcTemplate.update(sql,
				t.getRecordedTime(),
				t.getSubject(),
				t.getFeedbackMessage(),
				t.getUserID(),
				t.getFeedbackID(),
				t.getStatus());
		
	}

	@Override
	public void delete(Feedbacks t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Feedbacks> getAll() {
		String sql = "select * from Feedbacks";
		try {
			List<Feedbacks> complaints = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Feedbacks.class));
			return complaints; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Feedbacks> getAllOfUser(Integer id) {
		String sql = "select * from Feedbacks where UserID = ?";
		try {
			List<Feedbacks> complaints = jdbcTemplate.query(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Feedbacks.class));
			return complaints; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void resolve(Integer id) {
		String sql = "update Feedbacks set Status = 1 where FeedbackID = ?";
		jdbcTemplate.update(sql, id);
	}
}
