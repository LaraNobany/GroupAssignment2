package com.example.cs.groupassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cs.groupassignment2.models.order;
import com.example.cs.groupassignment2.models.summary;

public class MainActivity4 extends AppCompatActivity {

//    order order = new order();
//    summary summary = new summary();
    TextView total;
    TextView taxtotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
//        total = findViewById(R.id.total);
//        taxtotal = findViewById(R.id.taxtotal);
//
        RecyclerView recycler = findViewById(R.id.summary_recycler);

        String[] names = new String[order.getOrders().size()];
        int[] ids = new int[order.getOrders().size()];
        int[] prices = new int[order.getOrders().size()];
        String [] colors = new String [order.getOrders().size()];
        int [] sizes = new int [order.getOrders().size()];
        int [] quantities = new int [order.getOrders().size()];

        for(int i = 0; i<names.length;i++){
            names[i] = order.getOrders().get(i).getItem().getName();
            ids[i] = order.getOrders().get(i).getItem().getImageID();
            prices[i] = order.getOrders().get(i).getItem().getPrice();
            colors [i] = order.getOrders().get(i).getChosenColor();
            sizes[i] = order.getOrders().get(i).getChosenSize();
            quantities[i]=order.getOrders().get(i).getChosenQuantity();

        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter3 adapter = new CaptionedImagesAdapter3(this,names, ids,prices,colors,quantities,sizes);
        recycler.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }


}