package cn.meta.controller;

import cn.meta.common.annotion.Log;
import cn.meta.common.enums.OperatorType;
import cn.meta.common.reply.GeneralResult;
import cn.meta.obs.ObsDTO;
import cn.meta.obs.ObsInstance;
import cn.meta.obs.ObsVo;
import com.obs.services.model.PostSignatureResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2021/11/30 0030 11:09
 * @description
 */
@RestController
@RequestMapping("/obs")
public class ObsController {

    private ObsDTO obsDTO;

    @Autowired
    public void setObsDTO(ObsDTO obsDTO) {
        this.obsDTO = obsDTO;
    }

    /**
     * 获取Obs SignedUrl ActualSignedRequestHeaders
     * @return
     */
    @PostMapping("/getObsUrl")
    public GeneralResult getObsUrl(@RequestBody @Validated ObsVo obsVo){
        return GeneralResult.success(ObsInstance.createTemporarySignature(obsVo.getObjectName()));
    }

    @Log(title = "OBS模块",operation = "获取OBS签名",operatorType = OperatorType.MOBILE)
    @PostMapping("/getPostSignature")
    public GeneralResult getPostSignature(){
        PostSignatureResponse result = ObsInstance.createPostSignature();
        obsDTO.setSignature(result.getSignature());
        obsDTO.setPolicy(result.getPolicy());
        obsDTO.setExpiration(result.getExpiration());
        return GeneralResult.success(obsDTO);
    }


}
