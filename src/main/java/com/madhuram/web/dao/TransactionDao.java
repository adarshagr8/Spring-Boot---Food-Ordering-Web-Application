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
import com.madhuram.web.entities.Transactions;

@Repository
public class TransactionDao implements Dao<Transactions>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Transactions get(String id) {
		String sql = "select * from Transactions where TransactionID = ?";
		try {
			return (Transactions) jdbcTemplate.queryForObject(sql,
					new Object[] {id},
                    new BeanPropertyRowMapper<>(Transactions.class)); 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Transactions> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Transactions";
		try {
			List<Transactions> txn = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Transactions.class));
			return txn; 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Transactions t) {
		String sql = "insert into Transactions (TransactionID, Invoice, BankTransactionID,InvoiceAmount,Status,PaymentMethod,TransactionTime,UserID)" + 
				"values(?, ?, ?, ?, ?, ?, ?, ?)";
				return jdbcTemplate.update(sql,
						t.getTransactionID(),
						t.getInvoice(),
						t.getBankTransactionID(),
						t.getInvoiceAmount(),
						t.getStatus(),
						t.getPaymentMethod(),
						t.getTransactionTime(),
						t.getUserID()
						);
	}

	@Override
	public void update(Transactions t) {
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
	public void delete(Transactions t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transactions get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
