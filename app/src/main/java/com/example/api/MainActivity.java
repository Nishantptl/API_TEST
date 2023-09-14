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

import java.util.ArrayList;

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


        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        ArrayList<String> destination = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("Response", response.toString());
                    JSONArray array = response.getJSONArray("data");    //data array
                   Log.d("array", array.toString());
                   for(int i=0; i<=array.length(); i++){
                       JSONObject obj = array.getJSONObject(i);

                       destination.add(obj.getString("DestinationName"));

                       Log.d("dest", String.valueOf(destination));
//                       JSONArray dest = obj.getJSONArray("DestinationName");
//                       Log.d("DEST", dest.toString());
                   }
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

    }
}