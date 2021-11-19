package com.ztgg.ecommerce.service;

import com.ztgg.ecommerce.dto.UserExecution;
import com.ztgg.ecommerce.entity.User;

public interface UserService {

	/**
	 * getUserById
	 * 
	 * @param userId
	 * @return User 
	 */
	User getUserById(Long userId);

	/**
	 * getUserList
	 * 
	 * @param userId
	 * @return User  
	 */
	UserExecution getUserList(User userCondition, int pageIndex, int pageSize);

	/**
	 * 
	 */
	UserExecution modifyUser(User user); //upsert
}
