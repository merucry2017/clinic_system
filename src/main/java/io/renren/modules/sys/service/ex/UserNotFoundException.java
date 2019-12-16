package io.renren.modules.sys.service.ex;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String s) {
        super();
    }

    public String getMessage(){
        return "用户名不存在！！";
    }
}
