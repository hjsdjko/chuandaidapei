package com.dao;

import com.entity.ChuandaCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuandaCommentbackView;

/**
 * 穿搭评价 Dao 接口
 *
 * @author 
 */
public interface ChuandaCommentbackDao extends BaseMapper<ChuandaCommentbackEntity> {

   List<ChuandaCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
