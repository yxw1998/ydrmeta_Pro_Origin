package cn.meta.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * block_master_activity
 * @author 
 */
@Data
@JsonIgnoreProperties({"id","addTime","updateTime","enable","activity","createrCode"})
public class BlockMasterActivity extends BlockMaster implements Serializable {

    /**
     * 报名活动编号
     */
    private String activityApplyCode;

    private static final long serialVersionUID = 1L;
}