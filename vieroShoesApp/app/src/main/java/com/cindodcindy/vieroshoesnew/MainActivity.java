package com.cindodcindy.vieroshoesnew;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.cindodcindy.vieroshoesnew.view.activity.LoginActivity;
import com.orhanobut.hawk.Hawk;

public class MainActivity extends AppCompatActivity {

    private final int waktu_loading = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String getEmail = Hawk.get("emailProfile");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, waktu_loading);
    }
}