package com.example.get_post_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView result1;
    TextView result2;
    String s,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result1 =findViewById(R.id.result1);
        result2 =findViewById(R.id.result2);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();


        s = b.getString("Token");
        p =  b.getString("Token1");
        result1.setText(s);
        result2.setText(p);



    }
}
