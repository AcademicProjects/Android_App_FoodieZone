package com.example.product_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchPage extends AppCompatActivity {

    String UserId;
    ListView listView;
    String[] productNames = {"Asian short ribs with herb salad" ,
            "Spicy coconut noodle soup" ,
            "Fried dumplings" ,
            "Kimchi",
            "Asian prawn noodles",
            "Asian tofu with stir-fried noodles",
            "tteokbokki",
            "Italian pork patties with potato wedges",
            "Italian veggie cottage pie",
            "Classic Italian lasagne",
            "Italian kale",
            "Italian meatball & mozzarella pasta bake",
            "Sea bass & seafood Italian one-pot",
            "Prosecco cake",
            "Sweet shortcrust pastry",
            "Giant hot cookie pie",
            "Halwa",
            "Perfect pavlova",
            "Vegan custard",
            "The devil’s chocolate",
            "Cranberry & clementine polenta cake with zesty cinnamon cream"};

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search....");

        db_class db_class = new db_class(this);
        Bundle finalEmail = getIntent().getExtras();
        UserId = finalEmail.getString("UserId");

        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = db_class.getProduct(adapterView.getItemAtPosition(i).toString());
                Intent intent = new Intent(SearchPage.this,DetailsPage.class);
                Bundle bundle = new Bundle();
                bundle.putString("product_details" , p.getDescription());
                bundle.putInt("product_price",p.getPrice());
                bundle.putString("producr_name",p.getName());
                bundle.putInt("product_image",p.getImageUrl());
                bundle.putInt("product_quantity",p.getQuantity());
                bundle.putString("UserId",UserId);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search...");
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.VISIBLE);
                arrayAdapter.notifyDataSetChanged();
            }
        });



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}