package Application.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface txtcode {
    @Select("select * from txtcode")
    List<txtcode> FindALL();
}
