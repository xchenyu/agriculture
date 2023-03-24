package com.example.agriculture.service;

import com.example.agriculture.dao.UserDao;
import com.example.agriculture.entity.CommonUse;
import com.example.agriculture.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

   public User  userLogin(User user){
       return userDao.userLogin(user);
   }

   public int updatePassword(User user){
       return userDao.updatePassword(user);
   }

   public int addUser(User user){
       return userDao.addUser(user);
   }

   public int deleteUser(User user){
       return userDao.deleteUser(user);
   }

   public List<User> viewUser(User user){
       return userDao.viewUser(user);
   }

   public User viewUserByUserId(int userId){
       User user = new User();
       user.setUserId(userId);
       return userDao.viewUserByUserId(user);
   }

    public CommonUse viewUserByUserId(int userId,CommonUse commonUse){
        User user = new User();
        user.setUserId(userId);
        User user1 = userDao.viewUserByUserId(user);
        commonUse.setUserFlag(user1.getUserFlag());
        commonUse.setUserId(user1.getUserId());
        commonUse.setUserName(user1.getUserName());
        commonUse.setPassword(user1.getPassword());
        commonUse.setAccount(user1.getAccount());
        return commonUse;
    }


}
