package com.wells.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wells.bean.User;
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public void createUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		
	}

	public void upadateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		// TODO Auto-generated method stub
		List<User> list=sessionFactory.getCurrentSession().createQuery("from User").list();
		
		return list;
	
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		    // hibernate deletes objects by the primary key
		    user.setId(id);
	sessionFactory.getCurrentSession().delete(user);
		
	}

}








