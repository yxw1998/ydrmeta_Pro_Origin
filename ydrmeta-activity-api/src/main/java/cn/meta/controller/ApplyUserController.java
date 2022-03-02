package cn.meta.controller;

import cn.meta.VO.UserApplyVo;
import cn.meta.common.reply.GeneralResult;
import cn.meta.service.ApplyUserService;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/05 14:38
 */
@RestController
@RequestMapping("/apply/user")
@Slf4j
public class ApplyUserController {

    private ApplyUserService applyUserService;

    @Autowired
    public void setApplyUserService(ApplyUserService applyUserService) {
        this.applyUserService = applyUserService;
    }

    /**
     * 添加用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/insertUserApplyInfoList",produces = "application/json;charset=utf-8")
    public GeneralResult insertUserApplyInfoList(@RequestBody UserApplyVo userApplyVo,
                                                 String userSessCode, String comSessCode){
        log.info("添加用户详情信息列表 : " +userApplyVo.getUserApplyInfoList());
        return applyUserService.insertUserApplyInfoList(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 查询用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selUserApplyInfoList",produces = "application/json;charset=utf-8")
    public GeneralResult selUserApplyInfoList(@RequestBody UserApplyVo userApplyVo,
                                                 String userSessCode, String comSessCode){
        log.info("查询用户报名详情信息列表 : " +userApplyVo);
        return applyUserService.selUserApplyInfoList(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 修改用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/updateUserApplyInfoList",produces = "application/json;charset=utf-8")
    public GeneralResult updateUserApplyInfoList(@RequestBody UserApplyVo userApplyVo,
                                              String userSessCode, String comSessCode){
        log.info("修改用户报名详情信息列表 : " +userApplyVo.getUserApplyInfoList());
        return applyUserService.updateUserApplyInfoList(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 扩展用户报名详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/addUserApplyInfoList",produces = "application/json;charset=utf-8")
    public GeneralResult addUserApplyInfoList(@RequestBody UserApplyVo userApplyVo,
                                                 String userSessCode, String comSessCode){
        log.info("扩展用户报名详情信息列表 : " +userApplyVo.getUserApplyInfoList());
        return applyUserService.addUserApplyInfoList(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 查询用户报名详情信息列表[通过活动编号][PC]
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selUserApplyInfoListByApplyCode",produces = "application/json;charset=utf-8")
    public GeneralResult selUserApplyInfoListByApplyCode(@RequestBody UserApplyVo userApplyVo,
                                              String userSessCode, String comSessCode){
        log.info("查询用户报名详情信息列表[通过活动编号][PC] : " +userApplyVo);
        return applyUserService.selUserApplyInfoListByApplyCode(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 查询用户报名批次详情信息列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selUserBatchInfoList",produces = "application/json;charset=utf-8")
    public GeneralResult selUserBatchInfoList(@RequestBody UserApplyVo userApplyVo,
                                                         String userSessCode, String comSessCode){
        log.info("查询用户报名批次详情信息列表 : " +userApplyVo);
        return applyUserService.selUserBatchInfoList(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 查询用户报名批次详情信息[姓名、电话]
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selUserApplyInfoByNamePhone",produces = "application/json;charset=utf-8")
    public GeneralResult selUserApplyInfoByNamePhone(@RequestBody UserApplyVo userApplyVo,
                                              String userSessCode, String comSessCode){
        log.info("查询用户报名批次详情信息[姓名、电话][PC] : " +userApplyVo);
        return applyUserService.selUserApplyInfoByNamePhone(userApplyVo,userSessCode,comSessCode);
    }

    /**
     * 查询活动可查询条件列表
     * @param userApplyVo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selActivityQueryList",produces = "application/json;charset=utf-8")
    public GeneralResult selActivityQueryList(@RequestBody UserApplyVo userApplyVo,
                                                     String userSessCode, String comSessCode){
        log.info("查询活动可查询条件列表 : " +userApplyVo);
        return applyUserService.selActivityQueryList(userApplyVo,userSessCode,comSessCode);
    }
}
