package com.example.saif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    List<FeedModel> employeeModels=new ArrayList<>();
    private List<FeedModel> dataArrayList=new ArrayList<>();
    private FeedAdapter employeeAdapter;
    private RecyclerView recyclerView;
    private String Tag= "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.employ_recycler);
        image=(ImageView)findViewById(R.id.image);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getResponse();
    }

    private void getResponse() {


        RequestInterface api = RetrofitClient.getInstance().getApi();
        Call<List<FeedModel>> call = api.getEmpoyJson();
        call.enqueue(new Callback<List<FeedModel>>() {
            @Override
            public void onResponse(Call<List<FeedModel>> call, Response<List<FeedModel>> response)
            {

                if (response.isSuccessful()) {

                    dataArrayList=response.body();


                    employeeAdapter=new FeedAdapter(MainActivity.this,dataArrayList);
                    recyclerView.setAdapter(employeeAdapter);
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FeedModel>> call, Throwable t) {
                Log.e(Tag,"onfailure"+t.getMessage());
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}