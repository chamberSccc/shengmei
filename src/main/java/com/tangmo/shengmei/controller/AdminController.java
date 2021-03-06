package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.ParamConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.dao.AdminDao;
import com.tangmo.shengmei.entity.AdminInfo;
import com.tangmo.shengmei.entity.GoodsTypeItem;
import com.tangmo.shengmei.entity.ParamValue;
import com.tangmo.shengmei.entity.ReportDto;
import com.tangmo.shengmei.utility.code.Page;
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
     * @api {GET} /admin/conv/{type} 获取失效/未失效便民信息
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {int} type 是否失效
     * @apiDescription 获取失效/未失效便民信息
     * @apiParamExample {json} 请求样例：
     *  admin/conv/1
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
    @GetMapping("/conv/{type}")
    public Result getConvInfo(@PathVariable Byte type,Page page){
        return convInfoService.searchConvList(type,page);
    }

    /**
     * @api {GET} /admin/commodity/{type} 获取指定类型商品
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {byte} type 商品类型
     * @apiDescription 获取指定类型商品 区分全新汽配,二手汽配...
     * @apiParamExample {json} 请求样例：
     *  /admin/commodity/1
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
    @GetMapping("/commodity/{type}")
    public Result getCommodityList(@PathVariable Byte type,Page page){
        return commodityService.searchCdList(type,page);
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
     *                      name:"名称",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；pwd_error：密码错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/type/item")
    public Result addGoodsTypeItem(@RequestBody GoodsTypeItem goodsTypeItem){
        return adminService.addGoodsTypeItem(goodsTypeItem);
    }

    /**
     * @api {PUT} /admin/goods/type/item 修改商品分类
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 修改商品分类
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
        return adminService.changeGoodsTypeItem(goodsTypeItem);
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
        return adminService.delGoodsTypeItem(id);
    }

    /**
     * @api {GET} /admin/car/illegal/{start}/{end} 获取违章信息列表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取违章信息列表
     * @apiParamExample {json} 请求样例：
     *  /admin/car/illegal/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: 主键,
     *                        carId: "车辆Id",
     *                        carNum:"车牌号",
     *                        carProvince:"车辆省份",
     *                        userId:"用户id",
     *                        username: "用户姓名",
     *                        totalPrice:"罚款总数",
     *                        totalScore:"总分数",
     *                        number:"违章编号",
     *                        handleFee:"代缴费用",
     *                        canHandle:"是否可以代缴"}]
     *                     }
     */
    @GetMapping("/car/illegal/{start}/{end}")
    public Result getIllegalInfo(@PathVariable Integer start,@PathVariable Integer end){
        return illegalService.getIllegalList(start, end);
    }

    /**
     * @api {GET} /admin/goods/type 获取商品类型列表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取商品类型列表
     * @apiParamExample {json} 请求样例：
     *  /admin/goods/type
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: "类型主键",
     *                        name:名称,
     *                        value: "对应数字值"},
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/type")
    public Result getGoodsType(){
        return adminService.searchGoodsType();
    }

    /**
     * @api {GET} /admin/goods/class/{type} 获取商品分类列表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取商品分类列表
     * @apiParamExample {json} 请求样例：
     *  /admin/goods/class/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: "分类主键",
     *                        name:"名称",
     *                        gtId: "对应商品类型主键",
     *                        value:"对应数字值"},
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/class/{type}")
    public Result getCarClass(@PathVariable Integer type){
        return adminService.searchGoodsTypeItem(type);
    }


    /**
     * @api {POST} /admin/goods/color 增加商品颜色
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加商品颜色
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      paramValue:"参数值"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/color")
    public Result addGoodsColor(@RequestBody ParamValue paramValue){
        paramValue.setParamType(ParamConst.GOODS_COLOR);
        return null;
    }

    /**
     * @api {POST} /admin/goods/size 增加商品规格
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加商品规格
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      paramValue:"参数值"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/size")
    public Result addGoodSize(@RequestBody ParamValue paramValue){
        paramValue.setParamType(ParamConst.GOODS_SIZE);
        return commonService.addParamValue(paramValue);
    }

    /**
     * @api {POST} /admin/goods/condition 增加商品新旧程度
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加商品规格
     * @apiParam {ParamValue} paramValue 参数对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      paramValue:"参数值"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/goods/condition")
    public Result addGoodsCondition(@RequestBody ParamValue paramValue){
        paramValue.setParamType(ParamConst.GOODS_CONDITION);
        return commonService.addParamValue(paramValue);
    }

    /**
     * @api {DELETE} /admin/goods/condition/{pvId} 删除商品规格
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 删除商品规格
     * @apiParam {int} pvId 主键
     * @apiParamExample {json} 请求样例:
     *      /admin/goods/condition/1
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/goods/condition/{pvId}")
    public Result delGoodsCondition(@PathVariable Integer pvId){
        return commonService.delParamValue(pvId);
    }

    /**
     * @api {GET} /admin/goods/color 获取商品颜色列表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取商品颜色列表
     * @apiParamExample {json} 请求样例：
     *  /admin/goods/color
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        pvId: "主键",
     *                        paramType:"类型",
     *                        paramValue: "参数值"
     *                        },
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/color")
    public Result getGoodsColor(){
        return commonService.searchParamByType(ParamConst.GOODS_COLOR);
    }

    /**
     * @api {GET} /admin/goods/condition 获取商品新旧程度列表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取商品颜色列表
     * @apiParamExample {json} 请求样例：
     *  /admin/goods/condition
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        pvId: "主键",
     *                        paramType:"类型",
     *                        paramValue: "参数值"
     *                        },
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/condition")
    public Result getGoodsCondition(){
        return commonService.searchParamByType(ParamConst.GOODS_CONDITION);
    }

    /**
     * @api {GET} /admin/goods/size 获取商品规格列表
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取商品规格列表
     * @apiParamExample {json} 请求样例：
     *  /admin/goods/size
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        pvId: "主键",
     *                        paramType:"类型",
     *                        paramValue: "参数值"
     *                        },
     *                     ...]
     *                     }
     */
    @GetMapping("/goods/size")
    public Result getGoodSize(){
        return commonService.searchParamByType(ParamConst.GOODS_SIZE);
    }

    /**
     * @api {GET} /admin/shop/unverify 查询未审核商铺信息
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询未审核商铺信息
     * @apiParamExample {json} 请求样例：
     *  /admin/shop/unverify
     * @apiParamExample {json} 返回样例:
     *                   {
     *                      userId:"用户Id",
     *                      userName:"代表人姓名",
     *                      idNumber:"身份证号",
     *                      mobile:"手机号",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                      idFrontImg:"身份证正面照",
     *                      idRearImg:"身份证反面照",
     *                      logoImg:"logo图片",
     *                      licenseImg:"营业执照照片"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/shop/unverify")
    public Result searchUnverify(Page page){
        return shopVerifyService.searchSvInfo((byte) 0,page);
    }

    /**
     * @api {GET} /admin/shop/verify 查询已审核商铺信息
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 查询已审核商铺信息
     * @apiParamExample {json} 请求样例：
     *  /admin/shop/verify
     * @apiParamExample {json} 返回样例:
     *                   {
     *                      userId:"用户Id",
     *                      userName:"代表人姓名",
     *                      idNumber:"身份证号",
     *                      mobile:"手机号",
     *                      shopName:"店铺名称",
     *                      shopIntro:"店铺描述",
     *                      shopAddress:"店铺地址",
     *                      idFrontImg:"身份证正面照",
     *                      idRearImg:"身份证反面照",
     *                      logoImg:"logo图片",
     *                      licenseImg:"营业执照照片"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @GetMapping("/shop/verify")
    public Result searchVerify(Page page){
        return shopVerifyService.searchSvInfo((byte) 1,page);
    }

    /**
     * @api {PUT} /admin/shop/verify/{svId} 通过商家审核
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 通过商家审核
     * @apiParamExample {json} 请求样例:
     *              /shop/verify/1
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/shop/verify/{svId}")
    public Result verifyInfo(@PathVariable Integer svId){
        return shopVerifyService.updateSvState(svId, (byte) 1);
    }

    /**
     * @api {GET} /district 获取行政区域
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取行政区域
     * @apiParamExample {json} 请求样例：
     *          {
     *              city: 西安
     *          }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        id: "主键",
     *                        district:"区",
     *                     ...]
     *                     }
     */
    @GetMapping("/district")
    public Result getDistrict(String city){
        return commonService.searchDistrict(city);
    }

    /**
     * @api {POST} /admin/district 增加区域
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 增加区域
     * @apiParamExample {json} 请求样例:
     *              {
     *                  city:西安,
     *                  district:新城区
     *              }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/district")
    public Result addDistrict(String city,String district){
        return commonService.addDistrict(city, district);
    }

    /**
     * @api {DELETE} /admin/district 删除区域
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 删除区域
     * @apiParam {int} mcId 浏览记录主键
     * @apiParamExample {json} 请求样例:
     *      /admin/district
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/district")
    public Result delDistrict(@RequestParam String district){
        return commonService.delDistrict(district);
    }

    /**
     * @api {DELETE} /admin/goods/size/{pvId} 删除商品规格
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 删除商品规格
     * @apiParam {int} pvId 主键
     * @apiParamExample {json} 请求样例:
     *      /admin/goods/size/1
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/goods/size/{pvId}")
    public Result delCdSize(@PathVariable Integer pvId){
        return commonService.delParamValue(pvId);
    }

}
