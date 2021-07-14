package com.cindodcindy.vieroshoes.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cindodcindy.vieroshoes.R;
import com.cindodcindy.vieroshoes.model.ModelForItem;
import com.cindodcindy.vieroshoes.view.Chat_page;
import com.cindodcindy.vieroshoes.view.Order_page;

import java.util.List;
import java.util.Locale;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.HomeChild> {

    public Context context;

    public List<ModelForItem> modelForItems;

    public AdapterHome(Context context, List<ModelForItem> modelForItems){
        this.context=context;
        this.modelForItems=modelForItems;
    }

    @Override
    public HomeChild onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View views= layoutInflater.inflate(R.layout.sepatu_item, parent, false);
        HomeChild homeChild=new HomeChild(views);


        return homeChild;
    }

    @Override
    public void onBindViewHolder( AdapterHome.HomeChild holder, int position) {
        final ModelForItem modelForItem = modelForItems.get(position);
        holder.textView_nama_aitem.setText(modelForItems.get(position).getItem_satu());
        holder.imageView_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Order_page.class);
                context.startActivity(intent);
            }
        });

    holder.imageView_chat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, Chat_page.class);
            context.startActivity(intent);

        }
    });

    holder.imageView_maps.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return modelForItems.size();
    }

    public class HomeChild extends RecyclerView.ViewHolder{
       private TextView textView_nama_aitem;

       private ImageView  imageView_maps,imageView_order, imageView_chat;


        public HomeChild( View itemView) {
            super(itemView);
            imageView_maps=itemView.findViewById(R.id.iv_go_to_maps);
            textView_nama_aitem=itemView.findViewById(R.id.tv_nama_barang);
            imageView_order=itemView.findViewById(R.id.iv_order);
            imageView_chat=itemView.findViewById(R.id.iv_chat);
        }
    }
}
