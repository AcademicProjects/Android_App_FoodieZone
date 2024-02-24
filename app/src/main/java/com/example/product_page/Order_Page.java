package com.example.product_page;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order_Page extends AppCompatActivity implements OrderAdapter.productListOnCLickListener {

    String UserId;


    Product p = new Product("Spicy coconut noodle soup"
            , R.drawable.spicy_coconut_noodle_soup,
            "asian",
            15,
            "Asian food needn’t be complicated – this simple soup is made in just one bowl, too",
            11,
            12);

    static List<Order> mainlist = Arrays.asList(new Order[]{
            new Order("1",
                    Product.asianList.get(1),
                    2,
                    12),
            new Order("1",
                    Product.asianList.get(2),
                    2,
                    12),
            new Order("1",
                    Product.asianList.get(3),
                    2,
                    12),

    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle finalEmail = getIntent().getExtras();
        UserId = finalEmail.getString("UserId");

        db_class dbClassOrder = new db_class(this);
        List<Order> Orderlist = dbClassOrder.getUserList(UserId);


        RecyclerView orderView = (RecyclerView) findViewById(R.id.recycle_order);
        orderView.setHasFixedSize(true);
        orderView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        OrderAdapter adapter = new OrderAdapter(Orderlist , (OrderAdapter.productListOnCLickListener) this);
        orderView.setAdapter(adapter);

        ImageButton imageButton = (ImageButton) findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onItemClick(Order product) {

    }
}