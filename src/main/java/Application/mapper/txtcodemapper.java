package Application.mapper;


import Application.user.txtCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface txtcodemapper{
    @Select("select * from txtcode where pages=#{pages}")
    List<txtCode> FindALL(String pages);
//    @Select("select * from t_person where id = #{id}")
//    Person selectPersonById(Integer id);


}
