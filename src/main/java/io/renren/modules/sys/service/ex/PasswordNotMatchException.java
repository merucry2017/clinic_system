package io.renren.modules.sys.service.ex;

public class PasswordNotMatchException extends ServiceException {
    public PasswordNotMatchException(String s) {
        super();
    }
    public String getMessage(){
        return "密码不一致！！";
    }
}
