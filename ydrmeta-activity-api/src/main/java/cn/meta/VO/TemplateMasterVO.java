package cn.meta.VO;

import cn.meta.entity.TemplateMaster;
import cn.meta.validationGroup.SelectListGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/31 13:36
 */
@Data
public class TemplateMasterVO extends TemplateMaster {

    @NotNull(message = "templateCodeList : 不能为null值", groups = {SelectListGroup.class})
    private List<String> templateCodeList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNum;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageSize;

    @NotNull(message = "pagination(是否分页) : 不能为null值! 0.不分页 1.分页!", groups = {SelectListGroup.class})
    private Integer pagination;


}
