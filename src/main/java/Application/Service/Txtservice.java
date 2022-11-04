package Application.Service;


import Application.Mapper.Txtcodemapper;
import Application.user.txtCode;
import Application.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Txtservice {
    @Autowired
    private Txtcodemapper txtcodemapper;
    public List<txtCode> findall(String pages){
        return txtcodemapper.FindALL(pages);
    }

}
