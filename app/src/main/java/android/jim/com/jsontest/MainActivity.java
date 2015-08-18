package android.jim.com.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RequestQueue queue;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
        textView=(TextView)findViewById(R.id.content_text);
        button=(Button)findViewById(R.id.button);

        //StringRequest
       /* StringRequest stringRequest=new StringRequest(Request.Method.POST,"http://qq.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        Log.d("TAG",s);
                        textView.setText(s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG",volleyError.getMessage(),volleyError);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        queue.add(stringRequest);*/

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

    }
    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }


}
