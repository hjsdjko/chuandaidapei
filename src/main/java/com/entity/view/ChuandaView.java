package com.entity.view;

import com.entity.ChuandaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 穿搭
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuanda")
public class ChuandaView extends ChuandaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 穿搭类型的值
		*/
		private String chuandaValue;
		/**
		* 风格的值
		*/
		private String fenggeValue;
		/**
		* 场合的值
		*/
		private String changheValue;
		/**
		* 身材的值
		*/
		private String shencaiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public ChuandaView() {

	}

	public ChuandaView(ChuandaEntity chuandaEntity) {
		try {
			BeanUtils.copyProperties(this, chuandaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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















}
