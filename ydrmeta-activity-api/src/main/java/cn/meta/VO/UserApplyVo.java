package cn.meta.VO;

import cn.meta.entity.UserApplyInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/01/05 13:46
 */
@Data
public class UserApplyVo {

    private List<UserApplyInfo> userApplyInfoList;

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
     * 条数
     */
    private Integer pageSize;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 是否分页 0不分页 1分页
     */
    private Integer pagination;

}
