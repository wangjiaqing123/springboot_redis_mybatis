package Application.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/sql")
public class JDBCcontroller {
    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;
    @PostMapping("/register")
    public String register(@RequestBody JSONObject req){
        String username=req.getString("username");
        String password=req.getString("password");
        try {
            String sql="insert into user (username,password) value (?,?)";
            jdbcTemplate.update(sql,username,password);
            redisTemplate.opsForValue().set(username,password);
            return "sucess";
        } catch (DataAccessException e) {
            return "failed";
        }
    }
    @RequestMapping("/login")
    public String login(@RequestBody JSONObject req){
        String username=req.getString("username");
        String password=req.getString("password");
        redisTemplate.hasKey(username);
        //redis插入
        try {
            String pwd=redisTemplate.opsForValue().get(username);
            System.out.println(pwd);
            if (redisTemplate.hasKey(username)==false){
                System.out.println("用户名错误");
                return "user error";
            }

            if (pwd.equals(password)){
                System.out.println("success");
                return "success";
            }else{
                return "password error";
            }
        } catch (Exception e) {
            return "unknow error";

        }

        }

}
//数据库登入
//        try {
//            String sql="select * from user where username="+"\""+username+"\"";
//            List<Map<String,Object>>maps=jdbcTemplate.queryForList(sql);
//            if(maps.size()==0){
//                return "user error";
//            }
//            if(maps.size()==1){
//                String pwd = (String) maps.get(0).get("password");
//                System.out.println(pwd);
//                System.out.println(password);
//                if(pwd.equals(password)){
//                    System.out.println("success");
//                }else {
//                    return "password error";
//                }
//            }
//
//            return "success";
//        } catch (DataAccessException e) {
//            return "unknow error";
//        }
//    }
