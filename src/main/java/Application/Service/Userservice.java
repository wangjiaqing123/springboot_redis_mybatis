package Application.Service;


import Application.Mapper.Usermapper;
import Application.util.JwtUtil;
import Application.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Service
public class Userservice {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public Result register(String username, String password) {
        String query = usermapper.query(username);

        if (query==null){
            usermapper.save(username,password);
            redisTemplate.opsForValue().set(username,password);
            return Result.success();

        }else{
            log.error("用户名存在");
            return Result.register_error();
        }
    }
    public Result login(String username, String password){

        String pwd = redisTemplate.opsForValue().get(username);
        String userId = UUID.randomUUID().toString();
        if (Boolean.FALSE.equals(redisTemplate.hasKey(username))) {
            log.error("用户名不存在");
            return Result.username_error();
        }
        if (!password.equals(pwd)) {
            log.error("密码错误");
            return Result.password_error();
        }
        Map<String,Object> info = new HashMap<>();
        info.put("username",username);
        info.put("password",password);
        String token = JwtUtil.sign(userId, info);
        return Result.success(token,username,password);
    }
}
