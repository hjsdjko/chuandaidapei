package com.entity.model;

import com.entity.ChuandaOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 穿搭订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuandaOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String chuandaOrderUuidNumber;


    /**
     * 收获地址
     */
    private Integer addressId;


    /**
     * 穿搭
     */
    private Integer chuandaId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double chuandaOrderTruePrice;


    /**
     * 快递公司
     */
    private String chuandaOrderCourierName;


    /**
     * 订单快递单号
     */
    private String chuandaOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer chuandaOrderTypes;


    /**
     * 支付类型
     */
    private Integer chuandaOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getChuandaOrderUuidNumber() {
        return chuandaOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setChuandaOrderUuidNumber(String chuandaOrderUuidNumber) {
        this.chuandaOrderUuidNumber = chuandaOrderUuidNumber;
    }
    /**
	 * 获取：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收获地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：穿搭
	 */
    public Integer getChuandaId() {
        return chuandaId;
    }


    /**
	 * 设置：穿搭
	 */
    public void setChuandaId(Integer chuandaId) {
        this.chuandaId = chuandaId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getChuandaOrderTruePrice() {
        return chuandaOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setChuandaOrderTruePrice(Double chuandaOrderTruePrice) {
        this.chuandaOrderTruePrice = chuandaOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getChuandaOrderCourierName() {
        return chuandaOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setChuandaOrderCourierName(String chuandaOrderCourierName) {
        this.chuandaOrderCourierName = chuandaOrderCourierName;
    }
    /**
	 * 获取：订单快递单号
	 */
    public String getChuandaOrderCourierNumber() {
        return chuandaOrderCourierNumber;
    }


    /**
	 * 设置：订单快递单号
	 */
    public void setChuandaOrderCourierNumber(String chuandaOrderCourierNumber) {
        this.chuandaOrderCourierNumber = chuandaOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getChuandaOrderTypes() {
        return chuandaOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setChuandaOrderTypes(Integer chuandaOrderTypes) {
        this.chuandaOrderTypes = chuandaOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getChuandaOrderPaymentTypes() {
        return chuandaOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setChuandaOrderPaymentTypes(Integer chuandaOrderPaymentTypes) {
        this.chuandaOrderPaymentTypes = chuandaOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
