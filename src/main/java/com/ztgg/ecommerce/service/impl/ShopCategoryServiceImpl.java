package com.ztgg.ecommerce.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztgg.ecommerce.dao.ShopCategoryDao;
import com.ztgg.ecommerce.entity.ShopCategory;
import com.ztgg.ecommerce.exceptions.ShopOperationException;
import com.ztgg.ecommerce.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

	@Override
	@Transactional
	public int addShopCategory(ShopCategory shopCategory) {
		// empty shop input
		if (shopCategory == null) {
			return 0;
		}
		
		try {
			shopCategory.setTimeCreated(new Date());
			shopCategory.setTimeUpdated(new Date());
			
			int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
			
			if (effectedNum <= 0) {
				throw new ShopOperationException("error creating new shop category");
			} 
			// TODO: need to update with image check
			// else {}
		} catch (Exception e) {
			throw new ShopOperationException("addShopCategory error:" + e.getMessage());
		}
		return 1;
	}
}
