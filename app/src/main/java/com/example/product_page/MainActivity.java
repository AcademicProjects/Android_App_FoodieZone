package com.example.product_page;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.productListOnCLickListener {

    static List<Product> AsianSQL;
    static List<Product> ItalianSQL;
    static List<Product> SweetsSQL;
    Product p;
    List<Product> mainlist;
    String List_name;
    TextView productTitle;

    String UserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle finalEmail = getIntent().getExtras();
        UserId = finalEmail.getString("UserId");

        db_class db_class= new db_class(this);
        AsianSQL = db_class.getAsianList();
        ItalianSQL = db_class.getItalianList();
        SweetsSQL = db_class.getSweetsList();

        Bundle bundle = getIntent().getExtras();
        int keyList = (int) bundle.get("list_key");
        int mainImage = (int) bundle.get("main_image");

        if(keyList == 1) {
            mainlist = AsianSQL;
            List_name = "Asian Food";
        }
        else if(keyList == 2) {
            mainlist = ItalianSQL;
            List_name = "Italian Food";
        }
        else if(keyList==3) {
            mainlist = SweetsSQL;
            List_name ="Sweets";
        }

        productTitle = (TextView) findViewById(R.id.toolBar_title);
        productTitle.setText(List_name);
        ImageView imageView = (ImageView) findViewById(R.id.italian_image);
        Glide.with(imageView)
                .load(mainImage)
                .into(imageView);


        RecyclerView asianView = (RecyclerView) findViewById(R.id.recycle_asian);
        asianView.setHasFixedSize(true);
        asianView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        ProductAdapter adapter = new ProductAdapter(mainlist, this);
        asianView.setAdapter(adapter);

        ImageButton imageButton = (ImageButton) findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onItemClick(Product product) {

        Intent intent = new Intent(MainActivity.this,DetailsPage.class);
        Bundle bundle = new Bundle();
        bundle.putString("product_details" , product.getDescription());
        bundle.putInt("product_price",product.getPrice());
        bundle.putString("producr_name",product.getName());
        bundle.putInt("product_image",product.getImageUrl());
        bundle.putInt("product_quantity",product.getQuantity());
        bundle.putString("UserId",UserId);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}