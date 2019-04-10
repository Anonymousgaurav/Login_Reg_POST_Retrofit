package com.example.get_post_retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.get_post_retrofit.Interface.Userapi;
import com.example.get_post_retrofit.Model.User;
import com.example.get_post_retrofit.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText lemail, lpassword;
    Button login_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lemail = findViewById(R.id.lemail);
        lpassword = findViewById(R.id.lpassword);
        login_user = findViewById(R.id.login_user);

        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = lemail.getText().toString();
                String f = lpassword.getText().toString();

                Userapi login = RetrofitClient.getRetrofitInstance().create(Userapi.class);
                Call<User> call = login.getSources(e, f);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body().getSuccess().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(Login.this, Result.class);
                            intent.putExtra("Token", response.body().getDetails().getId());
                            intent.putExtra("Token1", response.body().getDetails().getId());
                            startActivity(intent);

                        } else {
                            Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
