package com.entity.view;

import com.entity.ChuandajiangtangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 穿搭讲堂
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuandajiangtang")
public class ChuandajiangtangView extends ChuandajiangtangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 讲堂类型的值
		*/
		private String chuandajiangtangValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public ChuandajiangtangView() {

	}

	public ChuandajiangtangView(ChuandajiangtangEntity chuandajiangtangEntity) {
		try {
			BeanUtils.copyProperties(this, chuandajiangtangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
