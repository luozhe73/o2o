package com.cvicse.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

    public static void main(String[] args) throws IOException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("C:\\Users\\luozhe73\\Desktop\\xiaohuangren.jpg"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8f)
                .toFile("C:\\Users\\luozhe73\\Desktop\\xiaohuangren1.jpg");
    }
}
