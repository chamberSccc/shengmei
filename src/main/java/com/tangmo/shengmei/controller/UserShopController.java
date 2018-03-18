package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.UserShop;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author boge
 * @date 17/12/29
 * @description 用户店铺信息控制层
 */
public class UserShopController extends BaseController {


    @PostMapping("")
    public Result addUserShop(@RequestBody UserShop userShop){
        return userShopService.addUserShop(userShop);
    }


    @PutMapping("")
    public Result changeUserShop(@RequestBody UserShop userShop){
        return userShopService.changeUserShop(userShop);
    }


    @GetMapping("/{userId}")
    public Result getUserShop(@PathVariable Integer userId){
        return userShopService.searchUserShop(userId);
    }

    @PutMapping("/logo")
    public Result loadLogo(String code){
        return null;
    }


}
