package com.iteso.pdm18_scrollabletabs.beans;

import android.graphics.drawable.Drawable;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct {
    private String title;
    private String store;
    private String phone;
    private String location;
    private Drawable image;
    private Drawable imageStore;

    public ItemProduct(String title, String store, String phone, String location, Drawable image, Drawable imageStore) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.location = location;
        this.image = image;
        this.imageStore = imageStore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImageStore() {
        return imageStore;
    }

    public void setImageStore(Drawable imageStore) {
        this.imageStore = imageStore;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
