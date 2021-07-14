package com.cindodcindy.vieroshoes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cindodcindy.vieroshoes.R;
import com.cindodcindy.vieroshoes.model.ModelForItem;
import com.cindodcindy.vieroshoes.view.adapter.AdapterPayment;

import java.util.ArrayList;
import java.util.List;

public class PaymentListActivity extends AppCompatActivity {

    private List<ModelForItem> modelForItems ;
    private RecyclerView recyclerView;
    private AdapterPayment adapterPayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_list);

        recyclerView =findViewById(R.id.rv_payment);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(PaymentListActivity.this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //


        modelForItems = new ArrayList<>();
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));


        adapterPayment= new AdapterPayment(PaymentListActivity.this,modelForItems);
        recyclerView.setAdapter(adapterPayment);

    }
}