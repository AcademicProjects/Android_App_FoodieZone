package com.example.product_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HomePage extends AppCompatActivity {

    ImageView asianImage;
    ImageView italianImage;
    ImageView SweetImage;
    TextView add;
    String UserId;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Intent intent = new Intent(HomePage.this,SearchPage.class);
                Bundle b = new Bundle();
                b.putString("UserId",UserId);
                intent.putExtras(b);
                startActivity(intent);
                return true;
            case R.id.home:
                Toast.makeText(this, "Your in this page.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.listOrder:
                Intent i = new Intent(HomePage.this,Order_Page.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserId",UserId);
                i.putExtras(bundle);
                startActivity(i);
                return true;
            case R.id.logout:
                Intent r = new Intent(HomePage.this , MainActivity1.class);
                startActivity(r);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ActionBar actionBar = getSupportActionBar();

        //we should in our first run delete these comments
//        db_class db_class= new db_class(this);
//        db_class.createAsianList();
//        db_class.createItalianList();
//        db_class.createSweetsList();


        Bundle finalEmail = getIntent().getExtras();
        UserId = (String) finalEmail.getString("UserId");


        asianImage = (ImageView) findViewById(R.id.asian_View);
        italianImage = (ImageView) findViewById(R.id.italian_view);
        SweetImage = (ImageView) findViewById(R.id.sweets_view);

        asianImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("list_key", 1);
                bundle.putString("UserId",UserId);
                bundle.putInt("main_image", R.drawable.asian_view);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        italianImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("list_key", 2);
                bundle.putString("UserId",UserId);
                bundle.putInt("main_image", R.drawable.italianfoodview);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        SweetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("list_key", 3);
                bundle.putString("UserId",UserId);
                bundle.putInt("main_image", R.drawable.sweetsview);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.homepage_actionbar, menu);
        return true;
    }






}

