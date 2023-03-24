package com.example.agriculture.controller;


import com.example.agriculture.entity.User;
import com.example.agriculture.service.UserService;
import com.example.agriculture.common.ReturnCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restful/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户查看
     */
    @RequestMapping("/viewUser")
    public ReturnCodeUtil viewUser(@RequestBody User user) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        if(user == null) {
            returnCodeUtil.setResult(false);
            return returnCodeUtil;
        }
        List<User> oneUser = this.userService.viewUser(user);
        returnCodeUtil.setData(oneUser);
        returnCodeUtil.setResult(true);
        return returnCodeUtil;
    }


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping("/userLogin")
    public ReturnCodeUtil userLogin(@RequestBody User user) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        if(user == null) {
            returnCodeUtil.setResult(false);
            return returnCodeUtil;
        }
        User oneUser = this.userService.userLogin(user);
        if (oneUser != null) {
            returnCodeUtil.setData(oneUser);
            returnCodeUtil.setResult(true);
        } else {
            returnCodeUtil.setResult(false);
        }
        return returnCodeUtil;
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @RequestMapping("/updatePassword")
    public ReturnCodeUtil updatePassword(@RequestBody User user) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        int res = this.userService.updatePassword(user);
        if (res>0) {
            returnCodeUtil.setResult(true);
        } else {
            returnCodeUtil.setResult(false);
        }
        return returnCodeUtil;
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @RequestMapping("/deleteUser")
    public ReturnCodeUtil deleteUser(@RequestBody User user) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        int res = this.userService.deleteUser(user);
        if (res>0) {
            returnCodeUtil.setResult(true);
        } else {
            returnCodeUtil.setResult(false);
        }
        return returnCodeUtil;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public ReturnCodeUtil addUser(@RequestBody User user) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        if(null == user.getUserFlag()){
            returnCodeUtil.setResult(false);
            return returnCodeUtil;
        }
        int res = this.userService.addUser(user);
        if (res>0) {
            returnCodeUtil.setResult(true);
        } else {
            returnCodeUtil.setResult(false);
        }
        return returnCodeUtil;
    }

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    public ReturnCodeUtil register(@RequestBody User user) {
        ReturnCodeUtil returnCodeUtil = new ReturnCodeUtil();
        if(user == null) {
            returnCodeUtil.setResult(false);
            return returnCodeUtil;
        }
        int res = this.userService.addUser(user);
        if(res>0){
            returnCodeUtil.setResult(true);
        }else returnCodeUtil.setResult(false);
        return returnCodeUtil;
    }


}
