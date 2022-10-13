package Application.service;

import Application.util.Result;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Current_limiting {
    public static Result forbid(BlockException ex){
        log.error("限流成功");
        return Result.service_error();
    }
}
