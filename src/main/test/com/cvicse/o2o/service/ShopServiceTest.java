package com.cvicse.o2o.service;

import com.cvicse.o2o.BaseTest;
import com.cvicse.o2o.dto.ShopExecution;
import com.cvicse.o2o.entity.Area;
import com.cvicse.o2o.entity.PersonInfo;
import com.cvicse.o2o.entity.Shop;
import com.cvicse.o2o.entity.ShopCategory;
import com.cvicse.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(8L);
        area.setAreaId(3);
        shopCategory.setShopCategoryId(10L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺11111");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("phone1");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File file = new File("C:\\Users\\luozhe73\\Desktop\\xiaohuangren.jpg");

        InputStream is=new FileInputStream(file);

        ShopExecution shopExecution=shopService.addShop(shop,is,file.getName());

       System.out.println(shopExecution);
    }
}
