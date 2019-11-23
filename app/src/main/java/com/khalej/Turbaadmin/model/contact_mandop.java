package com.khalej.Turbaadmin.model;

import com.google.gson.annotations.SerializedName;

public class contact_mandop {
    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;
    @SerializedName("phone")
    String phone;
    @SerializedName("address")
    String address;
    @SerializedName("National_id")
    String National_id;
    @SerializedName("car_type")
    String car_type;

   @SerializedName("car_number")
   String car_number;

    public String getNational_id() {
        return National_id;
    }

    public void setNational_id(String national_id) {
        National_id = national_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
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
