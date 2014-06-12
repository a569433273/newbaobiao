package com.liu.baobiao.dao;

import java.util.List;

import com.liu.baobiao.model.User;

public interface UserDao {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	
	public List<User> getuser();
	public User findByusername(String username);
	
	public User loadById(int id);
}
