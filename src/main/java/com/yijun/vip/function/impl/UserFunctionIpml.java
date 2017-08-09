package com.yijun.vip.function.impl;

import static com.yijun.common.AssertThrowUtil.*;
import static com.yijun.common.ThisSystemUtil.md5;

import com.yijun.common.ThisSystemException;
import com.yijun.vip.dao.UserDao;
import com.yijun.vip.entity.UserEntity;
import com.yijun.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kinglas on 2017/7/28.
 */
@Service
public class UserFunctionIpml implements UserFunction {
    @Autowired
    UserDao udao;
    @Override
    public UserEntity login(String account, String password) throws Exception {
        account = $("账户不能为空！",account);
        password = $("密码不能为空！",password);
        UserEntity u = udao.select("account",account);
        if(u==null){
            throw new ThisSystemException("账户不存在！");
        }
        password = md5(password);
        if (!u.getPassword().equals(password)){
            throw new ThisSystemException("密码错误！");
        }
        return u;
    }

    @Override
    public UserEntity updatePassword(String id,String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1.验证参数
        id=$("id不能为空！",id);
        oldPassword=$("原密码不能为空！",oldPassword);
        newPassword=$("新密码不能为空！",newPassword);
        newPasswordConfirm=$("确认密码不能为空！",newPasswordConfirm);
        assertEquals("密码不一致！",newPassword,newPasswordConfirm);

        //2.通过session中的id查找验证用户
        UserEntity u = udao.select("id",id);
        /*if(u==null){
            throw new ThisSystemException("用户不存在！");
        }*/
        assertNotNull("用户不存在！",u);
        //3.验证用户密码
        oldPassword = md5(oldPassword);//旧密码加密后与后台密码比较
        assertEquals("密码错误",u.getPassword(),oldPassword);
        assertNotEquals("新旧密码不能一样",oldPassword,newPassword);

        //4.更新数据库密码
        newPassword = md5(newPassword);//新密码加密过后存到数据库
        u.setPassword(newPassword);
        udao.update(u);
        return u;
    }
}
