package com.ztgg.ecommerce.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.entity.ShopCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testAInsertCategory() throws Exception {
		ShopCategory testCategory = new ShopCategory();
		testCategory.setShopCategoryName("new category 1");
		testCategory.setTimeCreated(new Date());
		testCategory.setTimeUpdated(new Date());
		testCategory.setPriority(0);
		int effectedNum = shopCategoryDao.insertShopCategory(testCategory);
		
		assertEquals(1, effectedNum);
	}

}
