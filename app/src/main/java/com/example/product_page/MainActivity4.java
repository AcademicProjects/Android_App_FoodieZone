package com.example.product_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        db = new DatabaseHelper(this);
        Button reg = (Button) findViewById(R.id.button1);
        reg.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View arg0) {
                EditText e1 = (EditText)MainActivity4.this.findViewById(R.id.editText1);
                EditText e2 = (EditText)MainActivity4.this.findViewById(R.id.editText2);
                EditText e3 = (EditText)MainActivity4.this.findViewById(R.id.editText3);
                RadioButton r1 = (RadioButton)MainActivity4.this.findViewById(R.id.radioButton1);
                RadioButton r2 = (RadioButton)MainActivity4.this.findViewById(R.id.radioButton2);
                Spinner s = (Spinner)MainActivity4.this.findViewById(R.id.spinner1);
                String email1 = e2.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String user = e1.getText().toString();
                String email = e2.getText().toString();
                String pass = e3.getText().toString();
                String country = s.getSelectedItem().toString();
                if (e1.getText().toString().equals("")) {
                    e1.setError("Please Enter your Name");
                } else if (e2.getText().toString().equals("")) {
                    e2.setError("Please Enter your Email ");
                } else if (!email1.matches(emailPattern)) {
                    Toast.makeText(MainActivity4.this.getApplicationContext(), "Invalid Email Address", Toast.LENGTH_LONG).show();
                } else if (e3.getText().toString().equals("")) {
                    e3.setError("Please Enter your Passward ");
                } else if (e3.getText().toString().length() > 6) {
                    Toast.makeText(MainActivity4.this.getApplicationContext(), "Invalid Passward ", Toast.LENGTH_LONG).show();
                } else if (!r1.isChecked() && !r2.isChecked()) {
                    Toast.makeText(MainActivity4.this.getApplicationContext(), "Please Choose One of Radio Buttons ", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkEmail = MainActivity4.this.db.CheckEmail(email);
                    if (!checkEmail) {
                        String gender = null;
                        if (r1.isChecked()) {
                            gender = "female";
                        } else if (r2.isChecked()) {
                            gender = "male";
                        }

                        Boolean insert = MainActivity4.this.db.InsertData(user, email, pass, country, gender);
                        if (insert) {
                            Toast.makeText(MainActivity4.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity4.this, HomePage.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("UserId" , email);
                            i.putExtras(bundle);
                            MainActivity4.this.startActivity(i);
                        } else {
                            Toast.makeText(MainActivity4.this, "Registered Failed", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity4.this, "Email already exist", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_activity4, menu);
        return true;
    }

}