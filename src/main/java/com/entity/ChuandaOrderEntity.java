package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 穿搭订单
 *
 * @author 
 * @email
 */
@TableName("chuanda_order")
public class ChuandaOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuandaOrderEntity() {

	}

	public ChuandaOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "chuanda_order_uuid_number")

    private String chuandaOrderUuidNumber;


    /**
     * 收获地址
     */
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 穿搭
     */
    @TableField(value = "chuanda_id")

    private Integer chuandaId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @TableField(value = "chuanda_order_true_price")

    private Double chuandaOrderTruePrice;


    /**
     * 快递公司
     */
    @TableField(value = "chuanda_order_courier_name")

    private String chuandaOrderCourierName;


    /**
     * 订单快递单号
     */
    @TableField(value = "chuanda_order_courier_number")

    private String chuandaOrderCourierNumber;


    /**
     * 订单类型
     */
    @TableField(value = "chuanda_order_types")

    private Integer chuandaOrderTypes;


    /**
     * 支付类型
     */
    @TableField(value = "chuanda_order_payment_types")

    private Integer chuandaOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getChuandaOrderUuidNumber() {
        return chuandaOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setChuandaOrderUuidNumber(String chuandaOrderUuidNumber) {
        this.chuandaOrderUuidNumber = chuandaOrderUuidNumber;
    }
    /**
	 * 设置：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收获地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：穿搭
	 */
    public Integer getChuandaId() {
        return chuandaId;
    }


    /**
	 * 获取：穿搭
	 */

    public void setChuandaId(Integer chuandaId) {
        this.chuandaId = chuandaId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getChuandaOrderTruePrice() {
        return chuandaOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setChuandaOrderTruePrice(Double chuandaOrderTruePrice) {
        this.chuandaOrderTruePrice = chuandaOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getChuandaOrderCourierName() {
        return chuandaOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setChuandaOrderCourierName(String chuandaOrderCourierName) {
        this.chuandaOrderCourierName = chuandaOrderCourierName;
    }
    /**
	 * 设置：订单快递单号
	 */
    public String getChuandaOrderCourierNumber() {
        return chuandaOrderCourierNumber;
    }


    /**
	 * 获取：订单快递单号
	 */

    public void setChuandaOrderCourierNumber(String chuandaOrderCourierNumber) {
        this.chuandaOrderCourierNumber = chuandaOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getChuandaOrderTypes() {
        return chuandaOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setChuandaOrderTypes(Integer chuandaOrderTypes) {
        this.chuandaOrderTypes = chuandaOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getChuandaOrderPaymentTypes() {
        return chuandaOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setChuandaOrderPaymentTypes(Integer chuandaOrderPaymentTypes) {
        this.chuandaOrderPaymentTypes = chuandaOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChuandaOrder{" +
            "id=" + id +
            ", chuandaOrderUuidNumber=" + chuandaOrderUuidNumber +
            ", addressId=" + addressId +
            ", chuandaId=" + chuandaId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", chuandaOrderTruePrice=" + chuandaOrderTruePrice +
            ", chuandaOrderCourierName=" + chuandaOrderCourierName +
            ", chuandaOrderCourierNumber=" + chuandaOrderCourierNumber +
            ", chuandaOrderTypes=" + chuandaOrderTypes +
            ", chuandaOrderPaymentTypes=" + chuandaOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
