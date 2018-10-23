package com.example.mhm.mhm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mhm.mhm.adapter.ModelCatAdapter;
import com.example.mhm.mhm.model.ModelCat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main extends AppCompatActivity {



    private RecyclerView mRecycleView;
    private ArrayList<ModelCat> modelCatslist;
    private ModelCatAdapter modelCatAdapter;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

       modelCatslist = new ArrayList<>();


       requestQueue = Volley.newRequestQueue(this);
       
       parseJsonData();







    }

    private void parseJsonData() {


        String url = "";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("hjgjfjf");

                            for (int x =0; x<jsonArray.length(); x++ ) {


                                JSONObject hits = jsonArray.getJSONObject(x);

                                String creatorName = hits.getString("");
                                String imageLink = hits.getString("");
                                int likeCount = hits.getInt("");

                                 modelCatslist.add(new ModelCat(creatorName,imageLink,likeCount));


                            }


                            modelCatAdapter = new ModelCatAdapter(Main.this, modelCatslist);
                            mRecycleView.setAdapter(modelCatAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });




    }
}
