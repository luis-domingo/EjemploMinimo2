package com.example.ejemplominimo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplominimo2.models.Element;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    List<Element> museumsList = new ArrayList<>();
    Context context;


    public MyRecyclerViewAdapter(List<Element> museumsList, Context context) {
        this.museumsList = museumsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.txtViewTitle.setText(museumsList.get(position).getAdrecaNom());
        Picasso.get().load(museumsList.get(position).getImatge().get(0)).into(viewHolder.imgViewIcon);
        //viewHolder.txtViewPrice.setText(String.valueOf(productList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return museumsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.textView);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.imageView);
        }
    }
}
