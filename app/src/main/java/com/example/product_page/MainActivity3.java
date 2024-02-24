package com.example.product_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1;
    EditText e2;
    String email;
    String pass;
    String email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.db = new DatabaseHelper(this);
        Button log = (Button)this.findViewById(R.id.button1);
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                 e1 = (EditText) findViewById(R.id.editText1);
                 e2 = (EditText) findViewById(R.id.editText2);
                 email = e1.getText().toString();
                 pass = e2.getText().toString();
                 email1 = e1.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (e1.getText().toString().equals("")) {
                    e1.setError("Please Enter your Email");
                } else if (!email1.matches(emailPattern)) {
                    Toast.makeText(MainActivity3.this.getApplicationContext(), "Invalid Email Address", Toast.LENGTH_LONG).show();
                } else if (e2.getText().toString().equals("")) {
                    e2.setError("Please Enter your Passward ");
                } else if (e2.getText().toString().length() > 6) {
                    Toast.makeText(MainActivity3.this.getApplicationContext(), "Invalid Passward ", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkpass = MainActivity3.this.db.Checkpass(pass, email);
                    if (checkpass) {
                        Toast.makeText(MainActivity3.this.getApplicationContext(), "Log In Successfully ", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity3.this, HomePage.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("UserId" , email);
                        i.putExtras(bundle);
                        MainActivity3.this.startActivity(i);
                    } else {
                        Toast.makeText(MainActivity3.this.getApplicationContext(), "Log In Failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_activity3, menu);
        return true;
    }

}