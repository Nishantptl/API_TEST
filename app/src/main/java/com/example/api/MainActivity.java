package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //helly's ip: 192.168.123.35
    //nishi's ip: 192.168.51.236
    private static final String url = "http://192.168.51.236:9999/gettopdestination";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        ArrayList<String> destination = new ArrayList<>();

//        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//            Log.d("Response", response);
//
////                GsonBuilder builder = new GsonBuilder();
////                Gson gson = builder.create();
////                ModelDest data[] = gson.fromJson()
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
        ArrayList<ModelDest> dataList = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("Response", response.toString());
                    JSONArray array = response.getJSONArray("data");    //data array
                   Log.d("array", array.toString());
                   if(array.length()>0){
                       for(int i=0; i< array.length(); i++){
                           JSONObject myobj =  array.getJSONObject(i);
                           String id = myobj.getString("_id");
                           String Destination = myobj.getString("DestinationName");
                           Log.d("Dest", Destination);
                           String History = myobj.getString("BriefHistory");
                           String aboutPlace = myobj.getString("AboutPlace");
                           String attraction = myobj.getString("MainAttractions");
                           String url = myobj.getString("Thumbnail");
//                           URL u = myobj.getString("Thumbnail");
                           String holiday = myobj.getString("Holiday");
                           String link = myobj.getString("OfficialWebsiteLink");
                           String location = myobj.getString("Location");
                           String district = myobj.getString("District");
                           String duration = myobj.getString("DurationOfVisit");
                           String rating = myobj.getString("Rating");
                           String createdat = myobj.getString("createdAt");
//                           ArrayList<String> photos = myobj.getJSONArray("RelatedPhotos");
                           dataList.add(new ModelDest(id, Destination, aboutPlace, History, attraction, url, holiday,
                                   link, location, district, duration, rating, createdat));
                       }
                   }
                   Log.d("List", dataList.toString());
                    MyAdapter myAdapter = new MyAdapter(dataList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(myAdapter);

//                    String Id, destinationName, aboutPlace, history, attraction, thumbnaillUrl, holiday,webLink,
//                            location, district, duration, rating, createdAt;
//
//                    ArrayList<String> photos, category, season;





//
//                   GsonBuilder builder = new GsonBuilder();
//                   Gson gson = builder.create();
//                   ModelDest data[] = new ModelDest[response.getJSONArray("data").length()];
//
////                   ModelDest data[] = gson.fromJson(String.valueOf(array),ModelDest[].class);
//                   Log.d("Data", Arrays.toString(data));
//                   MyAdapter myAdapter = new MyAdapter(data);
//                   recyclerView.setAdapter(myAdapter);

//                   for(int i=0; i<=array.length(); i++){
//                       JSONObject obj = array.getJSONObject(i);
//
//                       destination.add(obj.getString("DestinationName"));
//
//                       Log.d("dest", String.valueOf(destination));
////                       JSONArray dest = obj.getJSONArray("DestinationName");
////                       Log.d("DEST", dest.toString());
//                   }
//                    JSONObject myObj = array.getJSONObject(0);
//                    Log.d("myobj",myObj.toString());
//                    JSONArray mySeason = myObj.getJSONArray("Season");
//                    Log.d("season", mySeason.toString());

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Something went wrong");
            }
        });
        requestQueue.add(jsonObjectRequest);
        MyAdapter myAdapter = new MyAdapter(dataList);
        recyclerView.setAdapter(myAdapter);
//
    }
}