package com.cvicse.o2o.service;

import com.cvicse.o2o.dto.ShopExecution;
import com.cvicse.o2o.entity.Shop;

import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImg,String fileName);
}
