package com.khalej.Boutiqueadmin.model;

import com.google.gson.annotations.SerializedName;

public class contact_offer {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("photo")
    String Img;

    @SerializedName("oldprice")
    String oldprice;
    @SerializedName("newprice")
    String newprice;
    @SerializedName("descritpion")
    String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewprice() {
        return newprice;
    }

    public void setNewprice(String newprice) {
        this.newprice = newprice;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}


