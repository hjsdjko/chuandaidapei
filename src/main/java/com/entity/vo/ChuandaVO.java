package com.entity.vo;

import com.entity.ChuandaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 穿搭
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuanda")
public class ChuandaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 穿搭名称
     */

    @TableField(value = "chuanda_name")
    private String chuandaName;


    /**
     * 照片
     */

    @TableField(value = "chuanda_photo")
    private String chuandaPhoto;


    /**
     * 穿搭类型
     */

    @TableField(value = "chuanda_types")
    private Integer chuandaTypes;


    /**
     * 风格
     */

    @TableField(value = "fengge_types")
    private Integer fenggeTypes;


    /**
     * 场合
     */

    @TableField(value = "changhe_types")
    private Integer changheTypes;


    /**
     * 身材
     */

    @TableField(value = "shencai_types")
    private Integer shencaiTypes;


    /**
     * 穿搭库存
     */

    @TableField(value = "chuanda_kucun_number")
    private Integer chuandaKucunNumber;


    /**
     * 购买获得积分
     */

    @TableField(value = "chuanda_price")
    private Integer chuandaPrice;


    /**
     * 穿搭原价
     */

    @TableField(value = "chuanda_old_money")
    private Double chuandaOldMoney;


    /**
     * 现价/积分
     */

    @TableField(value = "chuanda_new_money")
    private Double chuandaNewMoney;


    /**
     * 点击次数
     */

    @TableField(value = "chuanda_clicknum")
    private Integer chuandaClicknum;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "chuanda_delete")
    private Integer chuandaDelete;


    /**
     * 穿搭简介
     */

    @TableField(value = "chuanda_content")
    private String chuandaContent;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：穿搭名称
	 */
    public String getChuandaName() {
        return chuandaName;
    }


    /**
	 * 获取：穿搭名称
	 */

    public void setChuandaName(String chuandaName) {
        this.chuandaName = chuandaName;
    }
    /**
	 * 设置：照片
	 */
    public String getChuandaPhoto() {
        return chuandaPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setChuandaPhoto(String chuandaPhoto) {
        this.chuandaPhoto = chuandaPhoto;
    }
    /**
	 * 设置：穿搭类型
	 */
    public Integer getChuandaTypes() {
        return chuandaTypes;
    }


    /**
	 * 获取：穿搭类型
	 */

    public void setChuandaTypes(Integer chuandaTypes) {
        this.chuandaTypes = chuandaTypes;
    }
    /**
	 * 设置：风格
	 */
    public Integer getFenggeTypes() {
        return fenggeTypes;
    }


    /**
	 * 获取：风格
	 */

    public void setFenggeTypes(Integer fenggeTypes) {
        this.fenggeTypes = fenggeTypes;
    }
    /**
	 * 设置：场合
	 */
    public Integer getChangheTypes() {
        return changheTypes;
    }


    /**
	 * 获取：场合
	 */

    public void setChangheTypes(Integer changheTypes) {
        this.changheTypes = changheTypes;
    }
    /**
	 * 设置：身材
	 */
    public Integer getShencaiTypes() {
        return shencaiTypes;
    }


    /**
	 * 获取：身材
	 */

    public void setShencaiTypes(Integer shencaiTypes) {
        this.shencaiTypes = shencaiTypes;
    }
    /**
	 * 设置：穿搭库存
	 */
    public Integer getChuandaKucunNumber() {
        return chuandaKucunNumber;
    }


    /**
	 * 获取：穿搭库存
	 */

    public void setChuandaKucunNumber(Integer chuandaKucunNumber) {
        this.chuandaKucunNumber = chuandaKucunNumber;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getChuandaPrice() {
        return chuandaPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setChuandaPrice(Integer chuandaPrice) {
        this.chuandaPrice = chuandaPrice;
    }
    /**
	 * 设置：穿搭原价
	 */
    public Double getChuandaOldMoney() {
        return chuandaOldMoney;
    }


    /**
	 * 获取：穿搭原价
	 */

    public void setChuandaOldMoney(Double chuandaOldMoney) {
        this.chuandaOldMoney = chuandaOldMoney;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getChuandaNewMoney() {
        return chuandaNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setChuandaNewMoney(Double chuandaNewMoney) {
        this.chuandaNewMoney = chuandaNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getChuandaClicknum() {
        return chuandaClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setChuandaClicknum(Integer chuandaClicknum) {
        this.chuandaClicknum = chuandaClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChuandaDelete() {
        return chuandaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChuandaDelete(Integer chuandaDelete) {
        this.chuandaDelete = chuandaDelete;
    }
    /**
	 * 设置：穿搭简介
	 */
    public String getChuandaContent() {
        return chuandaContent;
    }


    /**
	 * 获取：穿搭简介
	 */

    public void setChuandaContent(String chuandaContent) {
        this.chuandaContent = chuandaContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
