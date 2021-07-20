package com.cindodcindy.vieroshoesnew.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.vieroshoesnew.R;
import com.cindodcindy.vieroshoesnew.model.ModelForItem;
import com.cindodcindy.vieroshoesnew.view.adapter.AdapterHome;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<ModelForItem> modelForItems;
    private RecyclerView recyclerView;
    private AdapterHome adapterHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
}