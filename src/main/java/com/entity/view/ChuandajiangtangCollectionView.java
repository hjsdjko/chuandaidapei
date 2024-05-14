package com.entity.view;

import com.entity.ChuandajiangtangCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 穿搭讲堂收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuandajiangtang_collection")
public class ChuandajiangtangCollectionView extends ChuandajiangtangCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String chuandajiangtangCollectionValue;



		//级联表 chuandajiangtang
			/**
			* 讲堂名称
			*/
			private String chuandajiangtangName;
			/**
			* 讲堂照片
			*/
			private String chuandajiangtangPhoto;
			/**
			* 讲堂视频
			*/
			private String chuandajiangtangVideo;
			/**
			* 讲堂类型
			*/
			private Integer chuandajiangtangTypes;
				/**
				* 讲堂类型的值
				*/
				private String chuandajiangtangValue;
			/**
			* 点击次数
			*/
			private Integer chuandajiangtangClicknum;
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
			private Integer chuandajiangtangDelete;
			/**
			* 讲堂详情
			*/
			private String chuandajiangtangContent;

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

	public ChuandajiangtangCollectionView() {

	}

	public ChuandajiangtangCollectionView(ChuandajiangtangCollectionEntity chuandajiangtangCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, chuandajiangtangCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getChuandajiangtangCollectionValue() {
				return chuandajiangtangCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setChuandajiangtangCollectionValue(String chuandajiangtangCollectionValue) {
				this.chuandajiangtangCollectionValue = chuandajiangtangCollectionValue;
			}






















				//级联表的get和set chuandajiangtang
					/**
					* 获取： 讲堂名称
					*/
					public String getChuandajiangtangName() {
						return chuandajiangtangName;
					}
					/**
					* 设置： 讲堂名称
					*/
					public void setChuandajiangtangName(String chuandajiangtangName) {
						this.chuandajiangtangName = chuandajiangtangName;
					}
					/**
					* 获取： 讲堂照片
					*/
					public String getChuandajiangtangPhoto() {
						return chuandajiangtangPhoto;
					}
					/**
					* 设置： 讲堂照片
					*/
					public void setChuandajiangtangPhoto(String chuandajiangtangPhoto) {
						this.chuandajiangtangPhoto = chuandajiangtangPhoto;
					}
					/**
					* 获取： 讲堂视频
					*/
					public String getChuandajiangtangVideo() {
						return chuandajiangtangVideo;
					}
					/**
					* 设置： 讲堂视频
					*/
					public void setChuandajiangtangVideo(String chuandajiangtangVideo) {
						this.chuandajiangtangVideo = chuandajiangtangVideo;
					}
					/**
					* 获取： 讲堂类型
					*/
					public Integer getChuandajiangtangTypes() {
						return chuandajiangtangTypes;
					}
					/**
					* 设置： 讲堂类型
					*/
					public void setChuandajiangtangTypes(Integer chuandajiangtangTypes) {
						this.chuandajiangtangTypes = chuandajiangtangTypes;
					}


						/**
						* 获取： 讲堂类型的值
						*/
						public String getChuandajiangtangValue() {
							return chuandajiangtangValue;
						}
						/**
						* 设置： 讲堂类型的值
						*/
						public void setChuandajiangtangValue(String chuandajiangtangValue) {
							this.chuandajiangtangValue = chuandajiangtangValue;
						}
					/**
					* 获取： 点击次数
					*/
					public Integer getChuandajiangtangClicknum() {
						return chuandajiangtangClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setChuandajiangtangClicknum(Integer chuandajiangtangClicknum) {
						this.chuandajiangtangClicknum = chuandajiangtangClicknum;
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
					public Integer getChuandajiangtangDelete() {
						return chuandajiangtangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setChuandajiangtangDelete(Integer chuandajiangtangDelete) {
						this.chuandajiangtangDelete = chuandajiangtangDelete;
					}
					/**
					* 获取： 讲堂详情
					*/
					public String getChuandajiangtangContent() {
						return chuandajiangtangContent;
					}
					/**
					* 设置： 讲堂详情
					*/
					public void setChuandajiangtangContent(String chuandajiangtangContent) {
						this.chuandajiangtangContent = chuandajiangtangContent;
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
