package com.cindodcindy.vieroshoes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cindodcindy.vieroshoes.R;
import com.cindodcindy.vieroshoes.model.ModelForItem;
import com.cindodcindy.vieroshoes.view.adapter.AdapterHome;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<ModelForItem> modelForItems ;
    private RecyclerView recyclerView;
    private AdapterHome adapterHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView =findViewById(R.id.rv_home_item);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        // GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //


        modelForItems = new ArrayList<>();
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));
        modelForItems.add(new ModelForItem("Viero White Grey"));


        adapterHome= new AdapterHome(HomeActivity.this,modelForItems);
        recyclerView.setAdapter(adapterHome);

    }
}