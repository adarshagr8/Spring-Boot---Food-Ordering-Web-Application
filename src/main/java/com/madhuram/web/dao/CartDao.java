package com.madhuram.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Cart;

@Repository
public class CartDao implements CartDaoInter{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Cart get(int ItemID, int UserID) {
		String sql = "select * from Cart where ItemID = ? and UserID = ?";
		try {
			return (Cart) jdbcTemplate.queryForObject(sql,
					new Object[] {ItemID, UserID},
                    new BeanPropertyRowMapper<>(Cart.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Cart> getItemList(int UserID) {
		// TODO Auto-generated method stub
		String sql = "select * from Cart where UserID = ?";
		try {
			List<Cart> items = jdbcTemplate.query(sql,
					new Object[] {UserID},
                    new BeanPropertyRowMapper<>(Cart.class));
			return items; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int save(Cart t) {
		if(get(t.getItemID(), t.getUserID()) == null) {
			String sql = "Insert into Cart(ItemID, UserID, Qty) values(?,?,?)";
			return jdbcTemplate.update(sql,
					t.getItemID(),
					t.getUserID(),
					t.getQty());
		}
		else {
			return update(t);
		}
	}

	@Override
	public int update(Cart t) {
		String sql = "Update Cart Set Qty = ? where UserID = ? and ItemID = ?";
		return jdbcTemplate.update(sql,
				t.getQty(),
				t.getUserID(),
				t.getItemID());
	}

	public int delete(Integer uid, Integer iid) {
		String sql = "Delete from Cart where UserID = ? and ItemID = ?";
		return jdbcTemplate.update(sql,
				uid, iid);
		
	}
	public int clearCart(Integer uid) {
		String sql = "Delete from Cart where UserID = ?";
		return jdbcTemplate.update(sql,
				uid);
	}
	@Override
	public void delete(Cart c) {
		// TODO Auto-generated method stub
		
	}
}
