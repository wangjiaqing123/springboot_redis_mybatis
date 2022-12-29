package Application.Controller;


import Application.Service.Txtservice;
import Application.Service.Userservice;
import Application.user.txtCode;
import Application.user.user;
import Application.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api(tags="小说管理")
@RestController
@RequestMapping("/v1/txt/pages")

public class Txtcontroller {
    @Autowired
    private Txtservice txtservice;
    @Autowired
    private Userservice userservice;
    @ApiOperation(value = "权限认证",httpMethod = "POST")
    @PostMapping("/login")
    public Result login(@RequestBody user us){
     return userservice.login(us.getUsername(),us.getPassword());
    }
    @ApiOperation(value = "查询小说",httpMethod = "POST")
    @PostMapping("/query")
    public List<txtCode> txtcode(@RequestBody txtCode code){
        return  txtservice.findOne(code.getPages());
    }
    @ApiOperation(value = "下一页",httpMethod = "POST")
    @PostMapping("/next")
    public List<txtCode> next(){
        return txtservice.next();
    }
    @ApiOperation(value = "上一页",httpMethod = "POST")
    @PostMapping("/previous")
    public List<txtCode> previous(){
        return txtservice.previous();
    }
    @ApiOperation(value = "获得缓存",httpMethod = "POST")
    @PostMapping("/cache")
    public List<txtCode> cache(){
        return txtservice.cache();
    }

}
