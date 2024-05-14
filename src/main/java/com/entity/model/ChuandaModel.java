package com.entity.model;

import com.entity.ChuandaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 穿搭
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuandaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 穿搭名称
     */
    private String chuandaName;


    /**
     * 照片
     */
    private String chuandaPhoto;


    /**
     * 穿搭类型
     */
    private Integer chuandaTypes;


    /**
     * 风格
     */
    private Integer fenggeTypes;


    /**
     * 场合
     */
    private Integer changheTypes;


    /**
     * 身材
     */
    private Integer shencaiTypes;


    /**
     * 穿搭库存
     */
    private Integer chuandaKucunNumber;


    /**
     * 购买获得积分
     */
    private Integer chuandaPrice;


    /**
     * 穿搭原价
     */
    private Double chuandaOldMoney;


    /**
     * 现价/积分
     */
    private Double chuandaNewMoney;


    /**
     * 点击次数
     */
    private Integer chuandaClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer chuandaDelete;


    /**
     * 穿搭简介
     */
    private String chuandaContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：穿搭名称
	 */
    public String getChuandaName() {
        return chuandaName;
    }


    /**
	 * 设置：穿搭名称
	 */
    public void setChuandaName(String chuandaName) {
        this.chuandaName = chuandaName;
    }
    /**
	 * 获取：照片
	 */
    public String getChuandaPhoto() {
        return chuandaPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setChuandaPhoto(String chuandaPhoto) {
        this.chuandaPhoto = chuandaPhoto;
    }
    /**
	 * 获取：穿搭类型
	 */
    public Integer getChuandaTypes() {
        return chuandaTypes;
    }


    /**
	 * 设置：穿搭类型
	 */
    public void setChuandaTypes(Integer chuandaTypes) {
        this.chuandaTypes = chuandaTypes;
    }
    /**
	 * 获取：风格
	 */
    public Integer getFenggeTypes() {
        return fenggeTypes;
    }


    /**
	 * 设置：风格
	 */
    public void setFenggeTypes(Integer fenggeTypes) {
        this.fenggeTypes = fenggeTypes;
    }
    /**
	 * 获取：场合
	 */
    public Integer getChangheTypes() {
        return changheTypes;
    }


    /**
	 * 设置：场合
	 */
    public void setChangheTypes(Integer changheTypes) {
        this.changheTypes = changheTypes;
    }
    /**
	 * 获取：身材
	 */
    public Integer getShencaiTypes() {
        return shencaiTypes;
    }


    /**
	 * 设置：身材
	 */
    public void setShencaiTypes(Integer shencaiTypes) {
        this.shencaiTypes = shencaiTypes;
    }
    /**
	 * 获取：穿搭库存
	 */
    public Integer getChuandaKucunNumber() {
        return chuandaKucunNumber;
    }


    /**
	 * 设置：穿搭库存
	 */
    public void setChuandaKucunNumber(Integer chuandaKucunNumber) {
        this.chuandaKucunNumber = chuandaKucunNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getChuandaPrice() {
        return chuandaPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setChuandaPrice(Integer chuandaPrice) {
        this.chuandaPrice = chuandaPrice;
    }
    /**
	 * 获取：穿搭原价
	 */
    public Double getChuandaOldMoney() {
        return chuandaOldMoney;
    }


    /**
	 * 设置：穿搭原价
	 */
    public void setChuandaOldMoney(Double chuandaOldMoney) {
        this.chuandaOldMoney = chuandaOldMoney;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getChuandaNewMoney() {
        return chuandaNewMoney;
    }


    /**
	 * 设置：现价/积分
	 */
    public void setChuandaNewMoney(Double chuandaNewMoney) {
        this.chuandaNewMoney = chuandaNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getChuandaClicknum() {
        return chuandaClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setChuandaClicknum(Integer chuandaClicknum) {
        this.chuandaClicknum = chuandaClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChuandaDelete() {
        return chuandaDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setChuandaDelete(Integer chuandaDelete) {
        this.chuandaDelete = chuandaDelete;
    }
    /**
	 * 获取：穿搭简介
	 */
    public String getChuandaContent() {
        return chuandaContent;
    }


    /**
	 * 设置：穿搭简介
	 */
    public void setChuandaContent(String chuandaContent) {
        this.chuandaContent = chuandaContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
