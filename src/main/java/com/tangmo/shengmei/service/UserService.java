package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.FeedBack;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.entity.WithDrawInfo;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户服务接口
 */

public interface UserService {

    /**
     * 增加用户信息
     *
     * @param user 用户对象
     * @return
     */
    Result addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return
     */
    Result changeUser(User user);

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return
     */
    Result getUser(Integer userId);

    /**
     * 用户申请成为商家
     *
     * @param userId 用户id
     * @return
     */
    Result ApplyShopAuth(Integer userId);

    /**
     * 上传头像
     *
     * @param userId
     * @param code
     * @return
     */
    Result uploadAvatar(Integer userId, String code);

    /**
     * 修改手机号
     *
     * @param userId 用户id
     * @param mobile 手机号
     * @return
     */
    Result updateMobile(Integer userId, String mobile);

    /**
     * 验证手机号
     *
     * @param userId
     * @param mobile
     * @return
     */
    Result checkMobile(Integer userId, String mobile);

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    Result changePwd(User user);

    /**
     * 增加提现记录
     *
     * @param withDrawInfo
     * @return
     */
    Result addWithDraw(WithDrawInfo withDrawInfo);

    /**
     * 查询提现记录列表
     *
     * @param userId
     * @return
     */
    Result searchWithDrawInfo(Integer userId);

    /**
     * 增加反馈信息
     *
     * @param feedBack
     * @return
     */
    Result addFeedBack(FeedBack feedBack);

    /**
     * 获取用户购买记录
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Result searchBuyRecord(Integer userId, Integer start, Integer end);

    /**
     * 获取用户卖出记录
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Result searchSellRecord(Integer userId, Integer start, Integer end);

    /**
     * 删除多条购买记录
     *
     * @param brIds 购买记录主键数组
     * @return
     */
    Result delMultiBuyRecord(Integer[] brIds);

    /**
     * 删除多条卖出记录
     *
     * @param srIds 卖出记录主键数组
     * @return
     */
    Result delMultiSellRecord(Integer[] srIds);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    Result login(User user);
}
