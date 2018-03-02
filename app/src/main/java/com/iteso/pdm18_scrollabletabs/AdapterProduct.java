package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    public AdapterProduct(ArrayList<ItemProduct> products){
        this.products = products;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mStore;
        public TextView mPhone;
        public TextView mLocation;
        public Button mDetail;
        public ImageView mImage;
        public ImageView mImageStore;


        public ViewHolder(View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mPhone = v.findViewById(R.id.item_product_phone);
            mLocation = v.findViewById(R.id.item_product_location);
            mDetail = v.findViewById(R.id.item_product_detail);
            mImage = v.findViewById(R.id.item_product_image);
            mImageStore = v.findViewById(R.id.item_product_thumbnail);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTitle.setText(products.get(position).getTitle());
        holder.mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, position);
            }
        });
        holder.mStore.setText(products.get(position).getStore());
        holder.mStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, position);
            }
        });
        holder.mPhone.setText(products.get(position).getPhone());
        holder.mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + products.get(position).getPhone()));
                v.getContext().startActivity(intent);
            }
        });
        holder.mLocation.setText(products.get(position).getLocation());
        holder.mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, position);
            }
        });
        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, position);
            }
        });
        holder.mImage.setImageDrawable(products.get(position).getImage());
        holder.mImageStore.setImageDrawable(products.get(position).getImageStore());
    }

    public void showToast(View v, final int position){
        Toast.makeText(v.getContext(), products.get(position).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
