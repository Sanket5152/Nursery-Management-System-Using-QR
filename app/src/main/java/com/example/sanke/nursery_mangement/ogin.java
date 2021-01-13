package com.example.sanke.nursery_mangement;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ogin extends Activity {
EditText Et_name,ET_pass;
String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogin);
        Et_name=(EditText)findViewById(R.id.email);
        ET_pass=(EditText)findViewById(R.id.pass);


    }
    public void userReg(View view)
    {
        startActivity(new Intent(this,Registration.class));
    }
    public void userLogin(View view)
    {
        login_name=Et_name.getText().toString();
        login_pass=ET_pass.getText().toString();

        String method="Login";
        Backgroundask backgroundask= new Backgroundask(this);
        backgroundask.execute(method,login_name,login_pass);

    }
}
