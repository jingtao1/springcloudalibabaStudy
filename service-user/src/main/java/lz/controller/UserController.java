package lz.controller;

import lz.entity.User;
import lz.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope //nacos 热刷新获取当前配置文件中的值
public class UserController {

    @Resource
    UserService service;

    @Value("${test.cc}")
    String cc;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        System.out.println(cc);
        System.out.println("我调用了User服务");
        return service.getUserById(uid);
    }
}
