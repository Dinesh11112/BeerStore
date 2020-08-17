package com.example.beerstore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ShopActivity extends AppCompatActivity  {

    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);
        check = findViewById(R.id.checkList);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user.getEmail().equals("dineshboby07@gmail.com")) {
            check.setVisibility(View.VISIBLE);
        }
        RecyclerView recyclerView = findViewById(R.id.rView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Item[] myAlchohalData = new Item[]{
                new Item("Bacardi", "50$", R.drawable.bacardi),
                new Item("BlackDeath", "70$", R.drawable.blackdeath),
                new Item("Everclear", "90$", R.drawable.everclear),
                new Item("Glenfidditch", "80$", R.drawable.glenfiddich),
                new Item("Macallan", "60$", R.drawable.macallan),
                new Item("Muskoka Wines", "50$", R.drawable.muskoka),
                new Item("Baileys", "100$", R.drawable.baileys),
                new Item("Balvini 14", "190$", R.drawable.balvenie14),
        };

        MyAlchohalAdapter myAlchohalAdapter = new MyAlchohalAdapter(myAlchohalData,ShopActivity.this);
        recyclerView.setAdapter((myAlchohalAdapter));


    }






}