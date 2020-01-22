package com.myproject.jsonapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

//Activity to Parse JSON Object into Java Object and Show the data in the form of Recycler View
public class TestActivity extends AppCompatActivity implements RecyclerBookAdapter.OnBookClickListener {
    private static final String TAG = "TestActivity";
    RecyclerView recyclerView;
    RecyclerBookAdapter recyclerBookAdapter;
    ProgressDialog progressDialog;
    String webServiceUrl;
    StringBuffer response;
    ArrayList<Book> bookList;
    void initViews(){
        Toolbar toolbar =  findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        //Code to implement up button i.e <-
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.recyclerViewTest);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        webServiceUrl="http://www.json-generator.com/api/json/get/chQLxhBjaW?indent=2";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initViews();
        //We can directly create the inner class object because the Test Activity's object has already been created
        //This is what happens indirectly what i think
       /* TestActivity testActivity=new TestActivity();
        fetchTask2 task2=testActivity.new fetchTask2(); */
        fetchTask2 fetchTask2=new fetchTask2();
        fetchTask2.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_send:
                //Code to implement Implicit Intent to open a dialog to select a messaging app if there are multiple available
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "A little message");
                startActivity(intent);
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBookClick(int position) {
        Toast.makeText(this,""+position,Toast.LENGTH_LONG).show();
        //Code to get Object Data
        Book book1=bookList.get(position);
        Intent intent=new Intent(TestActivity.this,SecondActivity.class);
        intent.putExtra("ObjectData",book1);
        startActivity(intent);
        Log.d("Object Data",book1.toString());
    }

    class fetchTask2 extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                URL url=new URL(webServiceUrl);

                URLConnection urlConnection=url.openConnection();

                // Read Data from WebService on Server
                InputStream inputStream=urlConnection.getInputStream();

                //To read data in the form of characters
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);

                //To read data line by line
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                String line="";
                response=new StringBuffer();
                while ((line=bufferedReader.readLine())!=null){
                    response.append(line);
                }
                Log.d(TAG, response.toString());

                JSONObject jsonObject=new JSONObject(response.toString());
                JSONArray jsonArray=jsonObject.getJSONArray("bookstore");


                bookList = new ArrayList<>();

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject jObj = jsonArray.getJSONObject(i);
                    Log.d("Json Object",jObj.toString());

                    // JSON Object is now represented as a Java Object
                    Book book = new Book();
                    book.name = jObj.getString("name");
                    book.author = jObj.getString("author");
                    book.price = jObj.getString("price");
                    //Can also be written by Using Parameterized Constructor
                  //  Book book = new Book(jObj.getString("name"),jObj.getString("author"),jObj.getString("price"));

                    bookList.add(book);
                    Log.d("Array List Value",bookList.toString());

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
            super.onPostExecute(o);
            //Adapter Code should always go in onPostExecute
            recyclerBookAdapter=new RecyclerBookAdapter(TestActivity.this,R.layout.recycler_view_item,bookList,TestActivity.this);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(TestActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerBookAdapter);
            progressDialog.dismiss();
           // Intent intent=new Intent(TestActivity.this,SecondActivity.class);
//            Bundle bundle=new Bundle();
//            bundle.putParcelableArrayList("sampleData",bookList);
            /*intent.putExtra("sampleData",bookList);
            startActivity(intent);*/
        }
    }
}
