package android.jim.com.jsontest;

/**
 * Created by huangjim on 8/18/2015.
 */
public class Status {
    private String error_code;
    private String reason;
    private MyResult result;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public MyResult getResult() {
        return result;
    }

    public void setResult(MyResult result) {
        this.result = result;
    }
}
