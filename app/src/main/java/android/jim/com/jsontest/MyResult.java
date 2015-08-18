package android.jim.com.jsontest;

import java.util.List;

/**
 * Created by huangjim on 8/18/2015.
 */
public class MyResult {
    private MySk sk;
    private MyToday today;
    private List<MyFuture> future;

    public MySk getSk() {
        return sk;
    }

    public void setSk(MySk sk) {
        this.sk = sk;
    }

    public MyToday getToday() {
        return today;
    }

    public void setToday(MyToday today) {
        this.today = today;
    }

    public List<MyFuture> getFuture() {
        return future;
    }

    public void setFuture(List<MyFuture> future) {
        this.future = future;
    }
}
