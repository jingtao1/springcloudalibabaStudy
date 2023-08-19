package lz.service;

import lz.entity.Book;
import lz.entity.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("bookservice")
public interface BookClient {

    @LoadBalanced //默认采用轮询 负载均衡方式
    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid);
}
