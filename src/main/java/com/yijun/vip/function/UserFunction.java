package com.yijun.vip.function;

import com.yijun.vip.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kinglas on 2017/7/28.
 */
public interface UserFunction {
    /**用户登录*/
    public UserEntity login(String account,String password) throws  Exception;
    /**修改密码*/
    @Transactional
    UserEntity updatePassword(String id,String oldPassword,String newPassword,String newPasswordConfirm)throws Exception;
}
