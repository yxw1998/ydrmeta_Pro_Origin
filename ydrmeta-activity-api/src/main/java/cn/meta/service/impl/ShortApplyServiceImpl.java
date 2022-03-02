package cn.meta.service.impl;

import cn.meta.VO.ShortApplyVo;
import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.ShortApply;
import cn.meta.mapper.ShortApplyMapper;
import cn.meta.mapper.UserMapper;
import cn.meta.service.ShortApplyService;
import cn.meta.util.NewSnowUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YangXw
 * @date 2022/01/04 12:56
 */
@Service
public class ShortApplyServiceImpl implements ShortApplyService {

    private ShortApplyMapper shortApplyMapper;

    private UserMapper userMapper;

    @Autowired
    public void setShortApplyMapper(ShortApplyMapper shortApplyMapper) {
        this.shortApplyMapper = shortApplyMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public GeneralResult insertShortApply(ShortApply record) {
        if (shortApplyMapper.checkRepeat(record) != null) {
            return GeneralResult.repeat();
        }
        record.setShortApplyCode(String.valueOf(NewSnowUtil.getId()));
        shortApplyMapper.insert(record);
        //更新用户报名状态
        userMapper.updateIsApplied(record.getUserCode());
        return GeneralResult.success("");
    }

    @Override
    public GeneralResult selShortApplyByUserCode(ShortApply shortApply) {
        ShortApply data = shortApplyMapper.selShortApplyByUserCode(shortApply);
        if (data == null) {
            return GeneralResult.noExist();
        }
        return GeneralResult.success(data);
    }

    @Override
    public GeneralResult updateShortApply(ShortApply shortApply) {
        ShortApply data = shortApplyMapper.selShortApplyByUserCode(shortApply);
        if (data == null) {
            return GeneralResult.noExist();
        }
        return GeneralResult.success(shortApplyMapper.updateShortApply(shortApply));
    }

    @Override
    public GeneralResult selShortApplyList(ShortApplyVo shortApplyVo) {
        if (shortApplyVo.getPagination() == 1) {
            PageHelper.startPage(shortApplyVo.getPageNum(), shortApplyVo.getPageSize());
        }

        List<ShortApply> resultList = shortApplyMapper.selShortApplyList(shortApplyVo);
        if (resultList.isEmpty()) {
            return GeneralResult.noExist();
        }

        return GeneralResult.success(new PageInfo<>(resultList));
    }
}
