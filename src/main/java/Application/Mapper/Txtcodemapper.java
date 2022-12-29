package Application.Mapper;


import Application.user.txtCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Txtcodemapper {
    @Select("select * from txtcode where pages=#{pages}")
    List<txtCode> FindOne(String pages);

    @Select("select pages from cache order by id desc limit 1;")
    String cache();

    @Insert("insert into cache (pages) values(#{pages})")
    int pages(int pages);

}
