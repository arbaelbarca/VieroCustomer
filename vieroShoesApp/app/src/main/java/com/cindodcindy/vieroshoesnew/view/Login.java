package com.cindodcindy.vieroshoesnew.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cindodcindy.vieroshoesnew.R;


public class Login extends AppCompatActivity {

    private Button button_login_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login_customer = findViewById(R.id.btn_login);
        button_login_customer.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, MenuBaruActivity.class);
            startActivity(intent);
            finish();
        });
    }
}