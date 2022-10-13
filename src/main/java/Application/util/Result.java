package Application.util;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private  Result() {}
    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.success);
        return result;
    }
    public static Result username_error(){
        Result result= new Result();
        result.setResultCode(ResultCode.user_not_exist);
        return result;
    }
    public static Result password_error(){
        Result result=new Result();
        result.setResultCode(ResultCode.user_password_error);
        return result;
    }
    public static Result unknow_error(){
        Result result=new Result();
        result.setResultCode(ResultCode.user_unknow_error);
        return result;
    }
    public static Result register_error(){
        Result result=new Result();
        result.setResultCode(ResultCode.register_error);
        return result;
        //如果这里一直错误检查

    }
    public static Result service_error(){
        Result result=new Result();
        result.setResultCode(ResultCode.service_error);
        return result;

    }
    public static Result user_null_error(){
        Result result=new Result();
        result.setResultCode(ResultCode.user_null_error);
        return result;

    }


}

