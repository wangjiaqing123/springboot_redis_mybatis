package Application.Controller;

import Application.Service.Userservice;
import Application.user.user;
import Application.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/query-user-info")

public class Controller{
    @Autowired
    private Userservice userservice;
    @PostMapping("/register")
    public Result save(@RequestBody user us) {
        return userservice.register(us.getUsername(),us.getPassword());
    }
    @RequestMapping("/login")
    public Result redis(@RequestBody user us) {
        return userservice.login(us.getUsername(),us.getPassword());
    }
}
