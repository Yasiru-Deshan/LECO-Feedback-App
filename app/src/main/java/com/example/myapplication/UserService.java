package com.example.myapplication;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("feedback")
    Call<UserResponse> saveUser(@Body UserRequest userRequest);

}
