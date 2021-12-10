package com.ztgg.ecommerce.util;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");

	// generate basePath according to OS
	// hard-coded path is not good practice!
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "C:/project/ztgg-image";
		} else {
			basePath = "/Users/youzhedou/Desktop/ztgg-image";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getShopImagePath(long shopId) {
		String imagePath = "upload/images/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
