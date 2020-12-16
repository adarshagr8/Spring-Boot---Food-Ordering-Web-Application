package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Gallery;

@Repository
public class GalleryDao implements Dao<Gallery>{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Gallery get(int id) {
		String sql = "select * from Gallery where PhotoID = ?";
		try {
			return (Gallery) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Gallery.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Gallery> getAll() {
		String sql = "select * from Gallery";
		try {
			List<Gallery> questions = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Gallery.class));
			return questions; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Gallery t) {
		String sql = "insert into Gallery (Tag, Image, DateAdded)" + 
				"values(?, ?, ?)";
		return jdbcTemplate.update(sql,
				t.getTag(),
				t.getImage(),
				t.getDateAdded());
	}

	@Override
	public void update(Gallery t) {
		// TODO Auto-generated method stub
		String sql = "update Gallery set Tag = ?, Image = ? where PhotoID = ?";
		jdbcTemplate.update(sql,
				t.getTag(),
				t.getImage(),
				t.getPhotoID());
	}

	@Override
	public void delete(Gallery t) {
		String sql = "delete from Gallery where PhotoID = ?";
		jdbcTemplate.update(sql,
				t.getPhotoID());
	}
	
}
