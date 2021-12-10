package com.ztgg.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztgg.ecommerce.dao.UserDao;
import com.ztgg.ecommerce.dto.UserExecution;
import com.ztgg.ecommerce.entity.User;
import com.ztgg.ecommerce.enums.UserStateEnum;
import com.ztgg.ecommerce.exceptions.UserOperationException;
import com.ztgg.ecommerce.service.UserService;
import com.ztgg.ecommerce.util.PageCalculator;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(Long userId) {
		return userDao.queryUserById(userId);
	}

	@Override
	public UserExecution getUserList(User userCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<User> userList = userDao.queryUserList(userCondition, rowIndex, pageSize);
		int count = userDao.queryUserCount(userCondition);
		UserExecution ue = new UserExecution();
		if (userList != null) {
			ue.setUserList(userList);
			ue.setCount(count);
		} else {
			ue.setState(UserStateEnum.INNER_ERROR.getState());
		}
		return ue;
	}
	
	@Override
	@Transactional
	//transactional 事务 - roll-back
	public UserExecution modifyUser(User user) {
		if (user == null || user.getUserId() == null) {
			return new UserExecution(UserStateEnum.EMPTY);
		} else {
			try {
				int effectedNum = userDao.updateUser(user);
				if (effectedNum <= 0) {
					return new UserExecution(UserStateEnum.INNER_ERROR);
				} else {
					user = userDao.queryUserById(user.getUserId());
					return new UserExecution(UserStateEnum.SUCCESS, user);
				}
			} catch (Exception e) {
				throw new UserOperationException("updateUser error: " + e.getMessage());
			}
		}
	}
}
