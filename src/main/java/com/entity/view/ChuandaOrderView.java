package com.entity.view;

import com.entity.ChuandaOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 穿搭订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuanda_order")
public class ChuandaOrderView extends ChuandaOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单类型的值
		*/
		private String chuandaOrderValue;
		/**
		* 支付类型的值
		*/
		private String chuandaOrderPaymentValue;



		//级联表 address
			/**
			* 收货地址 的 创建用户
			*/
			private Integer addressYonghuId;
			/**
			* 收货人
			*/
			private String addressName;
			/**
			* 电话
			*/
			private String addressPhone;
			/**
			* 地址
			*/
			private String addressDizhi;
			/**
			* 是否默认地址
			*/
			private Integer isdefaultTypes;
				/**
				* 是否默认地址的值
				*/
				private String isdefaultValue;

		//级联表 chuanda
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
				* 穿搭类型的值
				*/
				private String chuandaValue;
			/**
			* 风格
			*/
			private Integer fenggeTypes;
				/**
				* 风格的值
				*/
				private String fenggeValue;
			/**
			* 场合
			*/
			private Integer changheTypes;
				/**
				* 场合的值
				*/
				private String changheValue;
			/**
			* 身材
			*/
			private Integer shencaiTypes;
				/**
				* 身材的值
				*/
				private String shencaiValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer chuandaDelete;
			/**
			* 穿搭简介
			*/
			private String chuandaContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public ChuandaOrderView() {

	}

	public ChuandaOrderView(ChuandaOrderEntity chuandaOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chuandaOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单类型的值
			*/
			public String getChuandaOrderValue() {
				return chuandaOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setChuandaOrderValue(String chuandaOrderValue) {
				this.chuandaOrderValue = chuandaOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getChuandaOrderPaymentValue() {
				return chuandaOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setChuandaOrderPaymentValue(String chuandaOrderPaymentValue) {
				this.chuandaOrderPaymentValue = chuandaOrderPaymentValue;
			}




				//级联表的get和set address
					/**
					* 获取：收货地址 的 创建用户
					*/
					public Integer getAddressYonghuId() {
						return addressYonghuId;
					}
					/**
					* 设置：收货地址 的 创建用户
					*/
					public void setAddressYonghuId(Integer addressYonghuId) {
						this.addressYonghuId = addressYonghuId;
					}

					/**
					* 获取： 收货人
					*/
					public String getAddressName() {
						return addressName;
					}
					/**
					* 设置： 收货人
					*/
					public void setAddressName(String addressName) {
						this.addressName = addressName;
					}
					/**
					* 获取： 电话
					*/
					public String getAddressPhone() {
						return addressPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setAddressPhone(String addressPhone) {
						this.addressPhone = addressPhone;
					}
					/**
					* 获取： 地址
					*/
					public String getAddressDizhi() {
						return addressDizhi;
					}
					/**
					* 设置： 地址
					*/
					public void setAddressDizhi(String addressDizhi) {
						this.addressDizhi = addressDizhi;
					}
					/**
					* 获取： 是否默认地址
					*/
					public Integer getIsdefaultTypes() {
						return isdefaultTypes;
					}
					/**
					* 设置： 是否默认地址
					*/
					public void setIsdefaultTypes(Integer isdefaultTypes) {
						this.isdefaultTypes = isdefaultTypes;
					}


						/**
						* 获取： 是否默认地址的值
						*/
						public String getIsdefaultValue() {
							return isdefaultValue;
						}
						/**
						* 设置： 是否默认地址的值
						*/
						public void setIsdefaultValue(String isdefaultValue) {
							this.isdefaultValue = isdefaultValue;
						}









				//级联表的get和set chuanda
					/**
					* 获取： 穿搭名称
					*/
					public String getChuandaName() {
						return chuandaName;
					}
					/**
					* 设置： 穿搭名称
					*/
					public void setChuandaName(String chuandaName) {
						this.chuandaName = chuandaName;
					}
					/**
					* 获取： 照片
					*/
					public String getChuandaPhoto() {
						return chuandaPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setChuandaPhoto(String chuandaPhoto) {
						this.chuandaPhoto = chuandaPhoto;
					}
					/**
					* 获取： 穿搭类型
					*/
					public Integer getChuandaTypes() {
						return chuandaTypes;
					}
					/**
					* 设置： 穿搭类型
					*/
					public void setChuandaTypes(Integer chuandaTypes) {
						this.chuandaTypes = chuandaTypes;
					}


						/**
						* 获取： 穿搭类型的值
						*/
						public String getChuandaValue() {
							return chuandaValue;
						}
						/**
						* 设置： 穿搭类型的值
						*/
						public void setChuandaValue(String chuandaValue) {
							this.chuandaValue = chuandaValue;
						}
					/**
					* 获取： 风格
					*/
					public Integer getFenggeTypes() {
						return fenggeTypes;
					}
					/**
					* 设置： 风格
					*/
					public void setFenggeTypes(Integer fenggeTypes) {
						this.fenggeTypes = fenggeTypes;
					}


						/**
						* 获取： 风格的值
						*/
						public String getFenggeValue() {
							return fenggeValue;
						}
						/**
						* 设置： 风格的值
						*/
						public void setFenggeValue(String fenggeValue) {
							this.fenggeValue = fenggeValue;
						}
					/**
					* 获取： 场合
					*/
					public Integer getChangheTypes() {
						return changheTypes;
					}
					/**
					* 设置： 场合
					*/
					public void setChangheTypes(Integer changheTypes) {
						this.changheTypes = changheTypes;
					}


						/**
						* 获取： 场合的值
						*/
						public String getChangheValue() {
							return changheValue;
						}
						/**
						* 设置： 场合的值
						*/
						public void setChangheValue(String changheValue) {
							this.changheValue = changheValue;
						}
					/**
					* 获取： 身材
					*/
					public Integer getShencaiTypes() {
						return shencaiTypes;
					}
					/**
					* 设置： 身材
					*/
					public void setShencaiTypes(Integer shencaiTypes) {
						this.shencaiTypes = shencaiTypes;
					}


						/**
						* 获取： 身材的值
						*/
						public String getShencaiValue() {
							return shencaiValue;
						}
						/**
						* 设置： 身材的值
						*/
						public void setShencaiValue(String shencaiValue) {
							this.shencaiValue = shencaiValue;
						}
					/**
					* 获取： 穿搭库存
					*/
					public Integer getChuandaKucunNumber() {
						return chuandaKucunNumber;
					}
					/**
					* 设置： 穿搭库存
					*/
					public void setChuandaKucunNumber(Integer chuandaKucunNumber) {
						this.chuandaKucunNumber = chuandaKucunNumber;
					}
					/**
					* 获取： 购买获得积分
					*/
					public Integer getChuandaPrice() {
						return chuandaPrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setChuandaPrice(Integer chuandaPrice) {
						this.chuandaPrice = chuandaPrice;
					}
					/**
					* 获取： 穿搭原价
					*/
					public Double getChuandaOldMoney() {
						return chuandaOldMoney;
					}
					/**
					* 设置： 穿搭原价
					*/
					public void setChuandaOldMoney(Double chuandaOldMoney) {
						this.chuandaOldMoney = chuandaOldMoney;
					}
					/**
					* 获取： 现价/积分
					*/
					public Double getChuandaNewMoney() {
						return chuandaNewMoney;
					}
					/**
					* 设置： 现价/积分
					*/
					public void setChuandaNewMoney(Double chuandaNewMoney) {
						this.chuandaNewMoney = chuandaNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getChuandaClicknum() {
						return chuandaClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setChuandaClicknum(Integer chuandaClicknum) {
						this.chuandaClicknum = chuandaClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getChuandaDelete() {
						return chuandaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setChuandaDelete(Integer chuandaDelete) {
						this.chuandaDelete = chuandaDelete;
					}
					/**
					* 获取： 穿搭简介
					*/
					public String getChuandaContent() {
						return chuandaContent;
					}
					/**
					* 设置： 穿搭简介
					*/
					public void setChuandaContent(String chuandaContent) {
						this.chuandaContent = chuandaContent;
					}





































				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}
					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}
					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}




}
