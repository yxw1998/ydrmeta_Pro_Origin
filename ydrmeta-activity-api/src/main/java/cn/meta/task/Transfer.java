package cn.meta.task;

import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.ShortApply;
import cn.meta.entity.UserApplyBatch;
import cn.meta.entity.UserApplyInfo;
import cn.meta.mapper.ShortApplyMapper;
import cn.meta.mapper.UserApplyBatchMapper;
import cn.meta.mapper.UserApplyInfoMapper;
import cn.meta.util.NewSnowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXw
 * @date 2022/02/07 13:44
 */
@RestController("/task")
public class Transfer {

    private ShortApplyMapper shortApplyMapper;

    private UserApplyInfoMapper userApplyInfoMapper;

    private UserApplyBatchMapper userApplyBatchMapper;

    @Autowired
    public void setUserApplyBatchMapper(UserApplyBatchMapper userApplyBatchMapper) {
        this.userApplyBatchMapper = userApplyBatchMapper;
    }

    @Autowired
    public void setUserApplyInfoMapper(UserApplyInfoMapper userApplyInfoMapper) {
        this.userApplyInfoMapper = userApplyInfoMapper;
    }

    @Autowired
    public void setShortApplyMapper(ShortApplyMapper shortApplyMapper) {
        this.shortApplyMapper = shortApplyMapper;
    }

    @RequestMapping("/transferTask")
    public GeneralResult transferTask() {
        List<ShortApply> shortApplies = shortApplyMapper.selAll();
        List<UserApplyInfo> transferList = new ArrayList<>();
        String activityCode = "211578858872426496";
        shortApplies.forEach(data -> {
            String userCode = data.getUserCode();
            UserApplyInfo u1 = new UserApplyInfo();
            UserApplyInfo u2 = new UserApplyInfo();
            UserApplyInfo u3 = new UserApplyInfo();
            UserApplyInfo u4 = new UserApplyInfo();

            u1.setUserCode(userCode);
            u1.setActivityApplyCode(activityCode);
            u1.setBatchCode(data.getShortApplyCode());
            u1.setTemplateCode("211573166149128192");
            u1.setBlockCode("211573166719553540");
            u1.setBlockContent(data.getCompanyName());
            u1.setCreaterCode(userCode);

            u2.setUserCode(userCode);
            u2.setActivityApplyCode(activityCode);
            u2.setBatchCode(data.getShortApplyCode());
            u2.setTemplateCode("211573166149128192");
            u2.setBlockCode("211573166719553538");
            u2.setBlockContent(data.getName());
            u2.setCreaterCode(userCode);

            u3.setUserCode(userCode);
            u3.setActivityApplyCode(activityCode);
            u3.setBatchCode(data.getShortApplyCode());
            u3.setTemplateCode("211573166149128192");
            u3.setBlockCode("211573166719553539");
            u3.setBlockContent(data.getPhone());
            u3.setCreaterCode(userCode);
//            ----3----phone----

            u4.setUserCode(userCode);
            u4.setActivityApplyCode(activityCode);
            u4.setBatchCode(data.getShortApplyCode());
            u4.setTemplateCode("211573166149128192");
            u4.setBlockCode("211573166719553541");
            u4.setBlockContent(data.getCompanyAddress());
            u4.setCreaterCode(userCode);

            transferList.add(u1);
            transferList.add(u2);
            transferList.add(u3);
            transferList.add(u4);

        });

        userApplyInfoMapper.insertList(transferList);
        return GeneralResult.success();
    }

    @RequestMapping("/transferTaskBatch")
    public GeneralResult transferTaskBatch() {
        List<ShortApply> shortApplies = shortApplyMapper.selAll();
        List<UserApplyBatch> userApplyBatchList = new ArrayList<>();

        shortApplies.forEach(data -> {
            UserApplyBatch userApplyBatch = new UserApplyBatch();
            userApplyBatch.setUserCode(data.getUserCode());
            userApplyBatch.setBatchCode(data.getShortApplyCode());
            userApplyBatch.setCreaterCode(data.getUserCode());
            userApplyBatch.setActivityApplyCode("211578858872426496");
            userApplyBatchList.add(userApplyBatch);
        });

        userApplyBatchMapper.insertList(userApplyBatchList);

        return GeneralResult.success();
    }
}
