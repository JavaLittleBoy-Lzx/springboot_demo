package com.lzx.springboot.demo.controller;

import com.lzx.springboot.demo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author lzx
 * @Date 2023/7/27 18:12:01
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @GetMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }

    //处理请求登录的表单  每次刷新都需要重新提交表单
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            //账号密码正确重定向到main.html，重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }
    //重定向页面解决了上述问题,重定向是get请求
    @GetMapping("/main.html")
    public String getMain(HttpSession session,Model model) {
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "main";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "main";
    }
}
