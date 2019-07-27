package com.cvicse.o2o.dao;

import com.cvicse.o2o.entity.Area;

import java.util.List;

public interface AreaDAO {

    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
