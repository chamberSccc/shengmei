package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.constant.GoodsBelongConst;
import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.entity.CommodityDto;
import com.tangmo.shengmei.entity.GoodsComment;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author boge
 * @date 17/12/25
 * @description 全新汽配控制层
 */

@RestController
@RequestMapping("/commodity")
public class CommodityController extends BaseController {
    /**
     * @api {POST} /commodity/add 增加商品信息
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 增加商品信息
     * @apiParam {Commodity} commodity 商品信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"1",
     *                      title:"标题是什么",
     *                      content:"内容是什么",
     *                      province:"省",
     *                      city:"市",
     *                      district:"区",
     *                      pricePre:"原价",
     *                      priceNow:"现价",
     *                      cdType:"商品类型,0,1,2",
     *                      condition:"新旧程度",
     *                      cdCount:"商品数量",c
     *                      cdColor:"商品颜色,多种颜色以逗号分隔,
     *                      cdSize:"商品规格,多种规格以逗号分隔",
     *                      imgId:商品图片Id,
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/add")
    public Result addCommodity(@RequestBody Commodity commodity){
        return commodityService.addCommodity(commodity);
    }

    /**
     * @api {POST} /commodity/img/{userId} 上传商品图片
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 上传商品图片
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      file:"图片文件"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/img/{userId}")
    public Result addCdImg(@PathVariable Integer userId,MultipartFile file){
        return commodityService.addCdImg(userId, file);
    }

    /**
     * @api {PUT} /commodity 修改商品信息
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 增加商品信息
     * @apiParam {Commodity} commodity 商品信息对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cdId:"商品信息主键",
     *                      title:"标题是什么",
     *                      content:"内容是什么",
     *                      priceNow:"现价",
     *                      cdType:"商品类型",
     *                      cdCount:"商品数量",
     *                      imgId:商品图片,
     *                      discountFee:"打折费用",
     *                      expressFee:"物流费用"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("")
    public Result changeCommodity(@RequestBody Commodity commodity){
        return commodityService.changeCommodity(commodity,null);
    }

    /**
     * @api {GET} /commodity/list/{type}/{start}/{end} 获取指定类型商品
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {byte} type 商品类型
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 获取指定类型商品 区分全新汽配,二手汽配...
     * @apiParamExample {json} 请求样例：
     *  /commodity/list/1/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cdId: 1,
     *                        title: "商品信息标题1",
     *                        imgId:"商品图片",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区",
     *                        content: "商品信息内容1",
     *                        pricePre:"商品原价1",
     *                        priceNow:"商品现价1",
     *                        condition:"新旧程度",
     *                        cdType:"商品类型1",},
     *                     {
     *                        cdId: 2,
     *                        title: "商品信息标题2",
     *                        imgId:"商品图片",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区",
     *                        content: "商品信息内容2",
     *                        pricePre:"商品原价2",
     *                        condition:"新旧程度",
     *                        priceNow:"商品现价2",
     *                        cdType:"商品类型2"},
     *                     }]
     *                     }
     */
    @GetMapping("/list/{type}/{start}/{end}")
    public Result getCommodityList(@PathVariable Integer start, @PathVariable Integer end,@PathVariable Byte type){
        return commodityService.searchCdList(type,start,end);
    }

    /**
     * @api {GET} /commodity/user/{userId}/{start}/{end} 获取指定用户的商品
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiParam {int} userId 商品类型
     * @apiDescription 获取指定用户的商品
     * @apiParamExample {json} 请求样例：
     *  /commodity/user/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cdId: 1,
     *                        title: "商品信息标题1",
     *                        imgId:"商品图片",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区",
     *                        content: "商品信息内容1",
     *                        pricePre:"商品原价1",
     *                        priceNow:"商品现价1",
     *                        condition:"新旧程度",
     *                        cdType:"商品类型1"},
     *                     {
     *                        cdId: 2,
     *                        title: "商品信息标题2",
     *                        imgId:"商品图片",
     *                        province:"省",
     *                        city:"市",
     *                        district:"区",
     *                        content: "商品信息内容2",
     *                        pricePre:"商品原价2",
     *                        priceNow:"商品现价2",
     *                        condition:"新旧程度",
     *                        cdType:"商品类型2"},
     *                     }]
     *                     }
     */
    @GetMapping("/user/{userId}/{start}/{end}")
    public Result getUserCdList(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return commodityService.searchUserCdList(userId,start,end);
    }

