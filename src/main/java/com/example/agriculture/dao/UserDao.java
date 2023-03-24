package com.example.agriculture.dao;

import com.example.agriculture.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  // 告诉springboot这是一个mybatis的mapepr类
@Repository   // 将dao交由spring容齐管理
public interface UserDao {

    //用户登录
    public User userLogin(User user);

    public List<User> viewUser(User user);

   //修改用户密码
    public int updatePassword(User user);
    public int deleteUser(User user);
    public int addUser(User user);
    public User viewUserByUserId(User user);

}
