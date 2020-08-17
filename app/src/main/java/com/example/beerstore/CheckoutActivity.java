package com.example.beerstore;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CheckoutActivity extends AppCompatActivity {
    Button btnSubmit,btnback;
    private TextView name;
    private EditText address;
    private EditText quantitiy,number;
    SharedPreferences pref;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);
        SignIn sign = new SignIn();

        btnSubmit = findViewById(R.id.btnsubmit);
        btnback = findViewById(R.id.btnback);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        number = findViewById(R.id.number);
        quantitiy = findViewById(R.id.quantity);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            name.setText(user.getEmail());
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelData md;
                try{
                    md = new ModelData(name.getText().toString(),address.getText().toString(),quantitiy.getText().toString(),number.getText().toString(),-1);
                }catch (Exception e){
                    md = new ModelData(null,null,null,null,-1);
                    Toast.makeText(CheckoutActivity.this, "failed at exception", Toast.LENGTH_SHORT).show();
                }

                DataHelper dataHelper = new DataHelper(CheckoutActivity.this);
                boolean b = dataHelper.addOne(md);
                if(b){
                    Toast.makeText(CheckoutActivity.this, "done insertion", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CheckoutActivity.this, "not done insertion", Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(CheckoutActivity.this,Thankyou.class);
                startActivity(i);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckoutActivity.this,ShopActivity.class);
                startActivity(i);
            }
        });
    }
}
