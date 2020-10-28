package com.madhuram.web.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.madhuram.web.entities.Orders;

@Repository
public class OrdersDao implements Dao<Orders>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Orders get(int id) {
		String sql = "select * from Orders where OrderID = ?";
		try {
			return (Orders) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Orders.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Orders get(Integer id, LocalDate date, LocalTime time) {
		String sql = "select * from Orders where UserID = ? and OrderDate = ? and OrderTime = ?";
		try {
			return (Orders) jdbcTemplate.queryForObject(sql,
					new Object[] {id, date, time},
                    new BeanPropertyRowMapper<>(Orders.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public List<Orders> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Orders";
		try {
			List<Orders> orders = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Orders.class));
			return orders; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Orders t) {
		String sql = "insert into Orders (OrderDate, OrderTime,TotalQty,Amount,GST,DeliveryCharge,TotalAmount,Status,UserID)" + 
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				return jdbcTemplate.update(sql,
						t.getOrderDate(),
						t.getOrderTime(),
						t.getTotalQty(),
						t.getAmount(),
						t.getGST(),
						t.getDeliveryCharge(),
						t.getTotalAmount(),
						t.getStatus(),
						t.getUserID()
						);
	}

	@Override
	public void update(Orders t) {
		// TODO Auto-generated method stub
		
	}
	
	public int updateTxn(Integer id, String tid) {
		String sql = "update Orders set TransactionID = ? where OrderID = ?";
		return jdbcTemplate.update(sql, tid, id);
	}
	public int updateStatus(Integer id, String s) {
		String sql = "update Orders set Status = ? where OrderID = ?";
		return jdbcTemplate.update(sql, s, id);
	}
	@Override
	public void delete(Orders t) {
		// TODO Auto-generated method stub
		
	}
	
}
