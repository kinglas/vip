package com.yijun.vip.web.handler;

import com.yijun.common.ThisSystemException;
import com.yijun.vip.entity.VIPEntity;
import com.yijun.vip.entity.VIPRankEntity;
import com.yijun.vip.entity.vipModelEntity;
import com.yijun.vip.function.VIPFunction;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static com.yijun.common.ThisSystemUtil.uuid;

/**
 * Created by kinglas on 2017/8/2.
 */
@Controller
public class VipHandler extends AbstractHandler{
    @Autowired
    VIPFunction fun;
    @RequestMapping(method = RequestMethod.GET,path = "/vip/query.do")
    public String qryView(){
        return "/vip/qry";
    }
    /*用户查询*/
    @RequestMapping(method = RequestMethod.POST,path = "/vip/query.do")
    public String qry(String code, HttpServletRequest req) throws Exception {
        System.out.println("ssss");
        try{
                VIPEntity v = fun.queryVip(code);
                VIPRankEntity rank = this.getRank(req,v.getRank());
                v.setLevel(rank.getName());
                req.setAttribute("v",v);

        }catch (ThisSystemException e){
            req.setAttribute("message",e.getMessage());
        }

        return "/vip/qry";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/vip/add.do")
    public String addView(){
        return "/vip/add";
    }
    /*用户录入*/
    @RequestMapping(method = RequestMethod.POST,path = "/vip/add.do")
    public String addVip(vipModelEntity vm, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("qqqq");
        VIPEntity vipEntity = new VIPEntity();
        vipEntity.setId(uuid());
        vipEntity.setRank(1);
        vipEntity.setAmount(0);
        vipEntity.setName(vm.getName());
        vipEntity.setAddress(vm.getAddress());
        if(""==(vm.getAge())||vm.getAge()==null){
            vm.setAge("18");
        }
        vipEntity.setAge(Integer.parseInt(vm.getAge()));
        vipEntity.setCode(vm.getCode());
        vipEntity.setEmail(vm.getEmail());
        vipEntity.setQq(vm.getQq());
        vipEntity.setRemark(vm.getRemark());
        vipEntity.setZip(vm.getZip());
        vipEntity.setSex(Integer.parseInt(vm.getSex()) );
        try{
            fun.addVip(vipEntity);
            request.setAttribute("message","录入成功！");
            //TODO:后期跳转到消费记录录入页面
        }catch (ThisSystemException e){
            request.setAttribute("message",e.getMessage());
            return "/vip/add";
        }
        return "/vip/add";
    }
    /*单个用户编辑页面*/
    @RequestMapping("/vip/toeditview.do")
    public ModelAndView updateMv(String code,HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("/vip/vipUpdate");
        VIPEntity vipEntity = fun.queryVip(code);
        VIPRankEntity rank = this.getRank(req,vipEntity.getRank());
        vipEntity.setLevel(rank.getName());
        mv.addObject("vipEntity",vipEntity);
        return mv;
    }
    /*用户更新信息保存*/
    @RequestMapping(method = RequestMethod.POST,path = "/vip/update.do")
    public String vipUpdate(vipModelEntity vm) throws Exception {
        VIPEntity vipEntity = new VIPEntity();
        vipEntity.setCode(vm.getCode());
        vipEntity.setName(vm.getName());
        vipEntity.setAddress(vm.getAddress());
        vipEntity.setAge(Integer.parseInt(vm.getAge()));
        vipEntity.setEmail(vm.getEmail());
        vipEntity.setQq(vm.getQq());
        vipEntity.setAddress(vm.getAddress());
        vipEntity.setZip(vm.getZip());
        vipEntity.setRemark(vm.getRemark());
        fun.updateVip(vipEntity);
        return "/vip/qry";
    }
    /*用户管理页面*/
    @RequestMapping("/vip/tomanageView.do")
    public ModelAndView manageMv(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/vip/vipManage");
        VIPRankEntity rank = new VIPRankEntity();
        try {
            List<VIPEntity> vips = fun.queryAllVips();
            for (VIPEntity vipEntity:vips){
                rank = this.getRank(request,vipEntity.getRank());
                vipEntity.setLevel(rank.getName());
            }
            mv.addObject("vips",vips);
            return mv;
        } catch (ThisSystemException e) {
            e.printStackTrace();
            return mv;
        }
    }
    /*用户管理 ======删除====*/
    @RequestMapping("/vip/delete.do")
    public String vipDelete(@Param(value = "code") String code, HttpSession session) throws Exception {
        String message = new String();
        try {
            fun.deleteVip(code);
            message = "删除成功！";
            session.setAttribute("message",message);
            return "redirect:/vip/tomanageView.do";
        } catch (ThisSystemException e) {
            session.setAttribute("message",e.getMessage());
            return "redirect:/vip/tomanageView.do";
        }
    }
    /*用户管理 =====编辑======*/
    @RequestMapping("/vip/edit.do")
    public ModelAndView editMv(String code,HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("/vip/vipUpdate");
        VIPEntity vipEntity = fun.queryVip(code);
        VIPRankEntity rank = this.getRank(req,vipEntity.getRank());
        vipEntity.setLevel(rank.getName());
        mv.addObject("vipEntity",vipEntity);
        return mv;
    }
}
