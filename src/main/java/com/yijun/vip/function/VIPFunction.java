package com.yijun.vip.function;

import com.yijun.vip.entity.VIPEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kinglas on 2017/8/2.
 */
public interface VIPFunction {
    /*客户查询*/
    VIPEntity queryVip(String code)throws Exception;

    List<VIPEntity> queryAllVips() throws Exception;
    /*客户录入*/
    @Transactional
    VIPEntity addVip(VIPEntity vip)throws Exception;
    /*客户编辑*/
    @Transactional
    void updateVip(VIPEntity vip) throws Exception;
    /*删除客户*/
    @Transactional
    void  deleteVip(String code) throws Exception;

}
