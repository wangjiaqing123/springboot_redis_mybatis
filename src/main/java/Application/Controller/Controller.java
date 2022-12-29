package Application.Controller;

import Application.Service.Userservice;
import Application.user.user;
import Application.util.JwtUtil;
import Application.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(tags="用户管理")
@RestController
@RequestMapping("/v1/user/query-user-info")
public class Controller{
    @Autowired
    private Userservice userservice;
    @ApiOperation(value = "用户注册",httpMethod = "POST")
    @PostMapping("/register")
    public Result save(@RequestBody user us) {
        return userservice.register(us.getUsername(),us.getPassword());
    }
    @ApiOperation(value = "用户登入",httpMethod = "GET")
    @RequestMapping("/login")
    public Result redis(@RequestBody user us) {
        return userservice.login(us.getUsername(),us.getPassword());
    }
}
