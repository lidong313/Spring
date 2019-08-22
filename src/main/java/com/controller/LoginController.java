package com.controller;

import com.entity.Student;
import com.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login.do")
    public String login(HttpServletRequest req, HttpServletResponse resp, Student stu, Model model){
        System.out.println("进入Controller");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(stu.getUsername(), stu.getPassword());
        try {
            subject.login(token);
            User dbUser =(User) subject.getPrincipal();
            req.getSession().setAttribute("username",dbUser.getName());
            return "redirect:/jsps/product/main.jsp";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","账户不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码不正确");
        }catch (Exception e){
            model.addAttribute("msg","登录异常");
        }

        return "/product/login.jsp";
    }


}
