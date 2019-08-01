package com.cvicse.o2o.dao;

import com.cvicse.o2o.BaseTest;
import com.cvicse.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory() {
        List<ShopCategory> list = shopCategoryDao.queryShopCategory(new ShopCategory());
        System.out.println(list);
    }
}
