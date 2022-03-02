package cn.meta.VO;

import cn.meta.entity.BlockMaster;
import cn.meta.validationGroup.InsertListGroup;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author YangXw
 * @date 2021/12/31 9:57
 */
@Data
public class BlockMasterVO extends BlockMaster {


    @Size(min = 1,message = "blockMaster : 不能为null值", groups = {InsertListGroup.class})
    @NotNull(message = "blockMasterList : 不能为null值", groups = {InsertListGroup.class})
    private List<BlockMaster> blockMasterList;
}
