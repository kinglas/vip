package com.yijun.vip.web.handler;

import com.yijun.vip.entity.VIPRankEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by kinglas on 2017/8/2.
 */
public abstract class AbstractHandler {
    public VIPRankEntity getRank(HttpServletRequest request,int rank){
        Map<Integer,VIPRankEntity> rankMap = (Map<Integer,VIPRankEntity>)request.getServletContext().getAttribute("RANKS-MAP");
        return rankMap.get(rank);
    }
}
