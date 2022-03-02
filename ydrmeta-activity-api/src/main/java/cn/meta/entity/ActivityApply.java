package cn.meta.entity;

import cn.meta.validationGroup.InsertGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * avtivity_apply
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class ActivityApply implements Serializable {
    private Long id;


    /**
     * 所属业务活动编号
     */
    @NotBlank(message = "activityWorkCode(所属业务活动编号) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String activityWorkCode;


    private String activityApplyCode;

    /**
     * 所用模板编号
     */
    @NotBlank(message = "templateCode(模板编号) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String templateCode;

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