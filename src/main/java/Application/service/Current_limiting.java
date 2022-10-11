package Application.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ResoureBlockHandler {
    public static String dohandle(BlockException ex){
        log.error("限流成功");
        return "访问太频繁了,稍等片刻再访问";
    }
}
