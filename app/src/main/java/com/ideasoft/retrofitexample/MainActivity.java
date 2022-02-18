package com.ideasoft.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitInit.getRetro().create(ApiInterface.class);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        apiInterface.getData().enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                if (response.isSuccessful()){
                    List<Response> list = response.body();
                    recyclerView.setAdapter(new Adapter(MainActivity.this,list));
                }

            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {

            }
        });
    }
}