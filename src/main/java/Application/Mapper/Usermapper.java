package Application.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper{
    @Select("select * from user where username=#{username}")
    String query(String username);
    @Insert("insert into user (username,password) values(#{username},#{password})")
    Boolean save(String username,String password);


}
