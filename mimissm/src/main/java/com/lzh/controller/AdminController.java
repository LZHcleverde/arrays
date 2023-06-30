package com.lzh.controller;


import com.lzh.pojo.Admin;
import com.lzh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){

        Admin login = adminService.login(name, pwd);
        if(login != null){
            request.setAttribute("admin",login);
            return "main";
        }
        request.setAttribute("errmsg","对不起，您输入的密码不正确！");
        return "login";
    }

}
