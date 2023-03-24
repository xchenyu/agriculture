package com.example.agriculture.service;

import com.example.agriculture.dao.*;
import com.example.agriculture.entity.CommonUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommonUseService {
    private String http = "http://localhost:8081/sdk";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PlanterDao planterDao;
    @Autowired
    private ProcessDao processDao;
    @Autowired
    private LogisticsDao logisticsDao;
    @Autowired
    private SaleDao saleDao;
    @Autowired
    private UserService userService;
    @Autowired
    private CommonUseDao commonUseDao;


    //统一查看   访问该方法需要两个条件 userId 和 userFlag
    public List<CommonUse> view(CommonUse commonUse){
        String userFlag = commonUse.getUserFlag();
        if("1".equals(userFlag)){
           return  planterDao.view(commonUse);
        }else if("2".equals(userFlag)){
            return processDao.view(commonUse);
        }else if("3".equals(userFlag)){
            return logisticsDao.view(commonUse);
        }else if ("4".equals(userFlag)){
            return saleDao.view(commonUse);
        }
        return null;
    }

//统一编辑
    public int edit(CommonUse commonUse){
        if(String.valueOf(commonUse.getUserId()).equals("0")){
            return -1;
        }
        int userId = commonUse.getUserId();
        String key = commonUse.getPlanterOnlyKey();
        Date date = new Date();
        int result = -1;
        String userFlag = commonUse.getUserFlag();
        if("1".equals(userFlag)){
            //没有ID,表示没有数据，执行插入操作
            int res = commonUse.getPlanterId();
            if(0==res || "0".equals(String.valueOf(res))) {
                result = add(commonUse);
                return result;
            }
            result = planterDao.edit(commonUse);
            if(result>0){
                sdk(commonUse.getPlanterOnlyKey(),userId);
            }
            return result;
        }else if("2".equals(userFlag)){
//            commonUse.setDate(date);
            //没有ID,表示没有数据，执行插入操作
            int res = commonUse.getProcessId();
            if(0==res || "0".equals(String.valueOf(res))) {
                int i = add(commonUse);
                return i;
            }
            result = processDao.edit(commonUse);
            sdk(commonUse.getPlanterOnlyKey(),userId);
            return result;
        }else if("3".equals(userFlag)){
//            commonUse.setInTime(date);
//            commonUse.setOutTime(date);
            //没有ID,表示没有数据，执行插入操作
            int res = commonUse.getLogisticsId();
            if(0==res || "0".equals(String.valueOf(res))){
                result= add(commonUse);
                return result;
            }
            result = logisticsDao.edit(commonUse);
            sdk(commonUse.getPlanterOnlyKey(),userId);
            return result;
        }else if ("4".equals(userFlag)){
//            commonUse.setSaleTime(date);
            //没有ID,表示没有数据，执行插入操作
            int res = commonUse.getSaleId();
            if(0==res || "0".equals(String.valueOf(res))){
                result = add(commonUse);
                return result;
            }
            result= saleDao.edit(commonUse);
            sdk(commonUse.getPlanterOnlyKey(),userId);
            return result;
        }
        return -1;
    }

//统一插入
    public int add(CommonUse commonUse){
        String userFlag = commonUse.getUserFlag();
        int userId = commonUse.getUserId();
        String key = commonUse.getPlanterOnlyKey();
        int result = -1;
        if(String.valueOf(commonUse.getUserId()).equals("0")){
           return -1;
        }
        //用户id和用户标志必须有
            if("1".equals(userFlag)){
            commonUse.setPlanterOnlyKey(UUID.randomUUID().toString().replaceAll("-",""));
                int res = planterDao.insert(commonUse);
                if(res > 0){
                    CommonUse commonUse1 = planterDao.viewByPlanterId(commonUse);
                    sdk(commonUse1.getPlanterOnlyKey(),commonUse.getUserId());
                }
                return   res;
        }else if("2".equals(userFlag)){
               result = processDao.insert(commonUse);
               if(result>0){
                   sdk(key,userId);
               }
               return result;

        }else if("3".equals(userFlag)){
                result = logisticsDao.insert(commonUse);
                if(result>0){
                    sdk(key,userId);
                }
                return result;
        }else if ("4".equals(userFlag)){
                result = saleDao.insert(commonUse);
                if(result>0){
                    sdk(key,userId);
                }
                return result;
        }
        return -1;
    }
//统一数据删除
public int delete(CommonUse commonUse){
    String userFlag = commonUse.getUserFlag();
    if("1".equals(userFlag)){
        return   planterDao.delete(commonUse);
    }
    return -1;
}

//通过key查询所有的信息
public CommonUse getAllInfo(String key,String userFlag){
    CommonUse commonUse = new CommonUse();
    commonUse.setPlanterOnlyKey(key);
    CommonUse commonUse1 = commonUseDao.searchOneByOnlyKey(commonUse);
    commonUse1.setUserFlag(userFlag);
    return commonUse1;
}
//重载
public CommonUse getAllInfo(String key){
        CommonUse commonUse = new CommonUse();
        commonUse.setPlanterOnlyKey(key);
        CommonUse commonUse1 = commonUseDao.searchOneByOnlyKey(commonUse);
        return commonUse1;
    }

//sdk通信
    public void sdk(CommonUse commonUse,int res){
        String thisUser  = null;
        if(res>0) {
            if("1".equals(commonUse.getUserFlag())){
                thisUser = "种植商:";
            }else if("2".equals(commonUse.getUserFlag())){
                thisUser = "加工商:";
            }else if("3".equals(commonUse.getUserFlag())){
                thisUser = "运输商:";
            }else if("4".equals(commonUse.getUserFlag())){
                thisUser = "销售商:";
            }
            CommonUse view = commonUseDao.view(commonUse);
            String s = "\"userid\":\"" + commonUse.getUserId()
                    + "\",\"temperature\":\"" + commonUse.getTemperature()
                    + "\",\"planterName\":\"" + commonUse.getPlanterName()
                    + "\",\"envhumidity\":\"" + commonUse.getEnvHumidity()
                    + "\",\"ph\":\"" + commonUse.getPh()
                    + "\",\"light\":\"" + commonUse.getLight()
                    + "\",\"soilhumidity\":\"" + commonUse.getSoilHumidity()
                    + "\",\"factoryname\":\"" + commonUse.getFactoryName()
                    + "\",\"qualityinspector\":\"" + commonUse.getQualityInspector()
                    + "\",\"processperson\":\"" + commonUse.getProcessPerson()
                    + "\",\"date\":\"" + commonUse.getDate()
                    + "\",\"location\":\"" + commonUse.getLocation()
                    + "\",\"intime\":\"" + commonUse.getInTime()
                    + "\",\"outtime\":\"" + commonUse.getOutTime()
                    + "\",\"transportperson\":\"" + commonUse.getTransportPerson()
                    + "\",\"leaveaddress\":\"" + commonUse.getLeaveAddress()
                    + "\",\"arriveaddress\":\"" + commonUse.getArriveAddress()
                    + "\",\"mallname\":\"" + commonUse.getMallName()
                    + "\",\"saletime\":\"" + commonUse.getSaleTime()
                    + "\",\"price\":\"" + commonUse.getPrice()
                    + "\",\"role\":\"" + thisUser+commonUse.getUserName() + "\"";
            String URL_invoke = http + "/invoke?id=" + commonUse.getPlanterOnlyKey() + "&data=" + s;
            ResponseEntity<String> forEntity = restTemplate.getForEntity(URL_invoke, String.class);
        }
    }
    //传入溯源码和用户id 确定用户的操作内容和用户信息 ->写入Fabric
    public void sdk(String key,int userId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CommonUse commonUse = new CommonUse();
        commonUse.setPlanterOnlyKey(key);
        commonUse = commonUseDao.searchOneByOnlyKey(commonUse);
        commonUse = userService.viewUserByUserId(userId, commonUse);//commoUse拥有所有信息
        String thisUser  = null;
            if("1".equals(commonUse.getUserFlag())){
                thisUser = "种植商:";
            }else if("2".equals(commonUse.getUserFlag())){
                thisUser = "加工商:";
            }else if("3".equals(commonUse.getUserFlag())){
                thisUser = "运输商:";
            }else if("4".equals(commonUse.getUserFlag())){
                thisUser = "销售商:";
            }
        System.out.println(commonUse.getInTime()==null);

            String s = "\"userid\":\"" + commonUse.getUserId()
                        + "\",\"temperature\":\"" + commonUse.getTemperature()
                        + "\",\"planterName\":\"" + commonUse.getPlanterName()
                        + "\",\"envhumidity\":\"" + commonUse.getEnvHumidity()
                        + "\",\"ph\":\"" + commonUse.getPh()
                        + "\",\"light\":\"" + commonUse.getLight()
                        + "\",\"soilhumidity\":\"" + commonUse.getSoilHumidity()
                        + "\",\"factoryname\":\"" + commonUse.getFactoryName()
                        + "\",\"qualityinspector\":\"" + commonUse.getQualityInspector()
                        + "\",\"processperson\":\"" + commonUse.getProcessPerson()
                        + "\",\"date\":\"" + (commonUse.getDate()==null?"null":sdf.format(commonUse.getDate()))
                        + "\",\"location\":\"" + commonUse.getLocation()
                        + "\",\"intime\":\"" + (commonUse.getInTime()==null?"null":sdf.format(commonUse.getInTime()))
                        + "\",\"outtime\":\"" +(commonUse.getOutTime()==null?"null":sdf.format(commonUse.getOutTime()))
                        + "\",\"transportperson\":\"" + commonUse.getTransportPerson()
                        + "\",\"leaveaddress\":\"" + commonUse.getLeaveAddress()
                        + "\",\"arriveaddress\":\"" + commonUse.getArriveAddress()
                        + "\",\"mallname\":\"" + commonUse.getMallName()
                        + "\",\"saletime\":\"" + (commonUse.getSaleTime()==null?"null":sdf.format(commonUse.getSaleTime()))
                        + "\",\"price\":\"" + commonUse.getPrice()
                        + "\",\"role\":\"" + thisUser+commonUse.getUserName() + "\"";
            String URL_invoke = http + "/invoke?id=" + commonUse.getPlanterOnlyKey() + "&data=" + s;
        for(int i=0;i<1;i++){
            System.out.println(i);
            restTemplate.getForEntity(URL_invoke, String.class);
        }
//            ResponseEntity<String> forEntity = restTemplate.getForEntity(URL_invoke, String.class);

    }
}
