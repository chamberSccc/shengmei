package com.tangmo.shengmei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chamber
 * @date 17/12/19
 * @description: Main Page Controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String getUserInfo(){
        return "aaaaa";
    }
}
