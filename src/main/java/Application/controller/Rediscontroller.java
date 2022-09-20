package Application.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class Rediscontroller {
    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;
    @PostMapping("/add")
    public String add(@RequestBody JSONObject req){
        String key=req.getString("key");
        String value=req.getString("value");

        try {
            redisTemplate.opsForValue().set(key,value);
            return "add succcess";
        } catch (Exception e) {
            System.out.println("有可能你的redis没有启动");
            return "add daild";
        }
    }


    @PostMapping("/find")
    public String find(@RequestBody JSONObject req){
        String key=req.getString("key");

        try {
            String value = redisTemplate.opsForValue().get(key);
            return "find succcess:"+value;
        } catch (Exception e) {
            return "find faild";
        }
    }
    @PostMapping("/change")
    public String change(@RequestBody JSONObject req){
        String key=req.getString("key");
        String value=req.getString("value");

        try {
            redisTemplate.opsForValue().set(key,value);
            return "change succcess";
        } catch (Exception e) {
            return "change faild";
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestBody JSONObject req){
        String key=req.getString("key");

        try {
            redisTemplate.delete(key);
            return "delete succcess";
        } catch (Exception e) {
            return "delete faild";
        }
    }

}
