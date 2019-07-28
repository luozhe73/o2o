package com.cvicse.o2o.util;

public class PathUtil {

    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        if (os.toLowerCase().startsWith("win")) {
            basePath += "/images/";
        } else {
            basePath = "/user/";
        }
        return basePath.replace("/", seperator);
    }

    public static String getShopImagePath(long shopId) {

        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}
