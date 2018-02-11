package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.FeedBack;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.entity.ViewRecord;
import com.tangmo.shengmei.entity.WithDrawInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户信息Dao接口
 */
@Mapper
public interface UserDao {
    /**
     * 增加用户Selective
     *
     * @param user user对象
     * @return
     */
    int insertSelective(User user);

    /**
     * 通过主键查询用户信息
     *
     * @param id user表主键
     * @return
     */
    User selectById(Integer id);

    /**
     * 通过主键修改用户信息
     *
     * @param user
     * @return
     */
    int updateById(User user);

    /**
     * 更新用户的申请商家状态
     *
     * @param userId      用户id
     * @param applyStatus 申请状态
     * @return
     */
    int updateApplyShop(@Param("userId") Integer userId, @Param("applyStatus") Byte applyStatus);

    /**
     * 上传头像
     *
     * @param userId   用户id
     * @param avatarId 图片存储id
     * @return
     */
    int updateAvatar(@Param("userId") Integer userId, @Param("avatarId") String avatarId);

    /**
     * 修改手机号
     *
     * @param userId 用户id
     * @param mobile 手机号
     * @return
     */
    int updateMobile(@Param("userId") Integer userId, @Param("mobile") String mobile);

    /**
     * 通过手机号查询用户信息
     *
     * @param mobile 手机号
     * @return
     */
    User selectByMobile(String mobile);

    /**
     * 更改密码
     *
     * @param user
     * @return
     */
    int updatePwd(User user);

    /**
     * 增加浏览记录
     *
     * @param viewRecord
     * @return
     */
    int insertViewRecord(ViewRecord viewRecord);

    /**
     * 增加提现记录
     *
     * @param withDrawInfo
     * @return
     */
    int insertWithDraw(WithDrawInfo withDrawInfo);

    /**
     * 查询用户订单列表
     *
     * @param userId
     * @return
     */
    List<WithDrawInfo> selectWithDrawByUserId(Integer userId);

    /**
     * 增加反馈信息
     *
     * @param feedBack
     * @return
     */
    int insertFeedBack(FeedBack feedBack);

    /**
     * 查找用户token
     *
     * @param userId
     * @return
     */
    String selectTokenByUserId(Integer userId);

    /**
     * 查询登录信息
     * @param userId
     * @return
     */
    User selectLoginById(Integer userId);
}
