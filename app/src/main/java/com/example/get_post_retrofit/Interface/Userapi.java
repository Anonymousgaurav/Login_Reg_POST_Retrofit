package com.example.get_post_retrofit.Interface;


import com.example.get_post_retrofit.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Userapi {

    @FormUrlEncoded
    @POST("userRegister")
    Call<User> postuser(@Field("name") String title,
                        @Field("email") String email,
                        @Field("phone") String phone,
                        @Field("password") String password,
                        @Field("device_type") String device_type,
                        @Field("reg_id") String reg_id);

    @FormUrlEncoded
    @POST("userLogin")
    Call<User> getSources(@Field("email") String email,
                          @Field("password") String password);

}