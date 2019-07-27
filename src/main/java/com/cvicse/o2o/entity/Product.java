package com.cvicse.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long productId;

    private String productName;

    private String productDesc;

    private String imgAddr;// 简略图

    private String normalPrice;

    private String promotionPrice;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private Integer enableStatus;

    private List<ProductImg> productImgList;

    private ProductCategory productCategory;

    private Shop shop;


}
