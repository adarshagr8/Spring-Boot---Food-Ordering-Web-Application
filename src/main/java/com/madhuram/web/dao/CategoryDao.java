package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Categories;

@Repository
public class CategoryDao implements Dao<Categories>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Categories get(int id) {
		String sql = "select * from Categories where CategoryID = ?";
		try {
			return (Categories) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Categories.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Categories> getAll() {
		String sql = "select * from Categories";
		try {
			List<Categories> questions = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Categories.class));
			return questions; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Categories t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Categories t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Categories t) {
		// TODO Auto-generated method stub
		
	}
	
}
