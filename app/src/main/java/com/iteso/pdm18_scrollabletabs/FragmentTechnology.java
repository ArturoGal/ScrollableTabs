package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import java.util.ArrayList;
import java.util.Iterator;

public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter mAdapter;
    ArrayList<ItemProduct> products = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    public FragmentTechnology() {}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


        products.add(new ItemProduct(getResources().getString(R.string.mac_title),
                getResources().getString(R.string.bestbuy_store),
                getResources().getString(R.string.mac_location),
                getResources().getString(R.string.bestbuy_phone),
                0, 0, 0));

        products.add(new ItemProduct(getResources().getString(R.string.aw_title),
                getResources().getString(R.string.dell_store),
                getResources().getString(R.string.aw_location),
                getResources().getString(R.string.dell_phone),
                1, 1, 1));

        products.add(new ItemProduct(getResources().getString(R.string.lanix_title),
                getResources().getString(R.string.frys_store),
                getResources().getString(R.string.lanix_location),
                getResources().getString(R.string.frys_phone),
                2, 2, 2));

        mAdapter = new AdapterProduct(getActivity(),products);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra("ITEM");
        Iterator<ItemProduct> iterator = products.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProduct item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                products.set(position, itemProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }
}
