package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Items;
import com.madhuram.web.entities.OrderedItems;

@Repository
public class OrderedItemsDao implements Dao<OrderedItems>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public OrderedItems get(int oid, int iid) {
		String sql = "select * from OrderedItems where OrderID = ? and ItemID = ?";
		try {
			return (OrderedItems) jdbcTemplate.queryForObject(sql,
					new Object[] {oid, iid},
                    new BeanPropertyRowMapper<>(OrderedItems.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public List<OrderedItems> getAll() {
		String sql = "select * from OrderedItems";
		try {
			List<OrderedItems> items = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(OrderedItems.class));
			return items; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<OrderedItems> getOrder(int oid) {
		String sql = "select * from OrderedItems where OrderID = ?";
		try {
			List<OrderedItems> items = jdbcTemplate.query(sql,
					new Object[] {oid},
                    new BeanPropertyRowMapper<>(OrderedItems.class));
			return items; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int save(OrderedItems t) {
		String sql = "insert into OrderedItems (OrderID, ItemID, Qty)" + 
				"values(?, ?, ?)";
				return jdbcTemplate.update(sql,
						t.getOrderID(),
						t.getItemID(),
						t.getQty()
						);
	}

	@Override
	public void update(OrderedItems t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderedItems t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderedItems get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
