package cn.meta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangXw
 * @date 2022/01/04 16:30
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/getHttp")
    public Object getHttp(){
        return null;
    }
}
