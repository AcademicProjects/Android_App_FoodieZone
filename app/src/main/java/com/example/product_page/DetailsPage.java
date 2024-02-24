package com.example.product_page;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailsPage extends AppCompatActivity {

    ImageView productImage;
    TextView productTitle ;
    TextView ProductPrice;
    TextView ProductDiscription;
    TextView value;
    ImageView plus;
    ImageView minus;
    TextView orderNow;
    int count = 1;
    static int finalQuantity;
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle finalEmail = getIntent().getExtras();
        UserId  = finalEmail.getString("UserId");

        productImage = (ImageView) findViewById(R.id.product_image);
        ProductPrice = (TextView) findViewById(R.id.Product_price);
        ProductDiscription = (TextView) findViewById(R.id.Product_details);
        productTitle = (TextView) findViewById(R.id.toolBar_title);

        value = (TextView) findViewById(R.id.textView8);
        plus = (ImageView) findViewById(R.id.imageView3);
        minus = (ImageView) findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        finalQuantity = bundle.getInt("product_quantity");
        ProductDiscription.setText(bundle.getString("product_details"));
        ProductPrice.setText(" "+bundle.getInt("product_price")+"$");
        productTitle.setText(bundle.getString("producr_name"));
        Glide.with(productImage)
                .load(bundle.getInt("product_image"))
                .into(productImage);

        db_class dbClassOrder = new db_class(this);

        Product p = new Product(bundle.getString("producr_name"),
                bundle.getInt("product_image"),
                "String id",
                bundle.getInt("product_price"),
                bundle.getString("product_details"),
                bundle.getInt("product_quantity"),
                12);

        orderNow = (TextView) findViewById(R.id.Carttext);
        orderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               boolean flag = dbClassOrder.QuantityEmpty(p.getName());
               if(flag == false) {

                   Order newOrder = new Order(UserId,
                           p,
                           count,
                           12);

                   dbClassOrder.createnew_order(newOrder.getUser_id(),
                           newOrder.getP().getName(),
                           newOrder.getCount(),
                           newOrder.getTotal_price(),
                           newOrder.getOrderDate(),
                           newOrder.getOrderHour());

                   finalQuantity -= count;
                   count = 1;
                   value.setText("0" + count);

                   dbClassOrder.UpdateQuantity(newOrder.getP().getName(), finalQuantity);

                   Intent intent = new Intent(DetailsPage.this, Order_Page.class);
                   Bundle bundle = new Bundle();
                   bundle.putString("UserId", UserId);
                   intent.putExtras(bundle);
                   startActivity(intent);
               }else{
                   Toast.makeText(DetailsPage.this, "this Product is sold out!", Toast.LENGTH_SHORT).show();
                   count = 0;
                   value.setText("0" + count);
               }
            }
        });


        ImageButton imageButton = (ImageButton) findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count < finalQuantity){
                    count++;
                    if(count > 9)
                    value.setText(""+count);
                    else
                        value.setText("0"+count);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 1){
                    count--;
                    if(count < 10)
                    value.setText("0"+count);
                    else
                        value.setText(""+count);
                }
            }
        });


    }



}