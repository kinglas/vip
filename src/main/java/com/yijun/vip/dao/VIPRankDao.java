package com.yijun.vip.dao;

import com.yijun.vip.entity.VIPRankEntity;

import java.util.List;

/**
 * Created by kinglas on 2017/8/2.
 */
public interface VIPRankDao {
    List<VIPRankEntity> selectAll() throws Exception;
}
