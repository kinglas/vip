package com.yijun.vip.web.listener;

import com.yijun.vip.dao.VIPDao;
import com.yijun.vip.dao.VIPRankDao;
import com.yijun.vip.entity.VIPRankEntity;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kinglas on 2017/8/2.
 */
public class ApplicationListener extends ContextLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);
        ServletContext sc = servletContextEvent.getServletContext();
        //初始化系统数据
        try {
            this.initVipRank(sc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initVipRank(ServletContext sc) throws Exception {

        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        VIPRankDao rankDao = ac.getBean(VIPRankDao.class);
        List<VIPRankEntity> ranks = rankDao.selectAll();
        Map<Object,Object> rankMap = new HashMap<>();
        for(VIPRankEntity r:ranks){
            rankMap.put(r.getNoId(),r);
            rankMap.put(r.getName(),r);
        }
        sc.setAttribute("RANKS-MAP",rankMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        super.contextDestroyed(servletContextEvent);
    }
}
