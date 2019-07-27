package com.cvicse.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {

	private Long productCategoryId;

	private Long shopId;

	private String productCategoryName;

	private String productCategoryDesc;

	private Integer priority;

	private Date createTime;

	private Date lastEditTime;


}
