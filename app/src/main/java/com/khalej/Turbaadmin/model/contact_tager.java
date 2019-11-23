package com.khalej.Turbaadmin.model;

import com.google.gson.annotations.SerializedName;

public class contact_tager {
    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;
    @SerializedName("phone")
    String phone;
    @SerializedName("address")
    String address;
    @SerializedName("segel_togary")
    String segel_togary;
    @SerializedName("Matgar_name")
    String Matgar_name;

    public String getMatgar_name() {
        return Matgar_name;
    }

    public void setMatgar_name(String matgar_name) {
        Matgar_name = matgar_name;
    }

    public String getSegel_togary() {
        return segel_togary;
    }

    public void setSegel_togary(String segel_togary) {
        this.segel_togary = segel_togary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
