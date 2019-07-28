package com.cvicse.o2o.dao;

import com.cvicse.o2o.BaseTest;
import com.cvicse.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDAO;

    @Test
    public void testQueryArea(){
        List<Area> list = areaDAO.queryArea();
        System.out.println(list);
    }
}
