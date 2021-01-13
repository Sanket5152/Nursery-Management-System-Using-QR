package com.example.sanke.nursery_mangement;


        import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

public class Registration extends Activity {
    EditText ET_Name,ET_City,ET_Email,ET_Mob,ET_pass;
    String Name,City,Email,Mob,Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ET_Name=(EditText)findViewById(R.id.name);
        if( ET_Name.getText().toString().length() == 0 )

            ET_Name.setError( "First name is required!" );
        else
        if ( ET_Name.getText().toString().matches("[a-zA-Z ]+") )
            ET_Name.setError( "First name is required!" );
        ET_City=(EditText)findViewById(R.id.village);
        if( ET_City.getText().toString().length() == 0 )
            ET_Name.setError( "First name is required!" );
        ET_Mob=(EditText)findViewById(R.id.mob);

        ET_Email=(EditText)findViewById(R.id.email);
        ET_pass=(EditText)findViewById(R.id.pwd);
    }
    public void  userReg(View view)
    {

        Name=ET_Name.getText().toString();
        City=ET_City.getText().toString();
        Mob=ET_Mob.getText().toString();
        Email=ET_Email.getText().toString();
        Pass=ET_pass.getText().toString();

        String  method="Reg";
        Backgroundask backgroundask= new Backgroundask(this);
        backgroundask.execute(method,Name,City,Mob,Email,Pass);
        finish();

    }

}
