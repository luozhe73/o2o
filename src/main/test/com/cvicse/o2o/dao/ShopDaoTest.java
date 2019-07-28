package com.cvicse.o2o.dao;

import com.cvicse.o2o.BaseTest;
import com.cvicse.o2o.entity.Area;
import com.cvicse.o2o.entity.PersonInfo;
import com.cvicse.o2o.entity.Shop;
import com.cvicse.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {

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
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("phone");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        System.out.println(effectedNum);
    }

    @Test
    public void testUpdateShop(){

        Shop shop = new Shop();
        shop.setShopId(29L);
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(8L);
        area.setAreaId(3);
        shopCategory.setShopCategoryId(10L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setPhone("phone");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        System.out.println(effectedNum);
    }
}
