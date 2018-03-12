package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.FeedBack;
import com.tangmo.shengmei.entity.GoodsType;
import com.tangmo.shengmei.entity.GoodsTypeItem;
import com.tangmo.shengmei.entity.ParamValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 18/1/15
 * @description 通用dao接口
 */
@Mapper
public interface CommonDao {

    /**
     * 获取商品类型列表
     *
     * @return
     */
    List<GoodsType> selectGoodsType();

    /**
     * 获取商品分类列表
     *
     * @param type
     * @return
     */
    List<GoodsTypeItem> selectItemByType(Integer type);

    /**
     * 增加商品分类
     *
     * @param goodsTypeItem
     * @return
     */
    int insertGoodsTypeItem(GoodsTypeItem goodsTypeItem);

    /**
     * 修改商品分类
     *
     * @param goodsTypeItem
     * @return
     */
    int updateGoodsTypeItem(GoodsTypeItem goodsTypeItem);

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    int deleteGoodsTypeItem(Integer id);

    /**
     * 获取商品分类item最大value
     *
     * @param gtId
     * @return
     */
    int selectMaxItemValue(Byte gtId);

    /**
     * 增加日活量
     *
     * @param ip
     * @return
     */
    int insertAccessCount(String ip);

    /**
     * 增加参数值
     *
     * @param paramValue
     * @return
     */
    int insertParamValue(ParamValue paramValue);

    /**
     * 修改参数值
     *
     * @param paramValue
     * @return
     */
    int updateParamValue(ParamValue paramValue);

    /**
     * 通过类型查询参数值
     *
     * @param type
     * @return
     */
    List<ParamValue> selectPvByType(Byte type);

    /**
     * 通过主键删除参数值
     *
     * @param pvId
     * @return
     */
    int deletePvById(Integer pvId);

    /**
     * 增加用户反馈
     *
     * @param feedBack
     * @return
     */
    int insertFeedBack(FeedBack feedBack);


}
