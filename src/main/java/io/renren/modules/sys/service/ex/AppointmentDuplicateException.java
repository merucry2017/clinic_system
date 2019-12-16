package io.renren.modules.sys.service.ex;

public class AppointmentDuplicateException extends ServiceException {
    public AppointmentDuplicateException() {
        super();
    }

    public AppointmentDuplicateException(String s) {
        super();
    }

    public AppointmentDuplicateException(Throwable cause) {
        super(cause);
    }

    public String getMessage(){
        return "挂号冲突！！挂号单已经存在！";
    }
}
