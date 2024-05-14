package com.dao;

import com.entity.ChuandaOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuandaOrderView;

/**
 * 穿搭订单 Dao 接口
 *
 * @author 
 */
public interface ChuandaOrderDao extends BaseMapper<ChuandaOrderEntity> {

   List<ChuandaOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
