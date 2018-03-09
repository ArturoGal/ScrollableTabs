package com.iteso.pdm18_scrollabletabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    EditText title, store, location, phone;
    ImageView image;
    ItemProduct product1, product2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        title = findViewById(R.id.item_product_title);
        store = findViewById(R.id.item_product_store);
        location = findViewById(R.id.item_product_location);
        phone = findViewById(R.id.item_product_phone);
        image = findViewById(R.id.item_product_image);

        try{
            if(getIntent().getExtras() != null){
                product1 = getIntent().getParcelableExtra("ITEM");
                if(product1 != null){
                    title.setText(product1.getTitle());
                    store.setText(product1.getStore());
                    location.setText(product1.getLocation());
                    phone.setText(product1.getPhone());
                    switch (product1.getImage()){
                        case  0: image.setImageResource(R.drawable.mac); break;
                        case  1: image.setImageResource(R.drawable.alienware); break;
                        case  2: image.setImageResource(R.drawable.lanix); break;
                        default: image.setImageResource(R.drawable.mac); break;
                    }
                }
            }
        }catch(Exception e){

        }

    }
    public void cancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void save(View v){
        product2 = new ItemProduct();
        product2.setTitle(title.getText().toString());
        product2.setStore(store.getText().toString());
        product2.setLocation(location.getText().toString());
        product2.setPhone(phone.getText().toString());
        product2.setImage(product1.getImage());
        product2.setCode(product1.getCode());

        Intent intent = new Intent();
        intent.putExtra("ITEM", product2);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
