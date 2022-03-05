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


public class MainActivity extends AppCompatActivity {

    ArrayList<allResto> allRestos;
    ArrayList<allResto> name1;
    //String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button button = findViewById(R.id.button);
            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);

            button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, bb.class);
            intent2.putExtra("http://10.0.2.2:5000/halavi", "halavi");
                this.startActivity(intent2);
                //finish();
       });
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, bb.class);
            intent.putExtra("http://10.0.2.2:5000/asiati", "asiati");
            this.startActivity(intent);
            //finish();
        });
        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, bb.class);
            this.startActivity(intent1);
            //finish();
        });

        // operations to be performed
        // when user tap on the button
//        if (button != null) {
//            button.setOnClickListener((View.OnClickListener) (new View.OnClickListener() {
//                public final void onClick(View it) {
//
//                    // displaying a toast message
//                    // Toast.makeText((Context)MainActivity.this, R.string.mess, Toast.LENGTH_LONG).show();
//                }
//            }));


        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RequestQueue queue = Volley.newRequestQueue(this);
      //  RequestQueue queue1 = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/allResto";

        allRestos = allResto.createAllRestoList(0);
        name1 = allResto.createnameList(0);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONArray jsonarr=new JSONArray(response);
                            allRestoAdapter adapter = new allRestoAdapter(allRestos,name1,getApplicationContext());
                            // Attach the adapter to the recyclerview to populate items
                            recyclerView.setAdapter(adapter);
                            // Set layout manager to position the items
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            for(int i=0 ; i<jsonarr.length();i++)
                            {
                                JSONObject jsonobj = jsonarr.getJSONObject(i);
                                allRestos.add(0,new allResto(jsonobj.getString("url"),true));
                                name1.add(0,new allResto(jsonobj.getString("name"),true));
                                //String name=jsonobj.getString("name");
                               // adapter.notifyItemInserted(0);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, error -> Log.d("http error", "http error"));

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
