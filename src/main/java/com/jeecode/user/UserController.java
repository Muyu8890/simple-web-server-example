package com.jeecode.user;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("get")
    public User get(User paramUser){
        return userService.find(paramUser);
    }
}
