package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.CommonDao;
import com.tangmo.shengmei.dao.GoodsRecordDao;
import com.tangmo.shengmei.dao.UserDao;
import com.tangmo.shengmei.entity.FeedBack;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.entity.WithDrawInfo;
import com.tangmo.shengmei.entity.vo.UserVO;
import com.tangmo.shengmei.service.ImgFileService;
import com.tangmo.shengmei.service.UserService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.string.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private ImgFileService imgFileService;
    @Resource
    private GoodsRecordDao goodsRecordDao;
    @Resource
    private CommonDao commonDao;

    @Override
    @Transactional
    public Result addUser(User user) {
        if (user.getPassword() == null || user.getMobile() == null) {
            return ResultUtil.fail();
        }
        User result = userDao.selectByMobile(user.getMobile());
        if(result!=null){
            return ResultUtil.registered();
        }
        //设置token
        String token = EncryptUtil.get32Uuid();
        user.setToken(token);
        int row = userDao.insertSelective(user);
        if (row == 1) {
            User userResult = new User();
            userResult.setUserId(user.getUserId());
            userResult.setToken(user.getToken());
            return ResultUtil.success(userResult);
        }
        return ResultUtil.fail();
    }

    @Override
    @Transactional
    public Result changeUser(User user) {
        if(user.getUserId() == null){
            return ResultUtil.fail();
        }
        userDao.updateById(user);
        return ResultUtil.success();
    }

    @Override
    public Result getUser(Integer userId) {
        return ResultUtil.success(userDao.selectById(userId));
    }

    @Override
    public Result ApplyShopAuth(Integer userId) {
        return null;
    }

    @Override
    public Result uploadAvatar(Integer userId, MultipartFile file) {
        Result result = imgFileService.uploadImg(userId, file);
        String uuId = result.getData().toString();
        userDao.updateAvatar(userId,uuId);
        return result;
    }

    @Override
    public Result updateMobile(Integer userId, String mobile) {
        return ResultUtil.success(userDao.updateMobile(userId,mobile));
    }

    @Override
    public Result checkMobile(Integer userId, String mobile) {
        UserVO user = userDao.selectById(userId);
        if(user.getMobile().equals(mobile)){
            return ResultUtil.success();
        }
        return ResultUtil.fail();
    }

    @Override
    public Result changePwd(User user) {
        if(user.getUserId() == null || user.getPassword()==null || user.getNewPwd() == null){
            return ResultUtil.fail();
        }
        User result = userDao.selectLoginById(user.getUserId());
        if(!result.getPassword().equals(user.getPassword())){
            return ResultUtil.pwdError();
        }
        userDao.updatePwd(user);
        return ResultUtil.success();
    }

    @Override
    public Result resetPwd(User user) {
        if(user.getNewPwd() == null){
            return ResultUtil.fail();
        }
        userDao.updatePwdByMobile(user);
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addWithDraw(WithDrawInfo withDrawInfo) {
        if(withDrawInfo.getUserId() == null || withDrawInfo.getAmount() == null){
            return ResultUtil.fail();
        }
        if(withDrawInfo.getOrderNum() ==null || withDrawInfo.getWiWay() == null){
            return ResultUtil.fail();
        }
        userDao.insertWithDraw(withDrawInfo);
        return ResultUtil.success();
    }

    @Override
    public Result searchWithDrawInfo(Integer userId) {
        return ResultUtil.success(userDao.selectWithDrawByUserId(userId));
    }

    @Override
    public Result addFeedBack(FeedBack feedBack) {
        if(feedBack.getUserId() == null){
            return ResultUtil.error("用户信息为空");
        }
        commonDao.insertFeedBack(feedBack);
        return ResultUtil.success();
    }

    @Override
    public Result searchBuyRecord(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(goodsRecordDao.selectUserBuyRecord(userId, start, end));
    }

    @Override
    public Result searchSellRecord(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(goodsRecordDao.selectUserSellRecord(userId, start, end));
    }

    @Override
    public Result delMultiBuyRecord(Integer[] brIds) {
        goodsRecordDao.deleteMultiBuyRecord(brIds);
        return ResultUtil.success();
    }

    @Override
    public Result delMultiSellRecord(Integer[] srIds) {
        goodsRecordDao.deleteMultiSellRecord(srIds);
        return ResultUtil.success();
    }

    @Override
    public Result login(User user) {
        if(user.getPassword()==null || user.getMobile()==null){
            return ResultUtil.fail();
        }
        User checkUser = userDao.selectByMobile(user.getMobile());
        if(checkUser == null){
            return ResultUtil.pwdError();
        }
        if(checkUser.getPassword().equals(user.getPassword())){
            checkUser.setPassword(null);
            return ResultUtil.success(checkUser);
        }else{
            return ResultUtil.pwdError();
        }
    }

    @Override
    public String selectToken(Integer userId) {
        return userDao.selectTokenByUserId(userId);
    }

    @Override
    public String getAuthCode(String mobile) {
        return null;
    }

    @Override
    public User searchUserByMobile(String mobile) {
        return userDao.selectByMobile(mobile);
    }
}
