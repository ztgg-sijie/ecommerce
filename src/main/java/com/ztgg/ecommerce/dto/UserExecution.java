package com.ztgg.ecommerce.dto;

import java.util.List;

import com.ztgg.ecommerce.entity.User;
import com.ztgg.ecommerce.enums.UserStateEnum;

public class UserExecution {

	private int state;
	private String stateInfo;
	private int count;
	private User user;
	private List<User> userList;

	public UserExecution() {
	}

	// fail case
	public UserExecution(UserStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	//success case
	public UserExecution(UserStateEnum stateEnum, User user) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.user = user;
	}

	//success case
	public UserExecution(UserStateEnum stateEnum, List<User> userList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.userList = userList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}