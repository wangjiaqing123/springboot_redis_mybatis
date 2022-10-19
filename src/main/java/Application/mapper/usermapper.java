package Application.mapper;


import Application.user.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface usermapper {
    //查询
    @Select("select * from user where pages=1")
    List<user> FindALL();

    //增
    @Insert("insert into user (username,password) values(#{username},#{password})")
    Integer save(user us);
//    Integer update(user User);


}
