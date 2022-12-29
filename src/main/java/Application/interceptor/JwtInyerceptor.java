package Application.interceptor;

import Application.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Slf4j
public class JwtInyerceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //从http请求头中取出token
        String token = request.getHeader("token");
        if (token==null){
            log.error("用户未登入");
            throw new RuntimeException("无 token,请重新登入");
        }


        //验证token
        JwtUtil.checkSign(token);

        //验证通过后，这里取出JWT存放的数据
        //获得token中其他数据
//        Map<String,Object> info = JwtUtil.getInfo(token);
//        info.forEach((k,v) -> System.out.println(k+":"+v));
        return true;
    }

}
