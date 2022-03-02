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
 * template_master
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class TemplateMaster implements Serializable {
    private Long id;

    /**
     * 模板编号
     */
    private String templateCode;

    /**
     * 模板名称
     */
    @NotBlank(message = "templateName(模板名称) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    @Length(min = 1,max = 12,message = "templateName(模块名称) : 必须为1~12个字符!",groups = InsertGroup.class)
    private String templateName;

    /**
     * 模板类型：1. 系统模板 2.自定义模板
     */
    @NotNull(message = "templateType(模板类型) : 不能为null值,1. 系统默认模块 2. 自定义模块，必须选择合适参数上传！",groups = InsertGroup.class)
    private Integer templateType;

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