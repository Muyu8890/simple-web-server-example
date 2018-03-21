package com.jeecode.user;
import com.github.likeabook.webserver.service.BaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class UserService extends BaseService<User> {
    @Resource
    private UserMapper mapper;
}
