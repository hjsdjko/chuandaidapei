package com.dao;

import com.entity.ChuandaCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuandaCollectionView;

/**
 * 穿搭收藏 Dao 接口
 *
 * @author 
 */
public interface ChuandaCollectionDao extends BaseMapper<ChuandaCollectionEntity> {

   List<ChuandaCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
