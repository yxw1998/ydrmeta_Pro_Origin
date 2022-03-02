package cn.meta.entity;

import cn.meta.validationGroup.InsertGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * activity_work
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class ActivityWork implements Serializable {
    private Long id;

    /**
     * 业务活动编号
     */
    private String activityWorkCode;

    /**
     * 业务活动标题
     */
    @NotBlank(message = "activityWorkTitle(业务活动标题) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    @Length(min = 1,max = 50,message = "activityWorkTitle : 必须为1~50个字符!",groups = InsertGroup.class)
    private String activityWorkTitle;

    /**
     * 业务活动标题
     */
    @NotBlank(message = "activityWordInfo(业务活动简介) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    @Length(min = 1,max = 250,message = "activityWordInfo : 必须为1~250个字符!",groups = InsertGroup.class)
    private String activityWordInfo;

    /**
     * 所用模板编号
     */
    private String templateCode;

    /**
     * 是否可报名 0.不可报名 1.可报名
     */
    @NotNull(message = "isApply(是否可报名) : 不能为null值,0.不可报名 1.可报,必须选择合适参数上传！",groups = InsertGroup.class)
    private Integer isApply;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否启用 true 启用 false 不启用
     */
    private Boolean enable;

    /**
     * 是否删除 true 未删除 false 已删除
     */
    private Boolean activity;

    /**
     * 创建人编号
     */
    private String createrCode;

    private static final long serialVersionUID = 1L;
}