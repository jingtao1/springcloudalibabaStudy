package lz.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lz.entity.User;
import lz.mapper.UserMapper;
import lz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    @SentinelResource("getUser")
    //监控此方法，无论被谁执行都在监控范围内，这里给的value是自定义名称，这个注解可以加在任何方法上，包括Controller中的请求映射方法，跟HystrixCommand贼像
    public User getUserById(int uid) {
        return mapper.getUserById(uid);
    }
}
