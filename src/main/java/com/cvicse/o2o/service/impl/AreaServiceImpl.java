package com.cvicse.o2o.service.impl;

import com.cvicse.o2o.dao.AreaDao;
import com.cvicse.o2o.entity.Area;
import com.cvicse.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDAO;

    @Override
    public List<Area> getAreaList() {
        return areaDAO.queryArea();
    }
}
