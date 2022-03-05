package is.gravendef.allrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class bb extends AppCompatActivity {

    ArrayList<allResto> allRestos;
    ArrayList<allResto> name;
    String nameResto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bb);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        String url0 = "http://10.0.2.2:5000/halavi";
        String url1 = "http://10.0.2.2:5000/besari";
        String url2 = "http://10.0.2.2:5000/asiati";

        String[] url = {
                "http://10.0.2.2:5000/halavi",
                "http://10.0.2.2:5000/besari",
                "http://10.0.2.2:5000/asiati"
        };
        Intent intent2 = getIntent();
        Intent intent = getIntent();
        String halavi = getIntent().getStringExtra("http://10.0.2.2:5000/halavi");
        String asiati = getIntent().getStringExtra("http://10.0.2.2:5000/asiati");

        RequestQueue queue = Volley.newRequestQueue(this);

        allRestos = allResto.createAllRestoList(0);

        // Request a string response from the provided URL.
        // int i=0;
        //        if(url[i] == "http://10.0.2.2:5000/halavi")
        //        {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url0,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONArray jsonarr = new JSONArray(response);
                            allRestoAdapter adapter = new allRestoAdapter(allRestos,name, getApplicationContext());
                            // Attach the adapter to the recyclerview to populate items
                            recyclerView.setAdapter(adapter);
                            // Set layout manager to position the items
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            for (int i = 0; i < jsonarr.length(); i++) {
                                JSONObject jsonobj = jsonarr.getJSONObject(i);
                                allRestos.add(0,new allResto(jsonobj.getString("url"),true));

                                adapter.notifyItemInserted(0);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, error -> Log.d("http error", "http error"));

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

//            RequestQueue queue1 = Volley.newRequestQueue(this);
//
//            allRestos1 = allResto.createAllRestoList(0);
//            StringRequest stringRequest1 = new StringRequest(Request.Method.GET, url1,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            // Display the first 500 characters of the response string.
//                            try {
//                                JSONArray jsonarr = new JSONArray(response);
//                                allRestoAdapter adapter = new allRestoAdapter(allRestos1, getApplicationContext());
//                                // Attach the adapter to the recyclerview to populate items
//                                recyclerView.setAdapter(adapter);
//                                // Set layout manager to position the items
//                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                                for (int i = 0; i < jsonarr.length(); i++) {
//                                    JSONObject jsonobj = jsonarr.getJSONObject(i);
//                                    allRestos1.add(0, new allResto(jsonobj.getString("url"), true));
//
//                                    adapter.notifyItemInserted(0);
//                                }
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, error -> Log.d("http error", "http error"));
//
//            // Add the request to the RequestQueue.
//            queue1.add(stringRequest1);
//        }
//

        // RequestQueue queue2 = Volley.newRequestQueue(this);

//        allRestos = allResto.createAllRestoList(0);
//        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        // Display the first 500 characters of the response string.
//                        try {
//                            JSONArray jsonarr = new JSONArray(response);
//                            allRestoAdapter adapter = new allRestoAdapter(allRestos, getApplicationContext());
//                            // Attach the adapter to the recyclerview to populate items
//                            recyclerView.setAdapter(adapter);
//                            // Set layout manager to position the items
//                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                            for (int i = 0; i < jsonarr.length(); i++) {
//                                JSONObject jsonobj = jsonarr.getJSONObject(i);
//                                allRestos.add(0, new allResto(jsonobj.getString("url"), true));
//
//                                adapter.notifyItemInserted(0);
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, error -> Log.d("http error", "http error"));
//
//        // Add the request to the RequestQueue.
//        queue2.add(stringRequest2);
//
//
//    }
    }
}
