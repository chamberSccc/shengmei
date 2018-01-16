package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.dao.AdminDao;
import com.tangmo.shengmei.entity.AdminInfo;
import com.tangmo.shengmei.entity.GoodsTypeItem;
import com.tangmo.shengmei.entity.ReportDto;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/1/11
 * @description 管理员控制层
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{
    @Resource
    private AdminDao adminDao;

    /**
     * @api {GET} /admin/report 用户报表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 精品列表
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      start:"分页开始",
     *                      end:"数据长度",
     *                      startDate:"开始日期",
     *                      endDate:"结束日期",
     *                      province:"省",
     *                      city:"市"
     *                   }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        userId: 用户编号,
     *                        mobile: "账号",
     *                        income:"收入",
     *                        expend: "支出",
     *                        balance:"余额",
     *                        withdraw:"提现金额"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/report")
    public Result getUserReport(ReportDto reportDto){
        return ResultUtil.success(adminDao.selectUserReport(reportDto));
    }

    /**
     * @api {GET} admin/conv/{type}/{start}/{end} 获取失效/未失效便民信息
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {int} type 是否失效
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取失效/未失效便民信息
     * @apiParamExample {json} 请求样例：
     *  admin/conv/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ciId: 1,
     *                        title: "文章标题",
     *                        content: "文章内容",
     *                        userId:"用户id",
     *                        userName:"用户姓名",
     *                        viewCount:"浏览数",
     *                        commentCount:"评论数",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区"},{...}
     *                     ]
     *                     }
     */
    @GetMapping("/conv/{type}/{start}/{end}")
    public Result getConvInfo(@PathVariable Byte type,@PathVariable Integer start, @PathVariable Integer end){
        return convInfoService.searchConvList(start,end);
    }

    /**
     * @api {GET} /admin/commodity/{type}/{start}/{end} 获取指定类型商品
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {byte} type 商品类型
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取指定类型商品 区分全新汽配,二手汽配...
     * @apiParamExample {json} 请求样例：
     *  /admin/commodity/1/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cdId: 1,
     *                        title: "商品信息标题1",
     *                        imgId:"商品图片",
     *                        content: "商品信息内容1",
     *                        pricePre:"商品原价1",
     *                        priceNow:"商品现价1",
     *                        cdType:"商品类型1"},
     *                     {
     *                        cdId: 2,
     *                        title: "商品信息标题2",
     *                        imgId:"商品图片",
     *                        content: "商品信息内容2",
     *                        pricePre:"商品原价2",
     *                        priceNow:"商品现价2",
     *                        cdType:"商品类型2"},
     *                     }]
     *                     }
     */
    @GetMapping("/commodity/{type}/{start}/{end}")
    public Result getCommodityList(@PathVariable Integer start, @PathVariable Integer end,@PathVariable Byte type){
        return commodityService.searchCdList(type,start,end);
    }

    /**
     * @api {POST}  /admin 增加管理员用户
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加管理员用户
     * @apiParam {AdminInfo} adminInfo 管理员用户对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      account:"账户名",
     *                      password:"密码"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；registered：手机号已被注册;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("")
    public Result addAdmin(@RequestBody AdminInfo adminInfo){
        return adminService.addAdmin(adminInfo);
    }

    /**
     * @api {POST} /admin/login 管理员登录
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 管理员登录
     * @apiParam {AdminInfo} adminInfo 管理员用户对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      password:"MD5加密后的密码",
     *                      account:"18710889234",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；pwd_error：密码错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/login")
    public Result adminLogin(@RequestBody AdminInfo adminInfo){
        return adminService.adminLogin(adminInfo);
    }

    /**
     * @api {POST} /admin/goods/type/item 增加商品分类
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加商品分类
     * @apiParam {GoodsTypeItem} goodsTypeItem
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      gtId:"商品类型Id",
     *                      name:"名称"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；pwd_error：密码错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/type/item")
    public Result addGoodsTypeItem(@RequestBody GoodsTypeItem goodsTypeItem){
        return null;
    }

    /**
     * @api {PUT} /admin/goods/type/item 增加商品分类
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加商品分类
     * @apiParam {GoodsTypeItem} goodsTypeItem
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      id:"本条记录主键",
     *                      name:"名称"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；pwd_error：密码错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/goods/type/item")
    public Result changeGoodsTypeItem(@RequestBody GoodsTypeItem goodsTypeItem){
        return null;
    }

    /**
     * @api {DELETE} /admin/goods/type/item/{id} 删除商品分类
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {int} id 商品分类值主键
     * @apiDescription 删除商品分类
     * @apiParamExample {json} 请求样例：
     *  /admin/goods/type/item/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/goods/type/item/{id}")
    public Result delGoodsTypeItem(@PathVariable Integer id){
        return null;
    }
}
