package cn.meta.entity;

import cn.meta.validationGroup.InsertGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * user
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class UserInfo implements Serializable {
    private Long id;

    /**
     * 用户编号（雪花、唯一）
     */
    private String userCode;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码（MD5）
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 性别 0 女 1 男
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否已报名 0 未报名 1 已报名
     */
    private Integer isApplied;

    /**
     * 微信名称
     */
    private String wxName;

    /**
     * 公众号OPENID
     */
    private String pubOpenId;

    /**
     * 小程序OPENID
     */
    @NotBlank(message = "miniOpenId(小程序OPENID) : 不能为null值且不能为空字符!",groups = InsertGroup.class)
    private String miniOpenId;

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