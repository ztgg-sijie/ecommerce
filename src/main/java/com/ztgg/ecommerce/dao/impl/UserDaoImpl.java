package com.ztgg.ecommerce.dao.impl;

import java.util.List;

import com.ztgg.ecommerce.dao.UserDao;
import com.ztgg.ecommerce.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> queryUserList(User userCondition, int rowIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryUserCount(User userCondition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User queryUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(User User) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User User) {
		// TODO Auto-generated method stub
		return 0;
	}

}
