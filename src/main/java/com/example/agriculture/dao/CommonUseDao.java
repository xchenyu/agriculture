package com.example.agriculture.dao;

import com.example.agriculture.entity.CommonUse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  // 告诉springboot这是一个mybatis的mapepr类
@Repository   // 将dao交由spring容齐管理
public interface CommonUseDao {
    //统一查看
    public  CommonUse   view(CommonUse commonUse);//userFlag

    //通过溯源码查询所有表的信息
    public CommonUse searchOneByOnlyKey(CommonUse commonUse);
}
