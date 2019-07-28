package com.cvicse.o2o.util;

public class PathUtil {

    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "C:/images/";
        } else {
            basePath = "";
        }

        basePath = basePath.replace("/", seperator);
        return basePath;
    }
}
