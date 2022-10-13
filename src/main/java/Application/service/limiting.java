package Application.service;

import Application.util.Result;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class limiting {
    @SentinelResource(value = "Current_limiting",
            blockHandlerClass = Current_limiting.class,
            blockHandler = "forbid")
    public Result Current_limiting(){
        return Result.success();

    }
}
