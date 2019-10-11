package com.khalej.Boutiqueadmin.model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface_home {
//getcontacts_searchcode
@GET("montag/boutique/Boutique_annonce.php")
Call<List<contact_annonce>> getcontacts_annonce();

    @GET("montag/boutique/Boutique_first_category.php")
    Call<List<contact_home>> getcontacts_first();
    @GET("montag/boutique/Boutique_all_RegisterTager.php")
    Call<List<contact_tager>> getcontacts_first_tager();


    @FormUrlEncoded
    @POST("montag/boutique/Boutique_second_category.php")
    Call<List<contact_second_home>> getcontacts(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_add_category.php") Call<ResponseBody> getcontacts_add_first_category(@Field("name") String name, @Field("image") String image);

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_add_offer.php")
    Call<ResponseBody> getcontacts_add_offer(@Field("name") String name, @Field("image") String image ,
                                             @Field("oldprice") String oldprice,@Field("newprice") String newprice,
                                             @Field("details") String details);

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_Registraion.php")
    Call<ResponseBody> getcontacts_newaccount(@Field("name") String name, @Field("password") String password, @Field("address")String address,
                                              @Field("phone") String phone ,@Field("usertype")int usertype);


    @FormUrlEncoded
    @POST("montag/boutique/Boutique_delete_category.php")
    Call<ResponseBody> delete_first(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/boutique/Boutique_delete_tager.php")
    Call<ResponseBody> delete_tager(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/boutique/Boutique_add_annonce.php") Call<ResponseBody> getcontacts_add_annonce(@Field("image") String image);

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_add_Image.php") Call<ResponseBody>   getcontacts_add_Image(@Field("id") int id,@Field("image") String image);

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_add_Image_offer.php")
    Call<ResponseBody>   getcontacts_add_Image_offer(@Field("id") int id,@Field("image") String image);


    @FormUrlEncoded
    @POST("montag/boutique/Boutique_delete_annonce.php")
    Call<ResponseBody> delete_annonce(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_add_category_second.php")
    Call<ResponseBody> getcontacts_add_category(@Field("category_id") int category_id, @Field("name") String name,
                                                @Field("image") String image, @Field("link") String link,
                                                @Field("text") String text, @Field("tname") String tname);

    @GET("montag/boutique/Boutique_second_category_del.php")
    Call<List<contact_second_home>> getcontacts_del();
    @FormUrlEncoded
    @POST("montag/boutique/Boutique_delete_category_second.php")
    Call<ResponseBody> delete_second(@Field("id") int id);
    @GET("montag/boutique/Boutique_all_neworders.php")
    Call<List<contact_order>> get_all_neworders();
    @FormUrlEncoded
    @POST("montag/boutique/Boutique_delete_order.php")
    Call<ResponseBody> update_status(@Field("id") int id);
    @GET("montag/boutique/Boutique_offers.php")
    Call<List<contact_offer>> getcontacts_offer();

    @FormUrlEncoded
    @POST("montag/boutique/Boutique_login.php")
    Call<List<contact_userinfo>> getcontacts_login(@Field("phonee") String phone , @Field("passw") String password ,@Field("usertype")int usertype);
}

