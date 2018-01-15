package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.GoodsType;
import com.tangmo.shengmei.entity.GoodsTypeItem;
import org.apache.ibatis.annotations.Mapper;

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
     * @return
     */
    List<GoodsType> selectGoodsType();

    /**
     * 获取商品分类列表
     * @param type
     * @return
     */
    List<GoodsTypeItem> selectItemByType(Byte type);


}
