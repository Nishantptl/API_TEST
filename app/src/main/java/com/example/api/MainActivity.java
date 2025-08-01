package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //helly's ip: 192.168.123.35
    //nishi's ip: 192.168.51.236
    private static final String url = "http://192.168.51.236:9999/getMainCategory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        ArrayList<ModelDest> dataList = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        JsonObjectRequest CategoryObject = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Check", String.valueOf(response));
                try {
                    JSONArray catArray=response.getJSONArray("data");
                    Log.d("array", String.valueOf(catArray));
                    for(int i=0; i<catArray.length(); i++){
                        JSONObject object = catArray.getJSONObject(i);
                        JSONArray sub = object.getJSONArray("subcategories");
                        Log.d("sub", String.valueOf(sub));
                        arrayList.add(new subModel(sub).toString());
                    }
                    MyAdapter myAdapter = new MyAdapter(getApplicationContext(),arrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(myAdapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Check", String.valueOf(error));
            }
        });
        requestQueue.add(CategoryObject);



//        ArrayList<String>[] cat = new ArrayList[]{new ArrayList<>()};

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    Log.d("Check", response.toString());
//                    JSONArray array = response.getJSONArray("data");    //data array
//                   Log.d("array", array.toString());
//                   if(array.length()>0){
//                       for(int i=0; i< array.length(); i++){
//                           JSONObject myobj =  array.getJSONObject(i);
//                           String id = myobj.getString("_id");
//                           String Destination = myobj.getString("DestinationName");
//                           //Log.d("Dest", Destination);
//                           String History = myobj.getString("BriefHistory");
//                           String aboutPlace = myobj.getString("AboutPlace");
//                           String attraction = myobj.getString("MainAttractions");
//
//                           String uri = myobj.getString("Thumbnail");
//                           Log.d("buri", uri);
//                           uri=uri.replace("localhost","192.168.51.236");
//                           Log.d("buri", uri);
//                           String holiday = myobj.getString("Holiday");
//                           String link = myobj.getString("OfficialWebsiteLink");
//                           String location = myobj.getString("Location");
//                           String district = myobj.getString("District");
//                           String duration = myobj.getString("DurationOfVisit");
//                           String rating = myobj.getString("Rating");
//                           String createdat = myobj.getString("createdAt");
//
//                           JSONArray category = myobj.getJSONArray("Category");
//                           cat[i] = new ArrayList((Collection) category);
//                           Log.d("cat", String.valueOf(category));
////                           for(int j=0; j< category.length(); j++){
////                               JSONObject obj = category.getJSONObject(j);
////                           }
//                           dataList.add(new ModelDest(cat[i], id, Destination, aboutPlace, History, attraction, uri, holiday,
//                                   link, location, district, duration, rating, createdat));
//                       }
//                   }
//                   //Log.d("List", dataList.toString());
//                    MyAdapter myAdapter = new MyAdapter(getApplicationContext(), dataList);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                    recyclerView.setAdapter(myAdapter);
//
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("Check", String.valueOf(error));
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
//        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),dataList);
//        recyclerView.setAdapter(myAdapter);
//
    }
}