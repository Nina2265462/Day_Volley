package com.bawei.day_volley.net;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.day_volley.MyApplication;

import java.util.Map;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HttpUtil {
    private final String TAG = HttpUtil.class.getSimpleName();
    private static final HttpUtil ourInstance = new HttpUtil();

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {
    }

    public void doHttpUtil(String surl, final Map<String,String> map) {
        StringRequest request = new StringRequest(Request.Method.POST, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        MyApplication.getQueue().add(request);
    }

}
