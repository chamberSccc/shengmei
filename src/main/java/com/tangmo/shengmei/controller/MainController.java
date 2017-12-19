package com.tangmo.shengmei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chamber
 * @date 17/12/19
 * @description 主页面接口
 */
@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/test")
    public String findOnlineCourse(){
        return "aaaaa";
    }
}
