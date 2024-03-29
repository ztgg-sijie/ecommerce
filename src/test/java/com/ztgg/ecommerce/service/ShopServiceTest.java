package com.ztgg.ecommerce.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.dto.ImageHolder;
import com.ztgg.ecommerce.dto.ShopDto;
import com.ztgg.ecommerce.entity.Area;
import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.entity.ShopCategory;
import com.ztgg.ecommerce.entity.User;
import com.ztgg.ecommerce.enums.ShopStateEnum;
import com.ztgg.ecommerce.exceptions.ShopOperationException;


public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = mockANewShop(1238L, 1, 2L);
		File shopImg = new File("/Users/youzhedou/Desktop/workspace/ecommerce/ecommerce/src/main/resources/test-images/bookstoreimg.png");
		InputStream inputStream = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(),inputStream);
		ShopDto shopDto = shopService.addShop(shop, imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), shopDto.getState());
	}
	
	@Test
	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(6L);
		shop.setShopName("new name after modify");
		File shopImg = new File("/Users/youzhedou/Desktop/workspace/ecommerce/ecommerce/src/main/resources/test-images/newbookstore.png");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder("newbookstore.png",is);
		ShopDto shopExecution = shopService.modifyShop(shop, imageHolder);
		System.out.println("new image file：" + shopExecution.getShop().getShopImg());
	}
	
	@Test
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(2L);
		shopCondition.setShopCategory(sc);
		ShopDto shopDto = shopService.getShopList(shopCondition, 0, 4);
		System.out.println("shop count this page：" + shopDto.getShopList().size());
		System.out.println("total shop count：" + shopDto.getCount());
	}
	
	private Shop mockANewShop(Long userId, Integer areaId, Long shopCategoryId) {
		Shop shop = new Shop();
		User owner = new User();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		
		owner.setUserId(userId);
		area.setAreaId(areaId);
		shopCategory.setShopCategoryId(shopCategoryId);
		
		shop.setArea(area);
		shop.setOwner(owner);
		shop.setShopCategory(shopCategory);
		shop.setShopName("20201230newshop");
		shop.setShopDesc("this is a shop generated by the unit test");
		shop.setShopAddr("123 Boyton Ave");
		shop.setPhone("4323456753");
		shop.setShopImg("testImg");
		shop.setTimeCreated(new Date());
		shop.setEnableStatus(0);
		shop.setPriority(1);
		
		return shop;
	}
}
