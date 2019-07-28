package com.cvicse.o2o.dto;

import com.cvicse.o2o.entity.Shop;
import com.cvicse.o2o.enums.ShopStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShopExecution {

    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的shop（增删改操作）
    private Shop shop;

    //shop列表（查询店铺使用）
    private List<Shop> shopList;

    //店铺操作失败构造器
    public ShopExecution(ShopStateEnum shopStateEnum) {

        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();

    }

    //店铺操作成功构造器
    public ShopExecution(ShopStateEnum shopStateEnum,Shop shop) {

        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    //店铺操作成功构造器
    public ShopExecution(ShopStateEnum shopStateEnum,List<Shop> shopList) {

        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }
}
