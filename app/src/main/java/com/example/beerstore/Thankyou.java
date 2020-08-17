package com.example.beerstore;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Thankyou extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thank_you);
        ListView listView = findViewById(R.id.listData);
        List<ModelData> data = getAll();
        ArrayAdapter CustomerAdapter = new ArrayAdapter<ModelData>(Thankyou.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(CustomerAdapter);
        Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelData data = (ModelData) parent.getItemAtPosition(position);
                DeleteOne(data);
                List<ModelData> edata = getAll();
                ArrayAdapter CustomerAdapter = new ArrayAdapter<ModelData>(Thankyou.this,android.R.layout.simple_list_item_1,edata);
                ListView listView = findViewById(R.id.listData);
                listView.setAdapter(CustomerAdapter);
            }
        });
    }


    public boolean DeleteOne(ModelData data){
        DataHelper DH = new DataHelper(this);
        SQLiteDatabase db = DH.getWritableDatabase();
        String query =  "DELETE FROM CUSTOMER_TABLE WHERE ID = "+ data.getId();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
            return true;
        else
            return false;
    }

    public List<ModelData> getAll(){
        List<ModelData> returnList = new ArrayList<>();
        DataHelper DH = new DataHelper(this);
        String query = "SELECT * FROM CUSTOMER_TABLE";
        SQLiteDatabase db = DH.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int Cid = cursor.getInt(0);
                String CName = cursor.getString(1);
                String CAddress = cursor.getString(2);
                String CNumber = cursor.getString(3);
                String CQuantity = cursor.getString(4);
                ModelData data = new ModelData(CName,CAddress,CQuantity,CNumber,Cid);
                returnList.add(data);
            }while(cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return returnList;
    }
}
