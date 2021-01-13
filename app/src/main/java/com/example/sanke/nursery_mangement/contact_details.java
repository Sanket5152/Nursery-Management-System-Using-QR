package com.example.sanke.nursery_mangement;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Spinner;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import static com.example.sanke.nursery_mangement.ViewItem.image;
        import static com.example.sanke.nursery_mangement.ViewItem.pbname;
        import static com.example.sanke.nursery_mangement.ViewItem.pfamily;
        import static com.example.sanke.nursery_mangement.ViewItem.pid;
        import static com.example.sanke.nursery_mangement.ViewItem.pmedi;
        import static com.example.sanke.nursery_mangement.ViewItem.pname;
        import static com.example.sanke.nursery_mangement.ViewItem.ppart;
        import static com.example.sanke.nursery_mangement.ViewItem.pprice;


public class contact_details extends AppCompatActivity {
    //ImageView imageView;

    EditText e1;
    private static final String[]paths = {"1", "2", "3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        Button btn=(Button)findViewById(R.id.btn);



       // imageView=(ImageView)findViewById(R.id.img);
        Intent intent =getIntent();
        String imageUrl= intent.getStringExtra(image);

        final String name= intent.getStringExtra(pname);
        String bname= intent.getStringExtra(pbname);
        String fname= intent.getStringExtra(pfamily);
            final String part= intent.getStringExtra(ppart);
        String medi= intent.getStringExtra(pmedi);
            final double price= intent.getDoubleExtra(pprice,0.00);

final  int id1=intent.getIntExtra(pid,-1);
        ImageView imageView=findViewById(R.id.img);
        TextView p1=findViewById(R.id.pname);
        TextView p2=findViewById(R.id.pbname);
        TextView p3=findViewById(R.id.pfamily);
        TextView  p4=findViewById(R.id.ppart);
        TextView p5=findViewById(R.id.pmedi);
        TextView p6=findViewById(R.id.price);
e1=(EditText)findViewById(R.id.spQuantity);
        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        p1.setText("Name:"+name);
        p2.setText("Botanical Name :"+bname);
        p3.setText("Family Name:"+fname);
        p4.setText("Plant Part:"+part);
        p5.setText("Medicanl Use:"+medi);
        p6.setText("Price: Rs."+price+"/plant");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(contact_details.this,cart_item.class);


                i.putExtra(pname, name);
                i.putExtra(pprice, price);
                i.putExtra("pid",id1);
                i.putExtra(ppart,e1.getText().toString());

                startActivity(i);

            }
        });



    }
}
