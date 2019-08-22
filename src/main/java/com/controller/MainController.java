package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class MainController {
    @RequestMapping("/login.do")
    public String login(){
      return  null;
    };

}
