package personal.darxan.hostel.vo;

/**
 * Created by darxan on 2017/2/15.
 */
public class ServiceResult {

    public ServiceResult() {}

    public ServiceResult(boolean success) {
        this.setSuccess(success);
    }

    private boolean success;

    private String message;

    private Object value;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", value=" + value +
                '}';
    }
}
