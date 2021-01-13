package com.example.sanke.nursery_mangement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.BadParcelableException;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Backgroundask extends AsyncTask<String,Void,String>{
    AlertDialog alertDialog;
    Context ctx;
    Backgroundask(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {

        alertDialog= new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://192.168.0.106/admin/user_reg.php";
        String login_url="http://192.168.0.106/admin/user_login.php";
        String add_url="http://192.168.0.106/admin/order.php";
        String method=params[0];
        if(method.equals("Reg")) {
            String Name = params[1];
            String City = params[2];
            String Email = params[4];
            String Mob = params[3];
            String Pass = params[5];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(Name, "UTF-8") + "&" +
                        URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(City, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(Email, "UTF-8") + "&" +
                        URLEncoder.encode("mob", "UTF-8") + "=" + URLEncoder.encode(Mob, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(Pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream Is = httpURLConnection.getInputStream();
                Is.close();
                return "Registration Suceesful..";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("Login"))
        {
        String login_name=params[1];
        String login_pass=params[2];
        try
        {
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            String data = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8") + "&" +
                    URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            InputStream Is = httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(Is,"iso-8859-1"));
            String response ="";
            String line ="";
            while ((line = bufferedReader.readLine())!=null)
            {
                response+=line;
            }
            bufferedReader.close();
            Is.close();
            httpURLConnection.disconnect();
            return response;

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }
        else if(method.equals("add"))
        {
            String pid = params[1];
            String qty = params[2];
            String price = params[3];

            try {
                URL url = new URL(add_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("pid", "UTF-8") + "=" + URLEncoder.encode(pid, "UTF-8") + "&" +
                        URLEncoder.encode("qty", "UTF-8") + "=" + URLEncoder.encode(qty, "UTF-8") + "&" +

                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream Is = httpURLConnection.getInputStream();
                Is.close();
                return "Add Suceesful..";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }





    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
if(result.equals("Registration Suceesful..")) {
    Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
}
else
{

    alertDialog.setMessage(result);
    if(result.equals("Login Sucess..")) {
        Intent intent = new Intent(ctx, MainActivity.class);
//Something else
        ctx.startActivity(intent);
    }
    else
    {
    alertDialog.show();}
}
    }
}

