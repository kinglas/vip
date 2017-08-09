package com.yijun.vip.dao;

import com.yijun.common.AbstractDao;
import com.yijun.vip.entity.VIPEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kinglas on 2017/8/2.
 */
public interface VIPDao extends AbstractDao<VIPEntity> {
    void updateVip(VIPEntity vipEntity)throws Exception;
    List<VIPEntity> selectAllVips() throws Exception;
}
