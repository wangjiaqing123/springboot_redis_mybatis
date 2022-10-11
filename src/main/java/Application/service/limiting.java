package Application.service;

import Application.util.Result;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @SentinelResource(value = "doGetResource",
            blockHandlerClass = ResoureBlockHandler.class,
            blockHandler = "dohandle")
    public Result dogetResource(){
        return Result.success();

    }
}
