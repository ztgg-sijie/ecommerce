package com.ztgg.ecommerce.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.entity.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest extends BaseTest {
	@Autowired
	private UserDao personInfoDao;

	@Test
	public void testAInsertUser() throws Exception {
		User personInfo = new User();
		personInfo.setName("new user 123");
		personInfo.setGender("F");
		personInfo.setUserType(1);
		personInfo.setTimeCreated(new Date());
		personInfo.setTimeUpdated(new Date());
		personInfo.setEnableStatus(1);
		int effectedNum = personInfoDao.insertUser(personInfo);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryUserById() {
		long userId = 1242;
		User person = personInfoDao.queryUserById(userId);
		System.out.println(person.getName());
	}

}
