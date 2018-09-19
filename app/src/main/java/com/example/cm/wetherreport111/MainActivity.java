package com.example.cm.wetherreport111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    ///TextView weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //weather = (TextView)findViewById(R.id.weather);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Call<List<WeatherRespose>> call = apiInterface.getweatherData();
        call.enqueue(new Callback<List<WeatherRespose>>() {
            @Override
            public void onResponse(Call<List<WeatherRespose>> call, Response<List<WeatherRespose>> response) {
                List<WeatherRespose> list = response.body();
                Log.e("DEBUG",response.body().toString());
                //weather.setText(.getString());
            }

            @Override
            public void onFailure(Call<List<WeatherRespose>> call, Throwable t) {
                Log.e("DEBUG", t.getMessage());
            }
        });


    }
}
