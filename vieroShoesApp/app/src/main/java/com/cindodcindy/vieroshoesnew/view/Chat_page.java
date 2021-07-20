package com.cindodcindy.vieroshoesnew.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cindodcindy.vieroshoesnew.R;
import com.cindodcindy.vieroshoesnew.model.ModelForItem;
import com.cindodcindy.vieroshoesnew.view.adapter.AdapterChatAdmin;
import com.cindodcindy.vieroshoesnew.view.adapter.AdapterChatCustomer;

import java.util.ArrayList;
import java.util.List;

public class Chat_page extends AppCompatActivity {

    private List<ModelForItem> modelForItems ;
    private RecyclerView recyclerView_satu, recyclerView_dua;
    private AdapterChatAdmin adapterChatAdmin;
    private AdapterChatCustomer adapterChatCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);

        recyclerView_satu =findViewById(R.id.rv_admin);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_satu.setHasFixedSize(true);
        recyclerView_satu.setLayoutManager(new LinearLayoutManager(Chat_page.this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //


        modelForItems = new ArrayList<>();
        modelForItems.add(new ModelForItem("Admin Message First"));
        modelForItems.add(new ModelForItem("Admin Message Second"));
        modelForItems.add(new ModelForItem("Admin Message Third"));


        adapterChatAdmin= new AdapterChatAdmin(Chat_page.this,modelForItems);
        recyclerView_satu.setAdapter(adapterChatAdmin);



        recyclerView_dua =findViewById(R.id.rv_cst);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_dua.setHasFixedSize(true);
        recyclerView_dua.setLayoutManager(new LinearLayoutManager(Chat_page.this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //


        modelForItems = new ArrayList<>();
        modelForItems.add(new ModelForItem("Customer Message First"));
        modelForItems.add(new ModelForItem("Customer Message Second"));
        modelForItems.add(new ModelForItem("Customer Message Third"));


        adapterChatCustomer= new AdapterChatCustomer(Chat_page.this,modelForItems);
        recyclerView_dua.setAdapter(adapterChatCustomer);
    }
}