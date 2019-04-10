package com.example.get_post_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.get_post_retrofit.Interface.Userapi;
import com.example.get_post_retrofit.Model.User;
import com.example.get_post_retrofit.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    EditText name, email, phone, password;
    Button save_user;
    TextView create_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        save_user = findViewById(R.id.save_user);
        create_new = findViewById(R.id.create_new);

        create_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });


        save_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = name.getText().toString();
                String b = email.getText().toString();
                String c = phone.getText().toString();
                String d = password.getText().toString();

                Userapi api = RetrofitClient.getRetrofitInstance().create(Userapi.class);

                api.postuser(a, b, c, d, "Android", "12345").enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body().getSuccess().equalsIgnoreCase("1")) {
                            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

    }
}
