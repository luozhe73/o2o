package com.cvicse.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random RANDOM = new Random();

    /**
     * 图片加水印
     * @param thumbnailInputStream：上传的图片文件
     * @param targetAddr:相对路径
     * @param fileName
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr) {

        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;

        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

        try {
            Thumbnails.of(thumbnailInputStream)
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }

        return relativeAddr;
    }

    /**
     * 创建目录
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取扩展名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前时间
     *
     * @return
     */
    public static String getRandomFileName() {

        //获取随机五位数
        int rannum = RANDOM.nextInt(89999) + 10000;
        String nowTimeStr = SIMPLE_DATE_FORMAT.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("C:\\Users\\luozhe73\\Desktop\\xiaohuangren.jpg"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8f)
                .toFile("C:\\Users\\luozhe73\\Desktop\\xiaohuangren1.jpg");
    }
}
