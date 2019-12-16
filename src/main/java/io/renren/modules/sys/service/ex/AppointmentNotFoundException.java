package io.renren.modules.sys.service.ex;

public class AppointmentNotFoundException extends ServiceException {
    public AppointmentNotFoundException(String s) {
        super();
    }

    public String getMessage(){
        return "挂号单不存在！！";
    }
}
