package com.cvicse.o2o.service;

import com.cvicse.o2o.dto.ShopExecution;
import com.cvicse.o2o.entity.Shop;

import java.io.File;

public interface ShopService {

    ShopExecution addShop(Shop shop, File shopImg);
}