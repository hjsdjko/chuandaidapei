package com.entity.model;

import com.entity.ChuandajiangtangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 穿搭讲堂
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuandajiangtangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 点击次数
     */
    private Integer chuandajiangtangClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer chuandajiangtangDelete;


    /**
     * 讲堂详情
     */
    private String chuandajiangtangContent;


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
	 * 获取：讲堂名称
	 */
    public String getChuandajiangtangName() {
        return chuandajiangtangName;
    }


    /**
	 * 设置：讲堂名称
	 */
    public void setChuandajiangtangName(String chuandajiangtangName) {
        this.chuandajiangtangName = chuandajiangtangName;
    }
    /**
	 * 获取：讲堂照片
	 */
    public String getChuandajiangtangPhoto() {
        return chuandajiangtangPhoto;
    }


    /**
	 * 设置：讲堂照片
	 */
    public void setChuandajiangtangPhoto(String chuandajiangtangPhoto) {
        this.chuandajiangtangPhoto = chuandajiangtangPhoto;
    }
    /**
	 * 获取：讲堂视频
	 */
    public String getChuandajiangtangVideo() {
        return chuandajiangtangVideo;
    }


    /**
	 * 设置：讲堂视频
	 */
    public void setChuandajiangtangVideo(String chuandajiangtangVideo) {
        this.chuandajiangtangVideo = chuandajiangtangVideo;
    }
    /**
	 * 获取：讲堂类型
	 */
    public Integer getChuandajiangtangTypes() {
        return chuandajiangtangTypes;
    }


    /**
	 * 设置：讲堂类型
	 */
    public void setChuandajiangtangTypes(Integer chuandajiangtangTypes) {
        this.chuandajiangtangTypes = chuandajiangtangTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getChuandajiangtangClicknum() {
        return chuandajiangtangClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setChuandajiangtangClicknum(Integer chuandajiangtangClicknum) {
        this.chuandajiangtangClicknum = chuandajiangtangClicknum;
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
    public Integer getChuandajiangtangDelete() {
        return chuandajiangtangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setChuandajiangtangDelete(Integer chuandajiangtangDelete) {
        this.chuandajiangtangDelete = chuandajiangtangDelete;
    }
    /**
	 * 获取：讲堂详情
	 */
    public String getChuandajiangtangContent() {
        return chuandajiangtangContent;
    }


    /**
	 * 设置：讲堂详情
	 */
    public void setChuandajiangtangContent(String chuandajiangtangContent) {
        this.chuandajiangtangContent = chuandajiangtangContent;
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
