package com.wells.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.bean.User;
import com.wells.dao.UserDAO;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
private UserDAO userDao;
	@Transactional
	public void createUser(User user) {
	userDao.createUser(user); 
		
	}
@Transactional
	public void upadateUser(User user) {
		// TODO Auto-generated method stub
		userDao.upadateUser(user);
	}
@Transactional
	public List<User> listUser() {
		// TODO Auto-generated method stub
	
		return 	userDao.listUser();
	}
@Transactional
public void delete(int id) {
	userDao.delete(id);
	// TODO Auto-generated method stub
	
}

}