    /**
     * @api {GET} /commodity/detail/{userId}/{cdId} 获取商品详情
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} cdId 商品主键
     * @apiParam {int} userId 商品类型
     * @apiDescription 获取商品详情
     * @apiParamExample {json} 请求样例：
     *  /commodity/detail/1/1
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                      title:"标题是什么",
     *                      content:"内容是什么",
     *                      imgId:"图片base64编码",
     *                      province:"省",
     *                      city:"市",
     *                      district:"区",
     *                      pricePre:"原价",
     *                      priceNow:"现价",
     *                      cdType:"商品类型",
     *                      condition:"新旧程度",
     *                      cdCount:"商品数量",
     *                      cdColor:"商品颜色,多种颜色以逗号分隔,
     *                      cdSize:"商品规格,多种规格以逗号分隔"
     *                   }
     *                   }
     */
    @GetMapping("/detail/{userId}/{cdId}")
    public Result getCdDetail(@PathVariable Integer userId,@PathVariable Integer cdId){
        return commodityService.getCommodityDetail(userId,cdId);
    }

    /**
     * @api {DELETE} /commodity/{cdId} 删除商品信息
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} cdId 商品表主键
     * @apiDescription 删除用户地址信息
     * @apiParamExample {json} 请求样例：
     *  /commodity/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/{cdId}")
    public Result delCommodity(@PathVariable Integer cdId){
        return commodityService.delCommodity(cdId);
    }

    /**
     * @api {GET} /commodity/comment/list/{cdId}/{start}/{end} 获取个人商品评论
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiParam {int} cdId 商品Id
     * @apiDescription 获取个人商品评论
     * @apiParamExample {json} 请求样例：
     *  /commodity/comment/list/1/0/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        ccId: 评论Id,
     *                        userId: "用户Id",
     *                        userName:用户名字
     *                        avatarId: "头像Id",
     *                        comment:"评论内容"},
     *                     {
     *                        ccId: 评论Id,
     *                        userId: "用户Id",
     *                        userName:用户名字
     *                        avatarId: "头像Id",
     *                        comment:"评论内容"
     *                     }]
     *                     }
     */
    @GetMapping("/comment/list/{cdId}/{start}/{end}")
    public Result getCommentList(@PathVariable Integer cdId,@PathVariable Integer start,@PathVariable Integer end){
        return commodityService.getComments(cdId, GoodsBelongConst.PERSON_GOODS,start,end);
    }

    /**
     * @api {POST} /commodity/comment 增加商品评论
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 增加商品评论
     * @apiParam {GoodsComment} goodsComment 商品评论对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      userId:"用户id",
     *                      goodsId:"商品Id",
     *                      comment:"评论内容",
     *                      star:"商品评价",
     *                      isAnonymous:"是否匿名"
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/comment")
    public Result addComment(@RequestBody GoodsComment goodsComment){
        goodsComment.setBelongType(GoodsBelongConst.PERSON_GOODS);
        return commodityService.addComment(goodsComment);
    }

    /**
     * @api {GET} /commodity/quality/{start}/{end} 精品列表
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 精品列表
     * @apiParamExample {json} 请求样例：
     *  /commodity/quality/1/10
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
     *                        cdType:"商品类型1"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/quality/{start}/{end}")
    public Result getQualityList(@PathVariable Integer start, @PathVariable Integer end){
        return commodityService.getQualityInfo(start,end);
    }

    /**
     * @api {GET} /commodity/view/{userId}}/{start}/{end} 查询浏览记录
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 查询浏览记录
     * @apiParamExample {json} 请求样例：
     *  /commodity/view/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        vrId: "浏览记录主键",
     *                        goodsId:商品信息主键,
     *                        title: "商品信息标题1",
     *                        content: "商品信息内容1",
     *                        imgId:"图片id",
     *                        priceNow:"价格",
     *                        cdType:"商品类型1"},
     *                     {
     *                        vrId: "浏览记录主键",
     *                        goodsId:商品信息主键,
     *                        title: "商品信息标题2",
     *                        content: "商品信息内容2",
     *                        priceNow:"价格",
     *                        cdType:"商品类型2"}
     *                     }]
     *                     }
     */
    @GetMapping("/view/{userId}/{start}/{end}")
    public Result getViewRecord(@PathVariable Integer userId,@PathVariable Integer start,@PathVariable Integer end){
        return commodityService.getViewRecord(userId, start, end);
    }

