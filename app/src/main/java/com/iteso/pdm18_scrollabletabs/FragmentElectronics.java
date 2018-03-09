package com.iteso.pdm18_scrollabletabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import java.util.ArrayList;

public class FragmentElectronics extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    public FragmentElectronics() {}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_electronics, container, false);
//        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler_view);
//        // Use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true);
//        // Use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(mLayoutManager);
//
//        ArrayList<ItemProduct> products = new ArrayList<>();
//        products.add(new ItemProduct(getResources().getString(R.string.tv_title),
//                getResources().getString(R.string.bestbuy_store),
//                getResources().getString(R.string.bestbuy_phone),
//                getResources().getString(R.string.tv_location),
//                getResources().getDrawable(R.drawable.tv),
//                getResources().getDrawable(R.drawable.bestbuy)));
//
//        products.add(new ItemProduct(getResources().getString(R.string.speakers_title),
//                getResources().getString(R.string.frys_store),
//                getResources().getString(R.string.frys_phone),
//                getResources().getString(R.string.speakers_location),
//                getResources().getDrawable(R.drawable.speakers),
//                getResources().getDrawable(R.drawable.frys)));
//
//        AdapterProduct adapterProduct = new AdapterProduct(products);
//        recyclerView.setAdapter(adapterProduct);
        return view;
    }
}
