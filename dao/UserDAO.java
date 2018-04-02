package com.wells.dao;

import java.util.List;

import com.wells.bean.User;

public interface UserDAO {
	public void createUser(User user);
	public void upadateUser(User user);
	public List<User> listUser();
	public void delete(int id);
	
}
