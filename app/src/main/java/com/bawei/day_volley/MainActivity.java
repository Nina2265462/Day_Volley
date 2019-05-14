package com.bawei.day_volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.day_volley.net.HttpUtil;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = findViewById(R.id.but);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone","15734512092");
        hashMap.put("pwd","1234");
        HttpUtil.getInstance().doHttpUtil("http://172.17.8.100/small/user/v1/login",hashMap);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
