package Application.Mapper;


import Application.user.txtCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Txtcodemapper {
    @Select("select * from txtcode where pages=#{pages}")
    List<txtCode> FindALL(String pages);



}
