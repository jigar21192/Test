package com.example.sparks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView name,gender,age,balance,friends,online;
String na,ge,ag,ba,fnd,on;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       na= getIntent().getStringExtra("name");
        ge= getIntent().getStringExtra("gender");
        ag= getIntent().getStringExtra("age");
        ba= getIntent().getStringExtra("balance");
        fnd= getIntent().getStringExtra("friend");
        on= getIntent().getStringExtra("online");

        name=findViewById(R.id.name);
        gender=findViewById(R.id.gender);
        age=findViewById(R.id.age);
        balance=findViewById(R.id.balance);
        friends=findViewById(R.id.friends);
        online=findViewById(R.id.online);

        name.setText(na);
        gender.setText(ge);
        age.setText(ag);
        balance.setText(ba);
        friends.setText(fnd);
        online.setText(on);



    }
}
