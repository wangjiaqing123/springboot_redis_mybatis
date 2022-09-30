package Application.controller;


import Application.service.userservice;
import Application.user.user;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web")
public class controller {
    @Autowired
    private userservice userservice;

    @Autowired(required = false)
    //这是必须加required = false不然会报错原因不知道
    private StringRedisTemplate redisTemplate;

    @PostMapping("/register")
    public Integer save(@RequestBody user us) {
        String username = us.getUsername();
        String password = us.getPassword();
        System.out.println(username);
        System.out.println(password);
        try {
            //怎么将返回指改为1回来问问
            redisTemplate.opsForValue().set(username,password);
            return userservice.save(us);
        } catch (Exception e) {
            System.out.println("检查是不是redis没有打开");
            System.out.println("添加数据失败");
            return 100001;
        }

    }
    @RequestMapping("/login")
    public Integer redis(@RequestBody user us) {
        String username = us.getUsername();
        String password = us.getPassword();
        redisTemplate.hasKey(username);
        //redis插入
        try {
            String pwd = redisTemplate.opsForValue().get(username);
            System.out.println(pwd);
            if (redisTemplate.hasKey(username) == false) {
                System.out.println("用户名错误");
                return 200001;//用户名错误200001
            }

            if (pwd.equals(password)) {
                System.out.println("success");
                return 000001;//success100001
            } else {
                return 200002;//密码错误200002
            }
        } catch (Exception e) {
            return 300001;//未知错误300001


        }
    }




}
