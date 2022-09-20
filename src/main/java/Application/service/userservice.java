package Application.service;


import Application.mapper.usermapper;
import Application.user.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userservice {
    @Autowired
    private usermapper usermapper;

    public List<user> findall(){
        return usermapper.FindALL();
    }
    public Integer save(user us){
        System.out.println("添加数据成功");

//        if (User.getUsername()==null){
//            return usermapper.save(User);
//        }else{
//            return usermapper.update(User);
//        }
        return usermapper.save(us);
    }


}
