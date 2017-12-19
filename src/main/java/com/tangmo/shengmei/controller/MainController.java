package com.tangmo.shengmei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chamber1
 * @date 2017-09-12
 */
@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/test")
    public String findOnlineCourse(){
        return "aaaaa";
    }
}
