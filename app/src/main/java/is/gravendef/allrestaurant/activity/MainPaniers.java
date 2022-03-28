package is.gravendef.allrestaurant.activity;

import android.os.Bundle;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

import is.gravendef.allrestaurant.R;
import is.gravendef.allrestaurant.adapter.allRestoAdapter;
import is.gravendef.allrestaurant.adapter.categoryAdapter;
import is.gravendef.allrestaurant.adapter.panierAdapter;
import is.gravendef.allrestaurant.adapter.tafritAdapter;
import is.gravendef.allrestaurant.modal.category;
import is.gravendef.allrestaurant.modal.panier;
import is.gravendef.allrestaurant.modal.tafrit;


public class MainPaniers extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static ArrayList<panier> paniers=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        panierAdapter adapter = new panierAdapter(paniers,getApplicationContext());

        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        // Request a string response from the provided URL.



    }

}




