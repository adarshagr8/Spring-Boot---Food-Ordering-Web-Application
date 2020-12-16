package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.FAQ;

@Repository
public class FAQDao implements Dao<FAQ>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public FAQ get(int id) {
		String sql = "select * from FAQ where QuestionID = ?";
		try {
			return (FAQ) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(FAQ.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<FAQ> getAll() {
		String sql = "select * from FAQ";
		try {
			List<FAQ> questions = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(FAQ.class));
			return questions; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}


	@Override
	public int save(FAQ faq) {
		String sql = "insert into FAQ (Question, Answer)" + 
		"values(?, ?)";
		return jdbcTemplate.update(sql,
				faq.getQuestion(),
				faq.getAnswer());
	}

	@Override
	public void update(FAQ t) {
		// TODO Auto-generated method stub
		String sql = "update FAQ set Question = ?, Answer = ? where QuestionID = ?";
		jdbcTemplate.update(sql,
				t.getQuestion(),
				t.getAnswer(),
				t.getQuestionID());
	}

	@Override
	public void delete(FAQ t) {
		// TODO Auto-generated method stub
		String sql = "delete from FAQ where QuestionId = ?";
		jdbcTemplate.update(sql,
				t.getQuestionID());
	}
	

}
