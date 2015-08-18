package android.jim.com.jsontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RequestQueue queue;
    private Button button;
    private Gson gson;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Volley实例化
        queue = Volley.newRequestQueue(this);
        textView = (TextView) findViewById(R.id.content_text);
        button = (Button) findViewById(R.id.button);

        gson = new Gson();

        try {
            //这个URL是自己在网上申请的一个天气接口
            String addressCode = URLEncoder.encode("北京", "UTF-8");
            url = "http://apis.haoservice.com/weather?cityname=" + addressCode + "&key=b2827fdb1ceb477684fdd442b0100fa9";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Volley的StringRequest方法
        final StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (!TextUtils.isEmpty(s)) {
                            Log.d("TAG", s);
                            System.out.println(s);
                            Status status = gson.fromJson(s, Status.class);
                            MyResult myResult = status.getResult();
                            MyToday myToday = myResult.getToday();
                            //这是我想要得到的数据城市+日期+温度+天气情况+穿衣建议
                            String msg = myToday.getCity() + myToday.getDate_y() + myToday.getTemperature() + myToday.getWeather() + "\n" + myToday.getDressing_advice();
                            textView.setText(msg);
                        } else {
                            Toast.makeText(MainActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击触发下载
                queue.add(stringRequest);

            }
        });

    }

}

//JSONRequest
        /*JsonObjectRequest jsonObjectRequest=new JsonObjectRequest("http://apis.haoservice.com/weather?cityname=北京&key=b2827fdb1ceb477684fdd442b0100fa9",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                textView.setText(jsonObject.toString());
                Log.d("TAG",jsonObject.toString());
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Log.e("TAG",volleyError.getMessage(),volleyError);
                    }
                });
        queue.add(jsonObjectRequest);*/
