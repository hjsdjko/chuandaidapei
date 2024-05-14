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
 * 穿搭讲堂
 *
 * @author 
 * @email
 */
@TableName("chuandajiangtang")
public class ChuandajiangtangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuandajiangtangEntity() {

	}

	public ChuandajiangtangEntity(T t) {
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
     * 讲堂名称
     */
    @TableField(value = "chuandajiangtang_name")

    private String chuandajiangtangName;


    /**
     * 讲堂照片
     */
    @TableField(value = "chuandajiangtang_photo")

    private String chuandajiangtangPhoto;


    /**
     * 讲堂视频
     */
    @TableField(value = "chuandajiangtang_video")

    private String chuandajiangtangVideo;


    /**
     * 讲堂类型
     */
    @TableField(value = "chuandajiangtang_types")

    private Integer chuandajiangtangTypes;


    /**
     * 点击次数
     */
    @TableField(value = "chuandajiangtang_clicknum")

    private Integer chuandajiangtangClicknum;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "chuandajiangtang_delete")

    private Integer chuandajiangtangDelete;


    /**
     * 讲堂详情
     */
    @TableField(value = "chuandajiangtang_content")

    private String chuandajiangtangContent;


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
	 * 设置：讲堂名称
	 */
    public String getChuandajiangtangName() {
        return chuandajiangtangName;
    }


    /**
	 * 获取：讲堂名称
	 */

    public void setChuandajiangtangName(String chuandajiangtangName) {
        this.chuandajiangtangName = chuandajiangtangName;
    }
    /**
	 * 设置：讲堂照片
	 */
    public String getChuandajiangtangPhoto() {
        return chuandajiangtangPhoto;
    }


    /**
	 * 获取：讲堂照片
	 */

    public void setChuandajiangtangPhoto(String chuandajiangtangPhoto) {
        this.chuandajiangtangPhoto = chuandajiangtangPhoto;
    }
    /**
	 * 设置：讲堂视频
	 */
    public String getChuandajiangtangVideo() {
        return chuandajiangtangVideo;
    }


    /**
	 * 获取：讲堂视频
	 */

    public void setChuandajiangtangVideo(String chuandajiangtangVideo) {
        this.chuandajiangtangVideo = chuandajiangtangVideo;
    }
    /**
	 * 设置：讲堂类型
	 */
    public Integer getChuandajiangtangTypes() {
        return chuandajiangtangTypes;
    }


    /**
	 * 获取：讲堂类型
	 */

    public void setChuandajiangtangTypes(Integer chuandajiangtangTypes) {
        this.chuandajiangtangTypes = chuandajiangtangTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getChuandajiangtangClicknum() {
        return chuandajiangtangClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setChuandajiangtangClicknum(Integer chuandajiangtangClicknum) {
        this.chuandajiangtangClicknum = chuandajiangtangClicknum;
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
    public Integer getChuandajiangtangDelete() {
        return chuandajiangtangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChuandajiangtangDelete(Integer chuandajiangtangDelete) {
        this.chuandajiangtangDelete = chuandajiangtangDelete;
    }
    /**
	 * 设置：讲堂详情
	 */
    public String getChuandajiangtangContent() {
        return chuandajiangtangContent;
    }


    /**
	 * 获取：讲堂详情
	 */

    public void setChuandajiangtangContent(String chuandajiangtangContent) {
        this.chuandajiangtangContent = chuandajiangtangContent;
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
        return "Chuandajiangtang{" +
            "id=" + id +
            ", chuandajiangtangName=" + chuandajiangtangName +
            ", chuandajiangtangPhoto=" + chuandajiangtangPhoto +
            ", chuandajiangtangVideo=" + chuandajiangtangVideo +
            ", chuandajiangtangTypes=" + chuandajiangtangTypes +
            ", chuandajiangtangClicknum=" + chuandajiangtangClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", chuandajiangtangDelete=" + chuandajiangtangDelete +
            ", chuandajiangtangContent=" + chuandajiangtangContent +
            ", createTime=" + createTime +
        "}";
    }
}
