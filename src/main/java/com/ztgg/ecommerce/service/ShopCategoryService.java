package com.ztgg.ecommerce.service;

import java.util.List;

import com.ztgg.ecommerce.entity.ShopCategory;



public interface ShopCategoryService {
	
	/**
	 * insert a new shop category
	 * 
	 * @param shopCategory
	 * @return
	 */
	int addShopCategory(ShopCategory shopCategory);

	/**
	 * 
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
