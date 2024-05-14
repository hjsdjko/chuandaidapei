
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 穿搭
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuanda")
public class ChuandaController {
    private static final Logger logger = LoggerFactory.getLogger(ChuandaController.class);

    @Autowired
    private ChuandaService chuandaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("chuandaDeleteStart",1);params.put("chuandaDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chuandaService.queryPage(params);

        //字典表数据转换
        List<ChuandaView> list =(List<ChuandaView>)page.getList();
        for(ChuandaView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuandaEntity chuanda = chuandaService.selectById(id);
        if(chuanda !=null){
            //entity转view
            ChuandaView view = new ChuandaView();
            BeanUtils.copyProperties( chuanda , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChuandaEntity chuanda, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuanda:{}",this.getClass().getName(),chuanda.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChuandaEntity> queryWrapper = new EntityWrapper<ChuandaEntity>()
            .eq("chuanda_name", chuanda.getChuandaName())
            .eq("chuanda_types", chuanda.getChuandaTypes())
            .eq("fengge_types", chuanda.getFenggeTypes())
            .eq("changhe_types", chuanda.getChangheTypes())
            .eq("shencai_types", chuanda.getShencaiTypes())
            .eq("chuanda_kucun_number", chuanda.getChuandaKucunNumber())
            .eq("chuanda_price", chuanda.getChuandaPrice())
            .eq("chuanda_clicknum", chuanda.getChuandaClicknum())
            .eq("shangxia_types", chuanda.getShangxiaTypes())
            .eq("chuanda_delete", chuanda.getChuandaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuandaEntity chuandaEntity = chuandaService.selectOne(queryWrapper);
        if(chuandaEntity==null){
            chuanda.setChuandaClicknum(1);
            chuanda.setShangxiaTypes(1);
            chuanda.setChuandaDelete(1);
            chuanda.setCreateTime(new Date());
            chuandaService.insert(chuanda);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuandaEntity chuanda, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuanda:{}",this.getClass().getName(),chuanda.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ChuandaEntity> queryWrapper = new EntityWrapper<ChuandaEntity>()
            .notIn("id",chuanda.getId())
            .andNew()
            .eq("chuanda_name", chuanda.getChuandaName())
            .eq("chuanda_types", chuanda.getChuandaTypes())
            .eq("fengge_types", chuanda.getFenggeTypes())
            .eq("changhe_types", chuanda.getChangheTypes())
            .eq("shencai_types", chuanda.getShencaiTypes())
            .eq("chuanda_kucun_number", chuanda.getChuandaKucunNumber())
            .eq("chuanda_price", chuanda.getChuandaPrice())
            .eq("chuanda_clicknum", chuanda.getChuandaClicknum())
            .eq("shangxia_types", chuanda.getShangxiaTypes())
            .eq("chuanda_delete", chuanda.getChuandaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuandaEntity chuandaEntity = chuandaService.selectOne(queryWrapper);
        if("".equals(chuanda.getChuandaPhoto()) || "null".equals(chuanda.getChuandaPhoto())){
                chuanda.setChuandaPhoto(null);
        }
        if(chuandaEntity==null){
            chuandaService.updateById(chuanda);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ChuandaEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChuandaEntity chuandaEntity = new ChuandaEntity();
            chuandaEntity.setId(id);
            chuandaEntity.setChuandaDelete(2);
            list.add(chuandaEntity);
        }
        if(list != null && list.size() >0){
            chuandaService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChuandaEntity> chuandaList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChuandaEntity chuandaEntity = new ChuandaEntity();
//                            chuandaEntity.setChuandaName(data.get(0));                    //穿搭名称 要改的
//                            chuandaEntity.setChuandaPhoto("");//照片
//                            chuandaEntity.setChuandaTypes(Integer.valueOf(data.get(0)));   //穿搭类型 要改的
//                            chuandaEntity.setFenggeTypes(Integer.valueOf(data.get(0)));   //风格 要改的
//                            chuandaEntity.setChangheTypes(Integer.valueOf(data.get(0)));   //场合 要改的
//                            chuandaEntity.setShencaiTypes(Integer.valueOf(data.get(0)));   //身材 要改的
//                            chuandaEntity.setChuandaKucunNumber(Integer.valueOf(data.get(0)));   //穿搭库存 要改的
//                            chuandaEntity.setChuandaPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            chuandaEntity.setChuandaOldMoney(data.get(0));                    //穿搭原价 要改的
//                            chuandaEntity.setChuandaNewMoney(data.get(0));                    //现价/积分 要改的
//                            chuandaEntity.setChuandaClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            chuandaEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chuandaEntity.setChuandaDelete(1);//逻辑删除字段
//                            chuandaEntity.setChuandaContent("");//照片
//                            chuandaEntity.setCreateTime(date);//时间
                            chuandaList.add(chuandaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chuandaService.insertBatch(chuandaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chuandaService.queryPage(params);

        //字典表数据转换
        List<ChuandaView> list =(List<ChuandaView>)page.getList();
        for(ChuandaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuandaEntity chuanda = chuandaService.selectById(id);
            if(chuanda !=null){

                //点击数量加1
                chuanda.setChuandaClicknum(chuanda.getChuandaClicknum()+1);
                chuandaService.updateById(chuanda);

                //entity转view
                ChuandaView view = new ChuandaView();
                BeanUtils.copyProperties( chuanda , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChuandaEntity chuanda, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuanda:{}",this.getClass().getName(),chuanda.toString());
        Wrapper<ChuandaEntity> queryWrapper = new EntityWrapper<ChuandaEntity>()
            .eq("chuanda_name", chuanda.getChuandaName())
            .eq("chuanda_types", chuanda.getChuandaTypes())
            .eq("fengge_types", chuanda.getFenggeTypes())
            .eq("changhe_types", chuanda.getChangheTypes())
            .eq("shencai_types", chuanda.getShencaiTypes())
            .eq("chuanda_kucun_number", chuanda.getChuandaKucunNumber())
            .eq("chuanda_price", chuanda.getChuandaPrice())
            .eq("chuanda_clicknum", chuanda.getChuandaClicknum())
            .eq("shangxia_types", chuanda.getShangxiaTypes())
            .eq("chuanda_delete", chuanda.getChuandaDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuandaEntity chuandaEntity = chuandaService.selectOne(queryWrapper);
        if(chuandaEntity==null){
            chuanda.setChuandaDelete(1);
            chuanda.setCreateTime(new Date());
        chuandaService.insert(chuanda);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
