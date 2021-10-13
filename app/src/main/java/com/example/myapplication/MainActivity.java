package com.example.myapplication;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton veryUnsatisfied;
    ImageButton unsatisfied;
    ImageButton neutral;
    ImageButton satisfied;
    ImageButton verySatisfied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        veryUnsatisfied = (ImageButton)findViewById(R.id.imageButton1);
        unsatisfied = (ImageButton)findViewById(R.id.imageButton2);
        neutral = (ImageButton)findViewById(R.id.imageButton3);
        satisfied = (ImageButton)findViewById(R.id.imageButton4);
        verySatisfied = (ImageButton)findViewById(R.id.imageButton5);

        MaterialToolbar my_Toolbar = (MaterialToolbar) findViewById(R.id.CustomToolbar);

        setSupportActionBar(my_Toolbar);

        getSupportActionBar().setTitle("LECO");
        getSupportActionBar().setSubtitle("Lanka Electricity Company (pvt) Ltd");
        getSupportActionBar().setIcon(getDrawable(R.drawable.logo));



        veryUnsatisfied.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   saveUser(createRequest1());
                                               }
                                           }


        );

        unsatisfied.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   saveUser(createRequest2());
                                               }
                                           }


        );

        neutral.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               saveUser(createRequest3());
                                           }
                                       }


        );

        satisfied.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               saveUser(createRequest4());
                                           }
                                       }


        );

        verySatisfied.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               saveUser(createRequest5());
                                           }
                                       }


        );


    }

    public UserRequest createRequest1(){
        UserRequest userRequest = new UserRequest();
        userRequest.setCounter_id(1);
        userRequest.setEmoji_id(1);

        return userRequest;
    }

    public UserRequest createRequest2(){
        UserRequest userRequest = new UserRequest();
        userRequest.setCounter_id(2);
        userRequest.setEmoji_id(2);

        return userRequest;
    }

    public UserRequest createRequest3(){
        UserRequest userRequest = new UserRequest();
        userRequest.setCounter_id(3);
        userRequest.setEmoji_id(3);

        return userRequest;
    }

    public UserRequest createRequest4(){
        UserRequest userRequest = new UserRequest();
        userRequest.setCounter_id(4);
        userRequest.setEmoji_id(4);

        return userRequest;
    }

    public UserRequest createRequest5(){
        UserRequest userRequest = new UserRequest();
        userRequest.setCounter_id(5);
        userRequest.setEmoji_id(5);

        return userRequest;
    }

    public void saveUser(UserRequest userRequest){
        Call<UserResponse> userResponseCall = ApiClient.getUserService().saveUser(userRequest);
        userResponseCall.enqueue((new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Response Saved",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Request failed ",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                   Toast.makeText(MainActivity.this,"Request failed "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        }));
    }


}