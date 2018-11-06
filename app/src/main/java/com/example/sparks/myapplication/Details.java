package com.example.sparks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Details extends AppCompatActivity {
TextView name,gender,age,balance,friends,online;
String na,ge,ag,ba,on;
    ArrayList<String>array;
    String doller;
    Double rupee;
    int a=72;
    double d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        na= getIntent().getStringExtra("name");
        ge= getIntent().getStringExtra("gender");
        ag= getIntent().getStringExtra("age");
        ba= getIntent().getStringExtra("balance");

        array = (ArrayList<String>) getIntent().getExtras().getStringArrayList("friend");
        on= getIntent().getStringExtra("online");

       

        String ba1=ba.substring(1);
        doller = ba1.replaceAll(",", "");

        d=Double.parseDouble(doller);

    rupee= Double.valueOf((d*a));

        name=findViewById(R.id.name);
        gender=findViewById(R.id.gender);
        age=findViewById(R.id.age);
        balance=findViewById(R.id.balance);
        friends=findViewById(R.id.friends);
        online=findViewById(R.id.online);

        name.setText(na);
        gender.setText(ge);
        age.setText(ag);
        balance.setText(String.valueOf(rupee));
        friends.setText(array.toString());
        online.setText(on);



    }
}
