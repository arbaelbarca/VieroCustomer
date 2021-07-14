package com.cindodcindy.vieroshoes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cindodcindy.vieroshoes.R;

public class MenuBaruActivity extends AppCompatActivity {

    private CardView cardView_list, cardView_order, cardView_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_baru);

        cardView_list=findViewById(R.id.cv_go_to_list_sepatu);
        cardView_order=findViewById(R.id.cv_go_to_order);
        cardView_payment=findViewById(R.id.cv_go_to_payment);

        cardView_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuBaruActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        cardView_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuBaruActivity.this,OrderActivity.class);
                startActivity(intent);


            }
        });

        cardView_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuBaruActivity.this,PaymentListActivity.class);
                startActivity(intent);

            }
        });
    }
}