package io.renren.modules.sys.service.ex;

public class UsernameDuplicateException extends ServiceException {
    public UsernameDuplicateException() {
        super();
    }

    public UsernameDuplicateException(String s) {
        super();
    }

    public UsernameDuplicateException(Throwable cause) {
        super(cause);
    }

    public String getMessage(){
        return "用户名冲突！！";
    }
}
