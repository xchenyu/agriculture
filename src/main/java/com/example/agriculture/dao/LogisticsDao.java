package com.example.agriculture.dao;

import com.example.agriculture.entity.CommonUse;
import com.example.agriculture.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  // 告诉springboot这是一个mybatis的mapepr类
@Repository   // 将dao交由spring容齐管理
public interface LogisticsDao {
    //查看
    public List<CommonUse> view(CommonUse commonUse);
    //编辑
    public int edit(CommonUse commonUse);
    //插入
    public int insert(CommonUse commonUse);
}
