package com.khalej.Boutiqueadmin.model;
import com.google.gson.annotations.SerializedName;


public class contact_second_home{
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("image")
    String Img;

    @SerializedName("price")
    String link;
    @SerializedName("descritpion")
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
