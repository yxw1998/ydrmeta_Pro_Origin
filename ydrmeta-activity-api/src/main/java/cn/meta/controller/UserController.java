package cn.meta.controller;

import cn.meta.common.reply.GeneralResult;
import cn.meta.entity.UserInfo;
import cn.meta.service.UserService;
import cn.meta.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/04 12:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 小程序注册
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/miniRegister",produces = "application/json;charset=utf-8")
    public GeneralResult miniRegister(@RequestBody @Validated({InsertGroup.class}) UserInfo userInfo, String userSessCode, String comSessCode){
        return userService.miniRegister(userInfo);
    }

    /**
     * 通过小程序OPENID查询用户信息
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selUserByMiniOpenId",produces = "application/json;charset=utf-8")
    public GeneralResult selUserByMiniOpenId(@RequestBody UserInfo userInfo, String userSessCode, String comSessCode){
        return userService.selUserByMiniOpenId(userInfo);
    }


    /**
     * 通过小程序手机号查询用户信息
     * @param userInfo
     * @param userSessCode
     * @param comSessCode
     * @return
     */
    @PostMapping(value = "/selUserByPhone",produces = "application/json;charset=utf-8")
    public GeneralResult selUserByPhone(@RequestBody UserInfo userInfo, String userSessCode, String comSessCode){
        return userService.selUserByPhone(userInfo);
    }

}
