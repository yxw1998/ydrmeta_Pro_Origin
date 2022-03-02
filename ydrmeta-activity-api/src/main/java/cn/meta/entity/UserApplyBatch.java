package cn.meta.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_apply_batch
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class UserApplyBatch implements Serializable {
    private Long id;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 批次编号
     */
    private String batchCode;

    /**
     * 报名活动编号
     */
    private String activityApplyCode;

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