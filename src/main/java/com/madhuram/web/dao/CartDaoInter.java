package com.madhuram.web.dao;

import java.util.List;

import com.madhuram.web.entities.Cart;

public interface CartDaoInter {
	public Cart get(int id1, int id2);
	public List<Cart> getItemList(int id1);
	public int save(Cart c);
	public int update(Cart c);
	public void delete(Cart c);
}
