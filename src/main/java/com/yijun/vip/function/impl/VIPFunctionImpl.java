package com.yijun.vip.function.impl;

import static com.yijun.common.AssertThrowUtil.*;
import static com.yijun.common.AssertThrowUtil.assertMatchPattern;
import static com.yijun.common.ThisSystemUtil.uuid;

import com.yijun.common.ThisSystemException;
import com.yijun.vip.dao.VIPDao;

import com.yijun.vip.entity.VIPEntity;
import com.yijun.vip.function.VIPFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kinglas on 2017/8/2.
 */
@Service
public class VIPFunctionImpl implements VIPFunction{
    @Autowired
    VIPDao vdao;
    @Override
    public VIPEntity queryVip(String code) throws Exception {
        //1.验证参数
        /*code = $("VIP账号必须填写!",code);*/
        //2.业务处理
        VIPEntity v = vdao.select("code",code);

        if(v==null){
            throw new ThisSystemException("未找到此客户["+code+"]");
        }
        if(v.getSex()==1){
            v.setGender("男");
        }else{
            v.setGender("女");
        }
        v.setMoney(String.valueOf(v.getAmount()/100.0));
        //3.封装业务结果
        return v;
    }

    @Override
    public List<VIPEntity> queryAllVips() throws Exception {
        List<VIPEntity> vips = vdao.selectAllVips();
        for(VIPEntity vip:vips){
            if(vip.getSex()==1){
                vip.setGender("男");
            }else{
                vip.setGender("女");
            }
            vip.setMoney(String.valueOf(vip.getAmount()/100.0));
        }
        if (vips==null||vips.size()==0){
            throw new ThisSystemException("没有用户！");
        }
        return vips;
    }

//    @Override
//    public List<VIPEntity> queryVips() throws Exception {
//        List<VIPEntity> vips = (List<VIPEntity>) vdao.selectAll();
//        System.out.println("aaaa");
//        for(VIPEntity v:vips){
//            if(v.getSex()==1){
//                v.setGender("男");
//            }else{
//                v.setGender("女");
//            }
//            v.setMoney(String.valueOf(v.getAmount()/100.0));
//        }
//        return vips;
//    }

    @Override
    public VIPEntity addVip(VIPEntity vip) throws Exception {
        /*这里的code指代手机号*/
        String code = $("手机号不能为空！",vip.getCode());
        String name = $("姓名不能为空！",vip.getName());
        /*这里的code指代手机号,验证号码是否合法（格式是否正确）*/
        assertMatchPattern("手机号码不合法！","\\d{11}",code);
        /*这里的code指代手机号，验证手机号是否已存在于数据库*/
        assertFalse("该手机号已存在！",vdao.exists("code",code));
        assertMatchPattern("姓名不合法","[\u4e00-\u9fa5]{2,}",name);
        boolean male = "1".equals(vip.getSex());
        Integer age = vip.getAge();
        if(age==null){
            age = 18;
        }
        vip.setId(uuid());
        vip.setAmount(0);
        vip.setRank(1);
        vdao.insert(vip);
        return vip;
    }

    @Override
    public void updateVip(VIPEntity vip) throws Exception {
        vdao.updateVip(vip);
    }

    @Override
    public void deleteVip(String code) throws Exception {
        assertNotNull("该用户不存在！",code);
        vdao.delete("code",code);
    }
}
