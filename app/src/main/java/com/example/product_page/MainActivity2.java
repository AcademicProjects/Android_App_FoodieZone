package com.example.product_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button log = (Button)this.findViewById(R.id.button1);
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity2.this, MainActivity4.class);
                MainActivity2.this.startActivity(i);
            }
        });
        Button reg = (Button)this.findViewById(R.id.button2);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                MainActivity2.this.startActivity(i);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }
}