package com.liu.baobiao.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liu.baobiao.dao.UserDao;
import com.liu.baobiao.model.User;

@Component("userDao")
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
	}

	@Override
	public List<User> getuser() {
		// TODO Auto-generated method stub
		List<User> users = hibernateTemplate.find("from User");
		return users;
	}

	@Override
	public User loadById(int id) {
		// TODO Auto-generated method stub
		User user = (User) hibernateTemplate.load(User.class, id);
		return user;
	}

	@Override
	public User findByusername(String username) {
		// TODO Auto-generated method stub
		List<User> users = hibernateTemplate
				.find("from User u where u.username = '" + username + "'");
		return users.get(0);
	}

}
