package Application.interceptor;

import Application.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JwtInyerceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //从http请求头中取出token
        String token = request.getHeader("token");
        System.out.println("此处测试是否拿到了token："+token);
        if (token==null){
            throw new RuntimeException("无 token,请重新登入");
        }


        //验证token
        //这里验证没通过后程序不会回来了应该
        JwtUtil.checkSign(token);
        System.out.println("这里测试验证没通过会不会执行");

        //验证通过后，这里取出JWT存放的数据
        //获得token中其他数据
        Map<String,Object> info = JwtUtil.getInfo(token);
        info.forEach((k,v) -> System.out.println(k+":"+v));
        //这里也需要讲
        return true;
    }

}
