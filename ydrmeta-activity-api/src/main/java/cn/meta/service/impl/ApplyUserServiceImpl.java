package cn.meta.service.impl;

import cn.meta.VO.UserApplyVo;
import cn.meta.common.reply.GeneralResult;
import cn.meta.config.GlobalException;
import cn.meta.entity.ActivityQuery;
import cn.meta.entity.UserApplyBatch;
import cn.meta.entity.UserApplyInfo;
import cn.meta.mapper.ActivityQueryMapper;
import cn.meta.mapper.UserApplyBatchMapper;
import cn.meta.mapper.UserApplyInfoMapper;
import cn.meta.mapper.UserMapper;
import cn.meta.service.ApplyUserService;
import cn.meta.util.NewSnowUtil;
import cn.meta.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author YangXw
 * @date 2022/01/05 14:15
 */
@Service
public class ApplyUserServiceImpl implements ApplyUserService {

    private UserApplyInfoMapper userApplyInfoMapper;

    private UserApplyBatchMapper userApplyBatchMapper;

    private ActivityQueryMapper activityQueryMapper;

    private UserMapper userMapper;

    @Autowired
    public void setActivityQueryMapper(ActivityQueryMapper activityQueryMapper) {
        this.activityQueryMapper = activityQueryMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserApplyInfoMapper(UserApplyInfoMapper userApplyInfoMapper) {
        this.userApplyInfoMapper = userApplyInfoMapper;
    }

    @Autowired
    public void setUserApplyBatchMapper(UserApplyBatchMapper userApplyBatchMapper) {
        this.userApplyBatchMapper = userApplyBatchMapper;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public GeneralResult insertUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {
        List<UserApplyInfo> userApplyInfoList = userApplyVo.getUserApplyInfoList();
        if (userApplyInfoList.isEmpty()) {
            return GeneralResult.fail("");
        }

        String batchCode = String.valueOf(NewSnowUtil.getId());

        UserApplyBatch userApplyBatch = new UserApplyBatch();
        userApplyBatch.setUserCode(userSessCode);
        userApplyBatch.setActivityApplyCode(userApplyInfoList.get(0).getActivityApplyCode());
        userApplyBatch.setBatchCode(batchCode);
        userApplyBatch.setCreaterCode(userSessCode);

        for (int i = 0; i < userApplyInfoList.size(); i++) {
            userApplyInfoList.get(i).setUserCode(userSessCode);
            userApplyInfoList.get(i).setBatchCode(batchCode);
            userApplyInfoList.get(i).setCreaterCode(userSessCode);
        }

        if (Optional.ofNullable(userApplyBatchMapper.checkRepeat(userApplyBatch)).isPresent()) {
            return GeneralResult.fail(batchCode);
        }
        userApplyBatchMapper.insert(userApplyBatch);
        userApplyInfoMapper.insertList(userApplyInfoList);
        return GeneralResult.success(batchCode);
    }

    @Override
    public GeneralResult selUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {

        List<UserApplyInfo> resultList = userApplyInfoMapper.selUserApplyInfoList(userApplyVo);

        if (resultList.isEmpty()) {
            return GeneralResult.noExist();
        }

        return GeneralResult.success(resultList);
    }

    @Override
    public GeneralResult updateUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {
        List<UserApplyInfo> userApplyInfoList = userApplyVo.getUserApplyInfoList();
        if (userApplyInfoList.isEmpty()) {
            return GeneralResult.fail("");
        }

        userApplyInfoList.forEach(data -> {
            userApplyInfoMapper.updateUserApplyInfo(data);
        });

        return GeneralResult.success();
    }

    @Override
    public GeneralResult addUserApplyInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {
        List<UserApplyInfo> userApplyInfoList = userApplyVo.getUserApplyInfoList();

        if (userApplyInfoList.isEmpty()) {
            return GeneralResult.fail("");
        }

        for (int i = 0; i < userApplyInfoList.size(); i++) {
            if (userApplyInfoMapper.checkRepeat(userApplyInfoList.get(i)) != null) {
                return GeneralResult.repeat();
            }
        }

        return GeneralResult.success(userApplyInfoMapper.insertList(userApplyInfoList));
    }

    @Override
    public GeneralResult selUserApplyInfoListByApplyCode(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {
        if (userApplyVo.getPagination() == 1) {
            PageHelper.startPage(userApplyVo.getPageNum(), userApplyVo.getPageSize());
        }

        List<UserApplyInfo> userApplyInfoList = userApplyInfoMapper.selUserApplyInfoListByApplyCode(userApplyVo.getActivityApplyCode());

        if (userApplyInfoList.isEmpty()) {
            return GeneralResult.noExist();
        }


        return GeneralResult.success(new PageInfo<>(userApplyInfoList));
    }

    @Override
    public GeneralResult selUserBatchInfoList(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {
        List<UserApplyBatch> batchList = userApplyBatchMapper.selUserBatchInfoList(userApplyVo);
        if (batchList.isEmpty()) {
            return GeneralResult.noExist();
        }
        return GeneralResult.success(batchList);
    }

    @Override
    public GeneralResult selUserApplyInfoByNamePhone(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {

        List<UserApplyInfo> recordList = userApplyVo.getUserApplyInfoList();
        int size = recordList.size();

        if (size == 1) {
            return GeneralResult.success(userApplyInfoMapper.selUserApplyInfoByNamePhoneSingle(recordList.get(0)));
        }

        List<UserApplyInfo> intersection = new ArrayList<>();
        List<UserApplyInfo> resultList = new ArrayList<>();

        for (UserApplyInfo data1 : userApplyInfoMapper.selUserApplyInfoByNamePhone(recordList.get(0))) {
            for (UserApplyInfo data2 : userApplyInfoMapper.selUserApplyInfoByNamePhone(recordList.get(1))) {
                if (data1.getBatchCode().equals(data2.getBatchCode())) {
                    intersection.add(data1);
                }
            }
        }

        if (intersection.isEmpty()) {
            return GeneralResult.noExist();
        }

        int flag = 2;
        while (flag < size) {
            if (intersection.isEmpty()) {
                break;
            }

            List<UserApplyInfo> bList = userApplyInfoMapper.selUserApplyInfoByNamePhone(recordList.get(flag));

            boolean b;
            for (int i = 0; i < intersection.size(); i++) {
                b = false;
                UserApplyInfo data1 = intersection.get(i);
                for (int j = 0; j < bList.size(); j++) {
                    UserApplyInfo data2 = bList.get(j);
                    if (data1.getBatchCode().equals(data2.getBatchCode())) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    data1.setUserCode("del");
                }
            }

            for (int i = 0; i < intersection.size(); i++) {
                UserApplyInfo data = intersection.get(i);
                if (data.getUserCode().equals("del")) {
                    intersection.remove(data);
                }
            }

            flag ++;
        }

        intersection.forEach(data -> {
            resultList.addAll(userApplyInfoMapper.selUserApplyInfoListOverLoad(data));
        });

        return GeneralResult.success(resultList);
    }

    @Override
    public GeneralResult selActivityQueryList(UserApplyVo userApplyVo, String userSessCode, String comSessCode) {
        List<ActivityQuery> activityQueryList = activityQueryMapper.selActivityQueryList(userApplyVo);
        if (activityQueryList.isEmpty()) {
            return GeneralResult.noExist();
        }
        return GeneralResult.success(activityQueryList);
    }
}
