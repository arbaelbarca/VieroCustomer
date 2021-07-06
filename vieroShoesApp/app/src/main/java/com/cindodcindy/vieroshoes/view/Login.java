package com.cindodcindy.vieroshoes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cindodcindy.vieroshoes.R;


public class Login extends AppCompatActivity {

    private Button button_login_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button_login_customer=findViewById(R.id.btn_login);
        button_login_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this,BottomNavActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}