package is.gravendef.allrestaurant.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import is.gravendef.allrestaurant.R;

    public class MainPanier extends AppCompatActivity {

        private LinearLayout favoriteRestaurants, favoriteFoods;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.item_panier);


            favoriteRestaurants = findViewById(R.id.favorite_restaurants);
            favoriteFoods = findViewById(R.id.favorite_foods);
        }




//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.item_bar_profil, container, false);
//        }
    }
