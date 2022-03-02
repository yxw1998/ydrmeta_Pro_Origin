package cn.meta.VO;

import cn.meta.validationGroup.SelectListGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author YangXw
 * @date 2022/01/06 15:36
 */
@Data
public class ShortApplyVo {

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNum;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageSize;

    @NotNull(message = "pagination(是否分页) : 不能为null值! 0.不分页 1.分页!", groups = {SelectListGroup.class})
    private Integer pagination;
}
