package com.example.agriculture.controller;

import com.example.agriculture.common.ReturnCodeUtil;
import com.example.agriculture.entity.CommonUse;
import com.example.agriculture.entity.User;
import com.example.agriculture.service.CommonUseService;
import com.example.agriculture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restful/commonUse")
public class CommonUseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonUseService commonUseService;


    //统一的数据查看
    @RequestMapping("/view")
    public ReturnCodeUtil view(@RequestBody CommonUse commonUse) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        if(String.valueOf(commonUse.getUserId()).equals("0") || "".equals(commonUse.getUserFlag()) || commonUse.getUserFlag() == null ){
                returnCodeUtil.setResult(false);
                return returnCodeUtil;
        }
        List<CommonUse> view = commonUseService.view(commonUse);
        returnCodeUtil.setResult(true);
        returnCodeUtil.setData(view);
        return returnCodeUtil;
    }

    //统一的数据更改
    @RequestMapping("/edit")
    public ReturnCodeUtil edit(@RequestBody CommonUse commonUse) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        if(String.valueOf(commonUse.getUserId()).equals("0") || "".equals(commonUse.getUserFlag()) || commonUse.getUserFlag() == null ){
            returnCodeUtil.setResult(false);
            return returnCodeUtil;
        }
        int res = commonUseService.edit(commonUse);
        if(res>0) {
            returnCodeUtil.setResult(true);
        }else returnCodeUtil.setResult(false);
        return returnCodeUtil;
    }

    //统一的数据插入
    @RequestMapping("/add")
    public ReturnCodeUtil add(@RequestBody CommonUse commonUse) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        int add = commonUseService.add(commonUse);
        if(add >0){
            returnCodeUtil.setResult(true);
        }else {
            returnCodeUtil.setResult(false);
        }
        return returnCodeUtil;
    }

    //统一数据删除
        @RequestMapping("/delete")
    public ReturnCodeUtil delete(@RequestBody CommonUse commonUse) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        int res = commonUseService.delete(commonUse);
        if(res >0){
            returnCodeUtil.setResult(true);
        }else {
            returnCodeUtil.setResult(false);
        }
        return returnCodeUtil;
    }





}
