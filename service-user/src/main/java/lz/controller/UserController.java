package lz.controller;

import com.alibaba.fastjson.JSONObject;
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


    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        System.out.println("我调用了User1服务");
        return service.getUserById(uid);
    }

    //测试当前Sentinel 链路模式 对当前service方法进行监控而不是针对接口
    @RequestMapping("/user2/{uid}")
    public User findUserById2(@PathVariable("uid") int uid){
        System.out.println("我调用了User2服务");
        return service.getUserById(uid);
    }

    @RequestMapping("/blocked")
    JSONObject blocked(){
        JSONObject object = new JSONObject();
        object.put("code", 403);
        object.put("success", false);
        object.put("massage", "您的请求频率过快，请稍后再试！");
        return object;
    }
}
