package lz.service;

import lz.entity.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("userservice")
public interface UserClient {

    @LoadBalanced //默认采用轮询 负载均衡方式
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid);
}
