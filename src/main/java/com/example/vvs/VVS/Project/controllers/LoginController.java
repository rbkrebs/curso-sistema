package com.example.vvs.VVS.Project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){

        return "login/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){

        return "login/login";
    }

}
