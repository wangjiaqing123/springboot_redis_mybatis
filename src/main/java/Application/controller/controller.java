package Application.controller;


import Application.service.Current_limiting;
import Application.service.limiting;
import Application.service.userservice;
import Application.user.user;
import Application.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web")
public class controller {

    @Autowired
    private limiting limiting;
    @Autowired
    private userservice userservice;

    @Autowired(required = false)
    //这是必须加required = false不然会报错原因不知道
    private StringRedisTemplate redisTemplate;


    @PostMapping("/register")
    public Result save(@RequestBody user us) {
        String username = us.getUsername();
        String password = us.getPassword();
        if(username==null){
            return Result.user_null_error();
        }
        if(password==null){
            return Result.user_null_error();
        }
        try {
            redisTemplate.opsForValue().set(username,password);
            userservice.save(us);
            return Result.success();
        } catch (Exception e) {
            //如果这里一直错误检查是不是redis没有打开
            return Result.register_error();
        }

    }

    @RequestMapping("/login")
    public Result redis(@RequestBody user us) {
        String username = us.getUsername();
        String password = us.getPassword();
        if(username==null){
            return Result.user_null_error();
        }
        if(password==null){
            return Result.user_null_error();
        }
        redisTemplate.hasKey(username);
        //redis插入
        try {
            String pwd = redisTemplate.opsForValue().get(username);
            if (redisTemplate.hasKey(username) == false) {
                return Result.username_error();
            }
            if (pwd.equals(password)) {
                return limiting.Current_limiting();
            } else {
                return Result.password_error();
            }
        } catch (Exception e) {
            return Result.unknow_error();


        }
    }




}
