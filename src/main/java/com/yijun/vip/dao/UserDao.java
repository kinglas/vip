package com.yijun.vip.dao;

import com.yijun.common.AbstractDao;
import com.yijun.vip.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kinglas on 2017/7/28.
 */
public interface UserDao extends AbstractDao<UserEntity>{

//    当你使用了使用@Param注解来声明参数时，如果使用 #{} 或 ${} 的方式都可以。
//    当你不使用@Param注解来声明参数时，必须使用使用 #{}方式。如果使用 ${} 的方式，会报错。

//    public UserEntity selectByAccount(@Param("account") String account) throws Exception;
}
