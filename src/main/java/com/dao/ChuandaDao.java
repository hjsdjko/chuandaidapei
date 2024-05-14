package com.dao;

import com.entity.ChuandaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuandaView;

/**
 * 穿搭 Dao 接口
 *
 * @author 
 */
public interface ChuandaDao extends BaseMapper<ChuandaEntity> {

   List<ChuandaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
