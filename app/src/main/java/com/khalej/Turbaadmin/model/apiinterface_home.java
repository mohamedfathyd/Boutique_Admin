package com.khalej.Turbaadmin.model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiinterface_home {
//getcontacts_searchcode
@GET("montag/turba/Torba_annonce.php")
Call<List<contact_annonce>> getcontacts_annonce();

    @GET("montag/turba/Torba_all_generalcategory.php")
    Call<List<contact_home>> getcontacts_first();
    @GET("montag/turba/Torba_all_RegisterTager.php")
    Call<List<contact_tager>> getcontacts_first_tager();
    @GET("montag/turba/Torba_all_RegisterMandop.php")
    Call<List<contact_mandop>> getcontacts_first_mandop();

    @FormUrlEncoded
    @POST("montag/turba/Torba_second_category.php")
    Call<List<contact_second_home>> getcontacts(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/turba/Torba_add_generalcategory.php")
    Call<ResponseBody> getcontacts_add_first_category(@Field("name") String name,
                                                      @Field("image") String image, @Field("sub_id") int id);
    @FormUrlEncoded
    @POST("montag/turba/Torba_update_generalcategory.php")
    Call<ResponseBody> getcontacts_update_first_category( @Field("id") int id,@Field("name") String name,
                                                      @Field("image") String image, @Field("sub_id") int sub_id);

    @FormUrlEncoded
    @POST("montag/turba/Torba_update_category.php")
    Call<ResponseBody> getcontacts_update_second_category( @Field("id") int id,@Field("name") String name,
                                                          @Field("image") String image);


    @FormUrlEncoded
    @POST("montag/turba/Torba_add_category.php")
    Call<ResponseBody> getcontacts_add_f_category(@Field("name") String name,
                                                      @Field("image") String image, @Field("sub_id") int id,
                                                  @Field("phone") String phone,@Field("password")String password);

    @FormUrlEncoded
    @POST("montag/turba/Torba_add_offer.php")
    Call<ResponseBody> getcontacts_add_offer(@Field("name") String name, @Field("image") String image ,
                                             @Field("oldprice") String oldprice,@Field("newprice") String newprice,
                                             @Field("details") String details);

    @FormUrlEncoded
    @POST("montag/turba/Torba_Registraion.php")
    Call<ResponseBody> getcontacts_newaccount(@Field("name") String name, @Field("password") String password, @Field("address")String address,
                                              @Field("phone") String phone ,@Field("usertype")int usertype);

    @FormUrlEncoded
    @POST("montag/turba/Torba_Registraion.php")
    Call<ResponseBody> getcontacts_newaccount2(@Field("name") String name, @Field("password") String password, @Field("address")String address,
                                              @Field("phone") String phone ,@Field("usertype")int usertype);

    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_generalcategory.php")
    Call<ResponseBody> delete_first(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_offer.php")
    Call<ResponseBody> delete_first_offer(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_order.php")
    Call<ResponseBody> delete_order(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_InsideAnnonce.php")
    Call<ResponseBody> delete_InsideAnnonce(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/turba/Torba_add_annonce.php") Call<ResponseBody> getcontacts_add_annonce(@Field("image") String image);

    @FormUrlEncoded
    @POST("montag/turba/Torba_add_Image.php") Call<ResponseBody>   getcontacts_add_Image(@Field("id") int id,@Field("image") String image);

    @FormUrlEncoded
    @POST("montag/turba/Torba_add_Image_offer.php")
    Call<ResponseBody>   getcontacts_add_Image_offer(@Field("id") int id,@Field("image") String image);


    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_annonce.php")
    Call<ResponseBody> delete_annonce(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/turba/Torba_add_category_second.php")
    Call<ResponseBody> getcontacts_add_category(@Field("category_id") int category_id, @Field("name") String name,
                                                @Field("image") String image, @Field("link") String link,
                                                @Field("text") String text, @Field("tname") String tname);
    @FormUrlEncoded
    @POST("montag/turba/Torba_update_category_second.php")
    Call<ResponseBody> getcontacts_update_category(@Field("id")int id,@Field("category_id") int category_id, @Field("name") String name,
                                                @Field("image") String image, @Field("link") String link,
                                                @Field("text") String text, @Field("tname") String tname);
    @FormUrlEncoded
    @POST("montag/turba/Torba_second_category_del.php")
    Call<List<contact_second_home>> getcontacts_del(@Field("id") int id);

    @GET("montag/turba/Torba_second_category_del_admin.php")
    Call<List<contact_second_home>> getcontacts_del_admin();

    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_category_second.php")
    Call<ResponseBody> delete_second(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/turba/Torba_order_with_mandop.php")
    Call<ResponseBody> mandop_add_order_tohim(@Field("id") int id,@Field("name") String name);
    @GET("montag/turba/Torba_all_neworders.php")
    Call<List<contact_order>> get_all_neworders();

    @FormUrlEncoded
    @POST("montag/turba/Torba_all_recervation_today.php")
    Call<List<contact_order>> get_all_neworders_day(@Field("Date") String Date);
    @FormUrlEncoded
    @POST("montag/turba/Torba_all_recervation_day.php")
    Call<List<contact_order>> get_all_neworders_ofday();
    @FormUrlEncoded
    @POST("montag/turba/Torba_all_recervation_month.php")
    Call<List<contact_order>> get_all_neworders_month(@Field("Date") String Date);

    @GET("montag/turba/Torba_all_readyorders.php")
    Call<List<contact_order>> get_all_ready_orders();
    @GET("montag/turba/Torba_all_order_with_mandops.php")
    Call<List<contact_order>> get_all_neworders_with_mandop();
    @FormUrlEncoded
    @POST("montag/turba/Torba_order_ready.php")
    Call<ResponseBody> update_status(@Field("id") int id);

    @GET("montag/turba/Torba_all_Tager.php")
    Call<List<contact_userinfo>> get_all_tager();
    @GET("montag/turba/Torba_all_category.php")
    Call<List<contact_second_home>> get_all_category();
    @GET("montag/turba/Torba_all_mandop.php")
    Call<List<contact_userinfo>> get_all_mandop();
    @GET("montag/turba/Torba_all_users.php")
    Call<List<contact_userinfo>> get_all_users();
    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_tagerafterR.php")
    Call<ResponseBody> delete_tager(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_category.php")
    Call<ResponseBody> delete_category(@Field("id") int id);
    @FormUrlEncoded
    @POST("montag/turba/Torba_delete_tager.php")
    Call<ResponseBody> delete_tagerr(@Field("id") int id);

    @GET("montag/turba/Torba_offers.php")
    Call<List<contact_offer>> getcontacts_offer();

    @FormUrlEncoded
    @POST("montag/turba/Torba_login.php")
    Call<List<contact_userinfo>> getcontacts_login(@Field("phonee") String phone , @Field("passw") String password ,@Field("type_user")int usertype);
}

