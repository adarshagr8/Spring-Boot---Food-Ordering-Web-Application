package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Items;

@Repository
public class ItemsDao implements Dao<Items>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Items get(int id) {
		String sql = "select * from Items where ItemID = ?";
		try {
			return (Items) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Items.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Items> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Items";
		try {
			List<Items> items = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Items.class));
			return items; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Items> getOfCategory(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from Items where CategoryID = ?";
		try {
			List<Items> items = jdbcTemplate.query(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Items.class)); 
			return items; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int save(Items t) {
		t.setEnabled(1);
		String sql = "insert into Items (ItemName, ItemCost, ItemImage, ItemDescription, ExpiryDuration, MaxAllowedQty, MaxTemperature, MinTemperature, CategoryID, enabled)" + 
		"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql,
				t.getItemName(),
				t.getItemCost(),
				t.getItemImage(),
				t.getItemDescription(),
				t.getExpiryDuration(),
				t.getMaxAllowedQty(),
				t.getMaxTemperature(),
				t.getMinTemperature(),
				t.getCategoryID(),
				t.getEnabled());
	}

	@Override
	public void update(Items t) {
		String sql = "update Items set ItemName = ?, ItemCost = ?, ItemImage = ?, ItemDescription = ?, ExpiryDuration = ?, MaxAllowedQty = ?, MaxTemperature = ?, MinTemperature = ?, CategoryID = ?, enabled = ?"
				+ " where ItemID = ?;";
		jdbcTemplate.update(sql,
				t.getItemName(),
				t.getItemCost(),
				t.getItemImage(),
				t.getItemDescription(),
				t.getExpiryDuration(),
				t.getMaxAllowedQty(),
				t.getMaxTemperature(),
				t.getMinTemperature(),
				t.getCategoryID(),
				t.getEnabled(),
				t.getItemID());
	}

	@Override
	public void delete(Items t) {
			
	}
	
	public int disable(Items t) {
		String sql = "update Items set enabled = 0 where ItemID = ?";
		return jdbcTemplate.update(sql,
				t.getItemID());
	}
	public int enable(Items t) {
		String sql = "update Items set enabled = 1 where ItemID = ?";
		return jdbcTemplate.update(sql,
				t.getItemID());
	}
}
