
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
 * 穿搭订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuandaOrder")
public class ChuandaOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChuandaOrderController.class);

    @Autowired
    private ChuandaOrderService chuandaOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private AddressService addressService;
    @Autowired
    private ChuandaService chuandaService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;
@Autowired
private ChuandaCommentbackService chuandaCommentbackService;



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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chuandaOrderService.queryPage(params);

        //字典表数据转换
        List<ChuandaOrderView> list =(List<ChuandaOrderView>)page.getList();
        for(ChuandaOrderView c:list){
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
        ChuandaOrderEntity chuandaOrder = chuandaOrderService.selectById(id);
        if(chuandaOrder !=null){
            //entity转view
            ChuandaOrderView view = new ChuandaOrderView();
            BeanUtils.copyProperties( chuandaOrder , view );//把实体数据重构到view中

                //级联表
                AddressEntity address = addressService.selectById(chuandaOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                    view.setAddressYonghuId(address.getYonghuId());
                }
                //级联表
                ChuandaEntity chuanda = chuandaService.selectById(chuandaOrder.getChuandaId());
                if(chuanda != null){
                    BeanUtils.copyProperties( chuanda , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChuandaId(chuanda.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(chuandaOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R save(@RequestBody ChuandaOrderEntity chuandaOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuandaOrder:{}",this.getClass().getName(),chuandaOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chuandaOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chuandaOrder.setInsertTime(new Date());
        chuandaOrder.setCreateTime(new Date());
        chuandaOrderService.insert(chuandaOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuandaOrderEntity chuandaOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuandaOrder:{}",this.getClass().getName(),chuandaOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chuandaOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChuandaOrderEntity> queryWrapper = new EntityWrapper<ChuandaOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuandaOrderEntity chuandaOrderEntity = chuandaOrderService.selectOne(queryWrapper);
        if(chuandaOrderEntity==null){
            chuandaOrderService.updateById(chuandaOrder);//根据id更新
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
        chuandaOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChuandaOrderEntity> chuandaOrderList = new ArrayList<>();//上传的东西
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
                            ChuandaOrderEntity chuandaOrderEntity = new ChuandaOrderEntity();
//                            chuandaOrderEntity.setChuandaOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            chuandaOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收获地址 要改的
//                            chuandaOrderEntity.setChuandaId(Integer.valueOf(data.get(0)));   //穿搭 要改的
//                            chuandaOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chuandaOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            chuandaOrderEntity.setChuandaOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            chuandaOrderEntity.setChuandaOrderCourierName(data.get(0));                    //快递公司 要改的
//                            chuandaOrderEntity.setChuandaOrderCourierNumber(data.get(0));                    //订单快递单号 要改的
//                            chuandaOrderEntity.setChuandaOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            chuandaOrderEntity.setChuandaOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            chuandaOrderEntity.setInsertTime(date);//时间
//                            chuandaOrderEntity.setCreateTime(date);//时间
                            chuandaOrderList.add(chuandaOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("chuandaOrderUuidNumber")){
                                    List<String> chuandaOrderUuidNumber = seachFields.get("chuandaOrderUuidNumber");
                                    chuandaOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chuandaOrderUuidNumber = new ArrayList<>();
                                    chuandaOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chuandaOrderUuidNumber",chuandaOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<ChuandaOrderEntity> chuandaOrderEntities_chuandaOrderUuidNumber = chuandaOrderService.selectList(new EntityWrapper<ChuandaOrderEntity>().in("chuanda_order_uuid_number", seachFields.get("chuandaOrderUuidNumber")));
                        if(chuandaOrderEntities_chuandaOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuandaOrderEntity s:chuandaOrderEntities_chuandaOrderUuidNumber){
                                repeatFields.add(s.getChuandaOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chuandaOrderService.insertBatch(chuandaOrderList);
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
        PageUtils page = chuandaOrderService.queryPage(params);

        //字典表数据转换
        List<ChuandaOrderView> list =(List<ChuandaOrderView>)page.getList();
        for(ChuandaOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuandaOrderEntity chuandaOrder = chuandaOrderService.selectById(id);
            if(chuandaOrder !=null){


                //entity转view
                ChuandaOrderView view = new ChuandaOrderView();
                BeanUtils.copyProperties( chuandaOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(chuandaOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    ChuandaEntity chuanda = chuandaService.selectById(chuandaOrder.getChuandaId());
                if(chuanda != null){
                    BeanUtils.copyProperties( chuanda , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChuandaId(chuanda.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chuandaOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody ChuandaOrderEntity chuandaOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuandaOrder:{}",this.getClass().getName(),chuandaOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            ChuandaEntity chuandaEntity = chuandaService.selectById(chuandaOrder.getChuandaId());
            if(chuandaEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double chuandaNewMoney = chuandaEntity.getChuandaNewMoney();

            if(false){
            }
            else if((chuandaEntity.getChuandaKucunNumber() -chuandaOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }
            else if(chuandaEntity.getChuandaNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - chuandaEntity.getChuandaNewMoney()*chuandaOrder.getBuyNumber();//余额
            buyJifen = new BigDecimal(chuandaEntity.getChuandaPrice()).multiply(new BigDecimal(chuandaOrder.getBuyNumber())).doubleValue();//所获积分
            if(balance<0)
                return R.error(511,"余额不够支付");
            chuandaOrder.setChuandaOrderTypes(3); //设置订单状态为已支付
            chuandaOrder.setChuandaOrderTruePrice(chuandaEntity.getChuandaNewMoney()*chuandaOrder.getBuyNumber()); //设置实付价格
            chuandaOrder.setYonghuId(userId); //设置订单支付人id
            chuandaOrder.setChuandaOrderPaymentTypes(1);
            chuandaOrder.setInsertTime(new Date());
            chuandaOrder.setCreateTime(new Date());
                chuandaEntity.setChuandaKucunNumber( chuandaEntity.getChuandaKucunNumber() -chuandaOrder.getBuyNumber());
                chuandaService.updateById(chuandaEntity);
                chuandaOrderService.insert(chuandaOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
            yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String chuandaOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

        Integer chuandaOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("chuandaOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("chuandas"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> chuandas = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<ChuandaOrderEntity> chuandaOrderList = new ArrayList<>();
        //商品表
        List<ChuandaEntity> chuandaList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);
        // 获取折扣
        Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", "huiyuandengji_types")
                .eq("dic_name", "会员等级类型")
                .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                ;
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
        if(dictionaryEntity != null ){
            zhekou = BigDecimal.valueOf(Double.valueOf(dictionaryEntity.getBeizhu()));
        }

        //循环取出需要的数据
        for (Map<String, Object> map : chuandas) {
           //取值
            Integer chuandaId = Integer.valueOf(String.valueOf(map.get("chuandaId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            ChuandaEntity chuandaEntity = chuandaService.selectById(chuandaId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(chuandaEntity.getChuandaKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(chuandaEntity.getChuandaName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                chuandaEntity.setChuandaKucunNumber(chuandaEntity.getChuandaKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            ChuandaOrderEntity chuandaOrderEntity = new ChuandaOrderEntity<>();

            //赋值订单信息
            chuandaOrderEntity.setChuandaOrderUuidNumber(chuandaOrderUuidNumber);//订单号
            chuandaOrderEntity.setAddressId(addressId);//收获地址
            chuandaOrderEntity.setChuandaId(chuandaId);//穿搭
            chuandaOrderEntity.setYonghuId(userId);//用户
            chuandaOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            chuandaOrderEntity.setChuandaOrderTypes(3);//订单类型
            chuandaOrderEntity.setChuandaOrderPaymentTypes(chuandaOrderPaymentTypes);//支付类型
            chuandaOrderEntity.setInsertTime(new Date());//订单创建时间
            chuandaOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(chuandaOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(chuandaEntity.getChuandaNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                        buyJifen = new BigDecimal(chuandaEntity.getChuandaPrice()).multiply(new BigDecimal(buyNumber)).doubleValue();
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额
                    yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
                    yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                        if(yonghuEntity.getYonghuSumJifen()  < 10000)
                            yonghuEntity.setHuiyuandengjiTypes(1);
                        else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                            yonghuEntity.setHuiyuandengjiTypes(2);
                        else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                            yonghuEntity.setHuiyuandengjiTypes(3);


                    chuandaOrderEntity.setChuandaOrderTruePrice(money);

                }
            }
            chuandaOrderList.add(chuandaOrderEntity);
            chuandaList.add(chuandaEntity);

        }
        chuandaOrderService.insertBatch(chuandaOrderList);
        chuandaService.updateBatchById(chuandaList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }











    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        if("用户".equals(role)){
            ChuandaOrderEntity chuandaOrder = chuandaOrderService.selectById(id);
            Integer buyNumber = chuandaOrder.getBuyNumber();
            Integer chuandaOrderPaymentTypes = chuandaOrder.getChuandaOrderPaymentTypes();
            Integer chuandaId = chuandaOrder.getChuandaId();
            if(chuandaId == null)
                return R.error(511,"查不到该物品");
            ChuandaEntity chuandaEntity = chuandaService.selectById(chuandaId);
            if(chuandaEntity == null)
                return R.error(511,"查不到该物品");
            Double chuandaNewMoney = chuandaEntity.getChuandaNewMoney();
            if(chuandaNewMoney == null)
                return R.error(511,"物品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;
            // 获取折扣
            Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                    .eq("dic_code", "huiyuandengji_types")
                    .eq("dic_name", "会员等级类型")
                    .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                    ;
            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
            if(dictionaryEntity != null ){
                zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
            }


            //判断是什么支付方式 1代表余额 2代表积分
            if(chuandaOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = chuandaEntity.getChuandaNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                buyJifen = new BigDecimal(chuandaEntity.getChuandaPrice()).multiply(new BigDecimal(buyNumber)).doubleValue();
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
                yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() - buyJifen); //设置总积分
                if(yonghuEntity.getYonghuNewJifen() - buyJifen <0 )
                    return R.error("积分已经消费,无法退款！！！");
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - buyJifen); //设置现积分

                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);

            }

            chuandaEntity.setChuandaKucunNumber(chuandaEntity.getChuandaKucunNumber() + buyNumber);



            chuandaOrder.setChuandaOrderTypes(2);//设置订单状态为退款
            chuandaOrderService.updateById(chuandaOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            chuandaService.updateById(chuandaEntity);//更新订单中物品的信息
            return R.ok();
        }else{
            return R.error(511,"您没有权限退款");
        }
    }


    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String chuandaOrderCourierNumber, String chuandaOrderCourierName){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChuandaOrderEntity  chuandaOrderEntity = new  ChuandaOrderEntity();;
        chuandaOrderEntity.setId(id);
        chuandaOrderEntity.setChuandaOrderTypes(4);
        chuandaOrderEntity.setChuandaOrderCourierNumber(chuandaOrderCourierNumber);
        chuandaOrderEntity.setChuandaOrderCourierName(chuandaOrderCourierName);
        boolean b =  chuandaOrderService.updateById( chuandaOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }









    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChuandaOrderEntity  chuandaOrderEntity = new  ChuandaOrderEntity();
        chuandaOrderEntity.setId(id);
        chuandaOrderEntity.setChuandaOrderTypes(5);
        boolean b =  chuandaOrderService.updateById( chuandaOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer chuandaCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            ChuandaOrderEntity chuandaOrder = chuandaOrderService.selectById(id);
        if(chuandaOrder == null)
            return R.error(511,"查不到该订单");
        if(chuandaOrder.getChuandaOrderTypes() != 5)
            return R.error(511,"您不能评价");
        Integer chuandaId = chuandaOrder.getChuandaId();
        if(chuandaId == null)
            return R.error(511,"查不到该物品");

        ChuandaCommentbackEntity chuandaCommentbackEntity = new ChuandaCommentbackEntity();
            chuandaCommentbackEntity.setId(id);
            chuandaCommentbackEntity.setChuandaId(chuandaId);
            chuandaCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            chuandaCommentbackEntity.setChuandaCommentbackText(commentbackText);
            chuandaCommentbackEntity.setInsertTime(new Date());
            chuandaCommentbackEntity.setReplyText(null);
            chuandaCommentbackEntity.setUpdateTime(null);
            chuandaCommentbackEntity.setCreateTime(new Date());
            chuandaCommentbackService.insert(chuandaCommentbackEntity);

            chuandaOrder.setChuandaOrderTypes(1);//设置订单状态为已评价
            chuandaOrderService.updateById(chuandaOrder);//根据id更新
            return R.ok();
        }else{
            return R.error(511,"您没有权限评价");
        }
    }







}
