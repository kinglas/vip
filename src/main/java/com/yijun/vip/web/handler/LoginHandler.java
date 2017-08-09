package com.yijun.vip.web.handler;

import com.yijun.common.ThisSystemException;
import com.yijun.vip.entity.UserEntity;
import com.yijun.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by kinglas on 2017/7/28.
 */
@Controller
public class LoginHandler {
    @Autowired
    UserFunction fun;
    /*用户登录*/
    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest request){
        try{
            HttpSession session =  request.getSession();
            UserEntity u = fun.login(account,password);
            session.setAttribute("currentUser",u);
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }
    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome.do")
    public String welcome(){
        return "welcome";
    }

    /*注销登录*/
    @RequestMapping("/logout.do")
    public String logOut(HttpSession session){
        session.invalidate();//让session失效
        return "redirect:/login.jsp";
    }
    /*get方式提交表示获取视图，post方式提交表示获取请求*/
    @RequestMapping(method = RequestMethod.GET,path = "/updatepassword.do")
    public String updatepasswordView(){
        return "/updatePassword";
    }
    /*更新密码*/
    @RequestMapping(method = RequestMethod.POST,path = "/updatepassword.do")
    public String updatepassword(String oldPassword,String newPassword,String newPasswordConfirm,HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        UserEntity u = (UserEntity) session.getAttribute("currentUser");
        try {
            fun.updatePassword(u.getId(),oldPassword,newPassword,newPasswordConfirm);

        }catch (ThisSystemException e){
            request.setAttribute("message",e.getMessage());
            return "updatePassword";
        }
        session.setAttribute("message","修改成功，请重新登陆！");
        return "redirect:/login.jsp";
    }
}
