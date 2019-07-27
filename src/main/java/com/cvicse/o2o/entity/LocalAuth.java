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
public class LocalAuth {

    private Long localAuthId;

    private String username;

    private String password;

    private Date createTime;

    private Date lastEditTime;

    private PersonInfo personInfo;

}
