package io.renren.modules.sys.service.ex;

public class UpdateException extends ServiceException {

    public UpdateException(String s) {
        super();
    }

    public String getMessage(){
        return "更新错误！！";
    }
}
