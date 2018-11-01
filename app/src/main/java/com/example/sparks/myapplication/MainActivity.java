package com.example.sparks.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String sname,sid,color;
    ListView listView;
    List<Model>list=new ArrayList<>();
    Context context;

    String URL="http://www.json-generator.com/api/json/get/ceRwfmKnVK?indent=2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.lv);


        StringRequest request=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             //   Log.e("Res",">>>"+response);

                try {
                    JSONArray array=new JSONArray(response);

                    for (int i=0;i<array.length();i++){
                        JSONObject object=array.getJSONObject(i);
                        String index=object.getString("index");
                        String _id=object.getString("_id");
                        String name=object.getString("name");


                        color=object.getString("color");
                        String gender=object.getString("gender");
                        String age=object.getString("age");
                        String registered=object.getString("registered");
                        String email=object.getString("email");
                        String phone=object.getString("phone");
                        String address=object.getString("address");
                        String balance=object.getString("balance");

                        JSONArray array1=object.getJSONArray("friends");
                        for (int j=0;j<array1.length();j++) {
                            JSONObject object1=array1.getJSONObject(j);
                             sid = object1.getString("id");


                             sname = object1.getString("name")+",";
                        }
                        String company=object.getString("company");
                        String isActive=object.getString("isActive");



                        Log.e("Log",">>>>>"+index+sname+company);

                        Model model=new Model();
                       model.set_id(_id);
                       model.setIndex(index);
                       model.setName(name);
                       model.setColor(color);
                       model.setGender(gender);
                       model.setAge(age);
                       model.setRegistered(registered);
                       model.setEmail(email);
                       model.setPhone(phone);
                       model.setAddress(address);
                       model.setBalance(balance);
                       model.setSid(sid);
                       model.setSname(sname);
                       model.setCompany(company);
                       model.setIsActive(isActive);

                      list.add(model);

                    }

                    Base_Adapter base_adapter=new Base_Adapter(MainActivity.this,list);
                    listView.setAdapter(base_adapter);




                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                                    long id) {
                            Intent intent=new Intent(MainActivity.this,Details.class);
                            intent.putExtra("name",list.get(position).getName());
                            intent.putExtra("gender",list.get(position).getGender());
                            intent.putExtra("age",list.get(position).getAge());
                            intent.putExtra("balance",list.get(position).getBalance());
                            intent.putExtra("friend",list.get(position).getSname());
                            intent.putExtra("online",list.get(position).getIsActive());

                           startActivity(intent);


                                Toast.makeText(getBaseContext(),list.get(position).getName(), Toast.LENGTH_LONG).show();

                            }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue queue=Volley.newRequestQueue(MainActivity.this);
        queue.add(request);

    }




}
