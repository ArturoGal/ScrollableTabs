package com.iteso.pdm18_scrollabletabs.beans;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct implements Parcelable {
    private String title;
    private String store;
    private String location;
    private String phone;
    private int image;
    private int imageStore;
    private int code;

    public ItemProduct(String title, String store, String location, String phone, int image, int imageStore, int code) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.image = image;
        this.imageStore = imageStore;
        this.code = code;
    }

    public ItemProduct() {
        this.title = "";
        this.store = "";
        this.location = "";
        this.phone = "";
        this.image = 0;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageStore() {
        return imageStore;
    }

    public void setImageStore(int imageStore) {
        this.imageStore = imageStore;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.store);
        dest.writeString(this.location);
        dest.writeString(this.phone);
        dest.writeInt(this.image);
        dest.writeInt(this.code);
    }

    protected ItemProduct(Parcel in) {
        this.title = in.readString();
        this.store = in.readString();
        this.location = in.readString();
        this.phone = in.readString();
        this.image = in.readInt();
        this.code = in.readInt();
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };
}
