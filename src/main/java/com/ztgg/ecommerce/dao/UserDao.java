package com.ztgg.ecommerce.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ztgg.ecommerce.entity.User;

public interface UserDao {
	/**
	 * paginated view of users list
	 */
	List<User> queryUserList(@Param("userCondition")User userCondition, @Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);

	/**
	 * get the total number of users
	 */
	int queryUserCount(@Param("userCondition")User userCondition);

	/**
	 * find user by id
	 */
	User queryUserById(long userId);

	/**
	 * insert new user
	 */
	int insertUser(User User);

	/**
	 * update existing user
	 */
	int updateUser(User User);
}
