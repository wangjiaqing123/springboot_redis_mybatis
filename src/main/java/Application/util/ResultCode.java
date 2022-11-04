package Application.util;

public enum ResultCode {
    success(1,"操作成功"),
    error(0,"操作失败，未知指定错误信息"),
    //用户错误10001-19999
    user_not_exist(10001,"用户不存在"),
    user_password_error(10002,"密码错误"),
    user_unknow_error(10003,"未知错误"),
    user_null_error(10004,"null错误"),
    //注册错误20001-29999
    register_error(20001,"注册错误"),
    //服务器错误30001-39999
    service_error(30001,"服务器繁忙"),
    //数据库mybatis错误40001-49999
    mybatis_error(40001,"mybatis出错");


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer code(){
        return  this.code;
    }
    public String message(){
        return this.message;
    }
}
