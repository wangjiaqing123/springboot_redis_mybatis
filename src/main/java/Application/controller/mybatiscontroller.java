package Application.controller;

import Application.mapper.usermapper;
import Application.service.userservice;
import Application.user.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class mybatiscontroller {
    @Autowired
    private userservice userservice;
    @GetMapping("/find")
    public List<user> findall(){
        for (user user : userservice.findall()) {
            System.out.println(user);
        }
        return  userservice.findall();
    }
    @GetMapping("/save")
    public Integer save(@RequestBody user us){
        System.out.println("添加数据成功");

        return userservice.save(us);
    }

}
