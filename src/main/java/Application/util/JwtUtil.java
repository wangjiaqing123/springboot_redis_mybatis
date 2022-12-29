package Application.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
@Slf4j
//11
public class JwtUtil {
    private static final long EXPIRE_TIME = 120 * 60 * 1000;
    //EXPIRE_TIME 到期时间 过期5分钟
    //final：最终的，也就是不允许修改
    private static final String SECRET ="jwt_secret";
    //jwt密钥
    public static String sign(String userId, Map<String,Object> info){
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //获得当前时间毫米加上五分钟
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //用HMAC256进行加密
            return JWT.create()
                    .withAudience(userId)
                    .withClaim("info",info)
                    .withExpiresAt(date)
                    .sign(algorithm);
            //将userid存放在token中
            //存放自定义数据
            //五分钟token过期
            //token的密钥


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
    //根据token获取自定义数据info
    public static Map<String,Object> getInfo(String token){
        try {
            return JWT.decode(token).getClaim("info").asMap();
        } catch (JWTDecodeException e) {
            return null;
        }

    }
    //校验token
    public static boolean checkSign(String token){
        try {
            //解密
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            System.out.println(token);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("token失效");
            throw new RuntimeException("token无效");
        }

    }
}