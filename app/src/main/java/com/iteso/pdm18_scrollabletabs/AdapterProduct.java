package com.iteso.pdm18_scrollabletabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    private Context context;

    public AdapterProduct(ArrayList<ItemProduct> products){
        this.products = products;
    }

    public AdapterProduct(Context context, ArrayList<ItemProduct> products) {
        this.products = products;
        this.context=context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mStore;
        public TextView mPhone;
        public TextView mLocation;
        public Button mDetail;
        public ImageView mImage;
        public ImageView mImageStore;
        public LinearLayout mEdit;


        public ViewHolder(View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mPhone = v.findViewById(R.id.item_product_phone);
            mLocation = v.findViewById(R.id.item_product_location);
            mDetail = v.findViewById(R.id.item_product_detail);
            mImage = v.findViewById(R.id.item_product_image);
            mImageStore = v.findViewById(R.id.item_product_thumbnail);
            mEdit = v.findViewById(R.id.card_home_info);
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
        holder.mStore.setText(products.get(position).getStore());
        holder.mPhone.setText(products.get(position).getPhone());
        holder.mPhone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dial(v, position);
            }
        });
        holder.mLocation.setText(products.get(position).getLocation());

        switch (products.get(position).getImage()){
            case  0: holder.mImage.setImageResource(R.drawable.mac); break;
            case  1: holder.mImage.setImageResource(R.drawable.alienware); break;
            case  2: holder.mImage.setImageResource(R.drawable.lanix); break;
            default: holder.mImage.setImageResource(R.drawable.mac); break;
        }
        switch (products.get(position).getImageStore()){
            case  0: holder.mImageStore.setImageResource(R.drawable.bestbuy); break;
            case  1: holder.mImageStore.setImageResource(R.drawable.dell); break;
            case  2: holder.mImageStore.setImageResource(R.drawable.frys); break;
            default: holder.mImageStore.setImageResource(R.drawable.bestbuy); break;
        }

        holder.mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit(position);
            }
        });
    }

    public void showToast(View v, final int position){
        Toast.makeText(v.getContext(), products.get(position).toString(), Toast.LENGTH_LONG).show();
    }
    public void dial(View v, final int position){
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + products.get(position).getPhone()));
        v.getContext().startActivity(intent);
    }

    public void edit(final int position){
        ItemProduct itemProduct = new ItemProduct(
                products.get(position).getTitle(),
                products.get(position).getStore(),
                products.get(position).getLocation(),
                products.get(position).getPhone(),
                products.get(position).getImage(),
                products.get(position).getImageStore(),
                products.get(position).getCode());
        Intent intent = new Intent(context,ActivityProduct.class);
        intent.putExtra("ITEM", itemProduct);
        ((ActivityMain) context).startActivityForResult(intent, products.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
