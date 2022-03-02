package cn.meta.entity;

import cn.meta.validationGroup.InsertGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * block_master
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class BlockMaster implements Serializable {
    private Long id;

    /**
     * 所属模板编号
     */
    @NotBlank(message = "templateCode(所属模板编号) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    @Length(min = 1,max = 25,message = "blockName : 必须为1~25个字符!",groups = InsertGroup.class)
    private String templateCode;

    /**
     * 模块编号
     */
    private String blockCode;

    /**
     * 模块名称
     */
    @NotBlank(message = "blockName(模块名称) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    @Length(min = 1,max = 12,message = "blockName(模块名称) : 必须为1~12个字符!",groups = InsertGroup.class)
    private String blockName;

    /**
     * 模块类型
     */
    @NotNull(message = "blockType(模块类型) : 不能为null值,必须根据标签类型传递值!",groups = InsertGroup.class)
    private Integer blockType;

    /**
     * 模块约束条件
     */
    private String blockConstraint;

    /**
     * 所属折叠模块编号
     */
    @NotBlank(message = "parentCode(所属折叠模块编号) : 不能为null值且不能为空字符，若无则传递0值!",groups = InsertGroup.class)
    private String parentCode;

    /**
     * 排序等级
     */
    @NotNull(message = "sort(排序等级) : 不能为null值!",groups = InsertGroup.class)
    private Integer sort;

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