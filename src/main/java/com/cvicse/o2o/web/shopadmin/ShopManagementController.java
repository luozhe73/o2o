package com.cvicse.o2o.web.shopadmin;

import com.cvicse.o2o.dto.ShopExecution;
import com.cvicse.o2o.entity.Area;
import com.cvicse.o2o.entity.PersonInfo;
import com.cvicse.o2o.entity.Shop;
import com.cvicse.o2o.entity.ShopCategory;
import com.cvicse.o2o.enums.ShopStateEnum;
import com.cvicse.o2o.service.AreaService;
import com.cvicse.o2o.service.ShopService;
import com.cvicse.o2o.service.ShopCategoryService;
import com.cvicse.o2o.util.HttpServletRequestUtil;
import com.cvicse.o2o.util.ImageUtil;
import com.cvicse.o2o.util.PathUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getShopInitInfo(){
        Map<String, Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList=new ArrayList<>();
        List<Area> areaList=new ArrayList<>();
        try{
            shopCategoryList=shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        return modelMap;
    }

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){

        Map<String, Object> modelMap = new HashMap<>();
        //1.接受并转换相应信息，店铺信息和图片信息
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop=null;
        try {
            shop=objectMapper.readValue(shopStr,Shop.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;

        }
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
            shopImg= (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //2.注册店铺
        if (shop!=null&&shopImg!=null){
            PersonInfo owner=new PersonInfo();
            //Session TODO
            owner.setUserId(1L);
            shop.setOwner(owner);
            File shopImgFile=new File(PathUtil.getImgBasePath()+ ImageUtil.getRandomFileName());
            try{
                shopImgFile.createNewFile();
            }catch (IOException e){
                modelMap.put("success",false);
                modelMap.put("errMsg","请输入店铺信息");
                return modelMap;
            }

            try {
                inputStreamToFile(shopImg.getInputStream(),shopImgFile);
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg","请输入店铺信息");
                return modelMap;
            }
            ShopExecution se = shopService.addShop(shop,shopImgFile);
            if (se.getState()== ShopStateEnum.CHECK.getState()) {
                modelMap.put("success", true);
            }
            else{
                modelMap.put("success",false);
                modelMap.put("errMsg",se.getStateInfo());
            }
            return modelMap;
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }
    }

    private static void inputStreamToFile(InputStream ins, File file){


        try(FileOutputStream os = new FileOutputStream(file);ins){
            int bytesRead = 0;
            byte[] buffer = new byte[1024];

            while ((bytesRead=ins.read(buffer))!=-1){
                os.write(buffer,0,bytesRead);
            }
        }catch (Exception e){
            throw new RuntimeException("调用inputStreamToFile产生异常:"+e.getMessage());
        }
    }
}
