package com.madhuram.web.dao;

import java.util.List;

import com.madhuram.web.entities.Cart;

public interface Dao<T> {  // Dao Interface
    public T get(int id);
    public List<T> getAll();
    public int save(T t);
    public void update(T t);
    public void delete(T t);
}
