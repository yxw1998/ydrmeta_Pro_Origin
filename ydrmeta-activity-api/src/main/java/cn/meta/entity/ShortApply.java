package cn.meta.entity;

import cn.meta.validationGroup.InsertGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * short_apply
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class ShortApply implements Serializable {
    private Long id;

    /**
     * 报名人编号
     */
    @NotBlank(message = "userCode(报名人编号) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String userCode;

    /**
     * 临时报名编号
     */
    private String shortApplyCode;

    /**
     * 公司名称
     */
    @NotBlank(message = "companyName(公司名称) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String companyName;

    /**
     * 姓名
     */
    @NotBlank(message = "name(姓名) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String name;

    /**
     * 联系电话
     */
    @NotBlank(message = "phone(联系电话) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String phone;

    /**
     * 公司地址
     */
    private String companyAddress;

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