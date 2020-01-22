package com.myproject.jsonapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//Extending our activity to AppCompatActivity allows us to build apps which offer backward compatibility
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button button1;
    static TextView textView1;
    String webServiceUrl;
    StringBuffer response,response2;
    ProgressDialog progressDialog;
    Toolbar toolbar;
    void initViews(){
         button1=findViewById(R.id.button1);
         textView1=findViewById(R.id.textView1);
         toolbar=findViewById(R.id.toolbar_main);
         setSupportActionBar(toolbar);
         webServiceUrl="http://www.json-generator.com/api/json/get/chQLxhBjaW?indent=2";
         progressDialog = new ProgressDialog(this);
         progressDialog.setMessage("Please Wait...");
         progressDialog.setCancelable(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchTask fetchTask=new FetchTask();
                fetchTask.execute();
                /*Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("sampleData",response2.toString());
                startActivity(intent);*/

            }
        });



    }
//Nested Class in class MainActivity
    class FetchTask extends AsyncTask{

        @Override
        //Data Fetch Operation from URL
        protected Object doInBackground(Object[] objects) {
            try {
                URL url=new URL(webServiceUrl);

                URLConnection urlConnection=url.openConnection();

                InputStream inputStream=urlConnection.getInputStream();

                //To read data byte by byte
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);

                //To read data line by line
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                String line="";
                response=new StringBuffer();
                while ((line=bufferedReader.readLine())!=null){
                    response.append(line);
                }
                Log.d(TAG,response.toString());
                //Parsing without creating Java Object and without using List View or Recycler View
                //To properly parse the data a book POJO needs to be created and the value needs to be stored
                JSONObject jsonObject=new JSONObject(response.toString());
               // Log.d("Json Object Value",jsonObject.toString());
                JSONArray jsonArray=jsonObject.getJSONArray("bookstore");
                Log.d("Json Array Value",jsonArray.toString());
                response2=new StringBuffer();
                for (int i=0;i<jsonArray.length();i++){
                     jsonObject=jsonArray.getJSONObject(i);
                     line="Name:"+jsonObject.getString("name")+"\n"
                            +"Author:"+jsonObject.getString("author")+"\n"
                            +"Price:"+jsonObject.getString("price")+"\n";
                     response2.append(line+"\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Object o) {
           // super.onPostExecute(o);
            //Without Parsing
            MainActivity.textView1.setText(response2.toString());

            progressDialog.dismiss();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_order:
                Toast.makeText(this,"Action Item Clicked",Toast.LENGTH_LONG).show();
                //Snackbar.make(findViewById(R.layout.activity_main),"Action Item Clicked",Snackbar.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }
}