    /**
     * @api {DELETE} /commodity/view/{vrId} 删除浏览记录
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} vrId 浏览记录主键
     * @apiDescription 删除浏览记录
     * @apiParamExample {json} 请求样例：
     *  commodity/view/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/view/{vrId}")
    public Result delViewRecord(@PathVariable Integer vrId){
        return commodityService.delViewRecord(vrId);
    }

    /**
     * @api {DELETE} /commodity/view/empty/{userId} 清空浏览记录
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiDescription 清空浏览记录
     * @apiParamExample {json} 请求样例：
     *  commodity/view//empty/12
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/view/empty/{userId}")
    public Result emptyViewRecord(@PathVariable Integer userId){
        return commodityService.emptyViewRecord(userId);
    }


    /**
     * @api {DELETE} /commodity/view/multi 删除多条浏览记录
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 删除多条浏览记录
     * @apiParam {vrId} vrId 浏览记录主键
     * @apiParamExample {json} 请求样例:
     * /commodity/view/multi?vrId=1&vrId=2
     * @apiSuccess (success) {DELETE} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {DELETE} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @DeleteMapping("/view/multi")
    public Result deleteMultiView(@RequestParam Integer[] vrId){
        return commodityService.delMultiViewRecord(vrId);
    }

    /**
     * @api {PUT} /commodity/star 商品增加好评
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 商品增加好评
     * @apiParam {Commodity} commodity 商品对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      cdId:"商品Id",
     *                      userId:"用户Id"
     *                   }
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/star")
    public Result addStar(Commodity commodity){
        return commodityService.addCdStar(commodity.getCdId(),commodity.getUserId());
    }

    /**
     * @api {GET} /commodity/select 通过条件筛选商品
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 通过条件筛选商品
     * @apiParam {CommodityDto} commodityDto 商品查询对象
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      city:"城市",
     *                      district:"区域",
     *                      cdClass:"商品分类",
     *                      priceStart:"价格开始区间",
     *                      priceEnd:"价格结束区间",
     *                      start:"分页开始索引,必填",
     *                      end:"分页查询长度,必填",
     *                      star:"好评排序,0正序,1倒序"
     *                   }
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {GET} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {和返回商品信息字段相同}
     */
    @GetMapping("/select")
    public Result getByCondition(CommodityDto commodityDto){
        return commodityService.selectByCondition(commodityDto);
    }


    /**
     * @api {GET} /commodity/quality/{type}/{start}/{end} 指定类型的精品列表
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 指定类型的精品列表
     * @apiParamExample {json} 请求样例：
     *  /commodity/quality/1/1/10
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
     *                        cdType:"商品类型1"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/quality/{type}/{start}/{end}")
    public Result getTypeQualityList(@PathVariable Byte type,@PathVariable Integer start, @PathVariable Integer end){
        return commodityService.searchTypeQualityList(type,start,end);
    }

    /**
     * @api {GET} /commodity/star/{type}/{start}/{end} 指定类型的热门列表
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiDescription 指定类型的热门列表
     * @apiParamExample {json} 请求样例：
     *  /commodity/star/1/1/10
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
     *                        cdType:"商品类型1"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/star/{type}/{start}/{end}")
    public Result getTypeStarList(@PathVariable Byte type,@PathVariable Integer start, @PathVariable Integer end){
        return commodityService.searchTypeStarList(type,start,end);
    }

    /**
     * @api {PUT} /remove/{cdId} 商品下架
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 商品下架
     * @apiParamExample {json} 请求样例:
     *             /commodity/remove/1
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/remove/{cdId}")
    public Result removeCommodity(@PathVariable Integer cdId){
        return commodityService.changeCdState(cdId, (byte) 0);
    }

    /**
     * @api {PUT} /sell/{cdId} 商品上架
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiDescription 商品上架
     * @apiParamExample {json} 请求样例:
     *             /commodity/sell/1
     * @apiSuccess (success) {PUT} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {PUT} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PutMapping("/sell/{cdId}")
    public Result sellCommodity(@PathVariable Integer cdId){
        return commodityService.changeCdState(cdId,(byte)1);
    }

    /**
     * @api {GET} /commodity/record/{userId}/{state}/{start}/{end} 查询上架/下架商品销售记录
     * @apiGroup Commodity
     * @apiVersion 0.0.1
     * @apiParam {int} start 分页起始索引
     * @apiParam {int} end 查询列表长度
     * @apiParam {int} userId 用户Id
     * @apiParam {int} state 0:下架  1:上架
     * @apiDescription 查询上架/下架商品销售记录
     * @apiParamExample {json} 请求样例：
     *  /commodity/record/1/1/1/10
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success",
     *                     "data":{
     *                     [{
     *                        cdId: 1,
     *                        title: "商品信息标题1",
     *                        imgId:"商品图片",
     *                        sellCount:"卖出数量",
     *                        priceNow:"商品现价1",
     *                        cdCount:"剩余数量"
     *                      },
     *                     {...}]
     *                     }
     */
    @GetMapping("/record/{userId}/{state}/{start}/{end}")
    public Result getSellRecourd(@PathVariable Integer userId,@PathVariable Byte state,
                                 @PathVariable Integer start,@PathVariable Integer end){
        return commodityService.searchSellRecord(userId, state, start, end);
    }
}
