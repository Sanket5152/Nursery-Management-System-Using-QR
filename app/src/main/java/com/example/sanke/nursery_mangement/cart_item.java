package com.example.sanke.nursery_mangement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import static com.example.sanke.nursery_mangement.ViewItem.pid;
import static com.example.sanke.nursery_mangement.ViewItem.pname;
import static com.example.sanke.nursery_mangement.ViewItem.ppart;
import static com.example.sanke.nursery_mangement.ViewItem.pprice;

public class cart_item extends AppCompatActivity {
String id1,qua,prt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_item);


        Intent intent =getIntent();
        String name= intent.getStringExtra(pname);
        final String qty= intent.getStringExtra(ppart);
       final int id=intent.getIntExtra(pid,0);
        final double price= intent.getDoubleExtra(pprice,0.00);
        TextView p1=findViewById(R.id.tvCartItemName);
        TextView p2=findViewById(R.id.tvCartItemUnitPrice);
        TextView p3=findViewById(R.id.tvCartItemQuantity);
        TextView p4=findViewById(R.id.tvCartItemPrice);
        TextView p5=findViewById(R.id.tvTotalPrice);
        p1.setText(name);
        p2.setText(Double.toString(price));
        p3.setText(qty);
        Double t=Integer.parseInt(qty)*price;
        p4.setText(Double.toString(t));
       p5.setText(Double.toString(t));

                id1=Integer.toString(id);
                prt=Double.toString(price);
                qua=qty;



    }
    public void  add(View view)
    {


        String  method="add";
        Backgroundask backgroundask= new Backgroundask(this);
        backgroundask.execute(method,id1,prt,qua);
        finish();


    }
}
