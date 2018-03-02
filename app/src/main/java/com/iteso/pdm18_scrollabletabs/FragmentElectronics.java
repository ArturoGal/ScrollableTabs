package com.iteso.pdm18_scrollabletabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.AdapterProduct;
import com.iteso.pdm18_scrollabletabs.R;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

public class FragmentElectronics extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public FragmentElectronics() {}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_electronics, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> products = new ArrayList<>();
        products.add(new ItemProduct(getResources().getString(R.string.aw_title),
                getResources().getString(R.string.aw_store),
                getResources().getString(R.string.aw_phone),
                getResources().getString(R.string.aw_location),
                getResources().getDrawable(R.drawable.alienware),
                getResources().getDrawable(R.drawable.dell)));
        products.add(new ItemProduct(getResources().getString(R.string.lanix_title),
                getResources().getString(R.string.lanix_store),
                getResources().getString(R.string.lanix_phone),
                getResources().getString(R.string.lanix_location),
                getResources().getDrawable(R.drawable.lanix),
                getResources().getDrawable(R.drawable.frys)));



        AdapterProduct adapterProduct = new AdapterProduct(products);
        recyclerView.setAdapter(adapterProduct);
        return view;
    }
}
