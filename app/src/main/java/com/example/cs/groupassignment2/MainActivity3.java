package com.example.cs.groupassignment2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cs.groupassignment2.models.Item;
import com.example.cs.groupassignment2.models.order;
import com.example.cs.groupassignment2.models.summary;

import java.util.List;


public class MainActivity3 extends AppCompatActivity {

    order order = new order ();
   /// summary summary = new summary();
    Item item = new Item();
    Spinner availableColorsSpinner;
    Spinner availableSizesSpinner;
    NumberPicker quantityPicker ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        System.out.println(order.getOrders());

        RecyclerView recycler = findViewById(R.id.shoppingcart_recycler);

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
        CaptionedImagesAdapter2 adapter = new CaptionedImagesAdapter2(this,names, ids,prices,colors,quantities,sizes);
        recycler.setAdapter(adapter);


    }

    public void backOnClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mainpage_menu,menu);
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.items:
//                Intent intent = new Intent(this,MainActivity.class);
////                intent.putExtra("DATA2", orders);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }



    public void check_OnClick(View view) {
//        String[] names = new String[order.getOrders().size()];
//        int  quantities =  order.getOrders().size();
//
//        for(int i = 0; i<names.length;i++) {
//            names[i] = order.getOrders().get(i).getItem().getName();
//            quantities = order.getOrders().get(i).getChosenQuantity();
//        }
//        order.orders.add(new order (item,quantities));
////        System.out.println("quantityyyyyyyyyyy"+quantities);
////        System.out.println("itemmmmmm "+item);

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

        String selectedColor = availableColorsSpinner.getSelectedItem().toString();
        String selectedSize = availableSizesSpinner.getSelectedItem().toString();
        int size = Integer.parseInt(selectedSize);
        int quantity = quantityPicker.getValue();

        System.out.println(selectedColor);
        System.out.println(size);
        System.out.println(quantity);

        order.orders.add(new order (item,selectedColor,size,quantity));

        Intent intent = new Intent(this,MainActivity4.class);
        intent.putExtra("DATA3", new order (item,selectedColor,size,quantity));
//        Toast.makeText(this, "The order added successfully to the shopping cart", Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(this, MainActivity4.class);
//        intent.putExtra("DATA3", new order (item,quantities));
        startActivity(intent);
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