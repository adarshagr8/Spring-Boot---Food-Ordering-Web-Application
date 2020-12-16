package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Parameters;
@Repository
public class ParameterDao implements Dao<Parameters>{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Parameters get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Parameters getValue(String parameter) {
		String sql = "select * from Parameter where Parameter = ?";
		try {
			return (Parameters) jdbcTemplate.queryForObject(sql,
					new Object[] {parameter},
                    new BeanPropertyRowMapper<>(Parameters.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<Parameters> getAll() {
		String sql = "select * from Parameters";
		try {
			List<Parameters> parameters = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Parameters.class));
			return parameters; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Parameters t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Parameters t) {
		String sql = "update Parameters set Value = ? where Parameter = ?";
		jdbcTemplate.update(sql, t.getValue(), t.getParameter());
	}

	@Override
	public void delete(Parameters t) {
		// TODO Auto-generated method stub
		
	}
	
}
