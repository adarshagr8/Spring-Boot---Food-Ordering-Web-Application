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
		String sql = "Insert into Categories(CategoryName, CategoryDescription, ManagerName) values(?,?,?)";
		return jdbcTemplate.update(sql,
				t.getCategoryName(),
				t.getCategoryDescription(),
				t.getManagerName());
	}

	@Override
	public void update(Categories t) {
		String sql = "update Categories set CategoryName = ?, CategoryDescription = ?, ManagerName = ?"
				+ " where CategoryID = ?;";
		jdbcTemplate.update(sql,
				t.getCategoryName(),
				t.getCategoryDescription(),
				t.getManagerName(),
				t.getCategoryID());
		
	}

	@Override
	public void delete(Categories t) {
		String sql = "Delete from Categories where CategoryID = ? ";
		jdbcTemplate.update(sql, t.getCategoryID());
		
	}
	
}
