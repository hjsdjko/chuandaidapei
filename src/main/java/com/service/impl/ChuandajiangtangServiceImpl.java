package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.ChuandajiangtangDao;
import com.entity.ChuandajiangtangEntity;
import com.service.ChuandajiangtangService;
import com.entity.view.ChuandajiangtangView;

/**
 * 穿搭讲堂 服务实现类
 */
@Service("chuandajiangtangService")
@Transactional
public class ChuandajiangtangServiceImpl extends ServiceImpl<ChuandajiangtangDao, ChuandajiangtangEntity> implements ChuandajiangtangService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChuandajiangtangView> page =new Query<ChuandajiangtangView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
