package io.renren.modules.sys.service.ex;


public class InsertException extends ServiceException{
    public String getMessage(){
        return "插入失败！！";
    }
}
