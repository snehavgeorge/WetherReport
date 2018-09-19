package com.example.cm.wetherreport111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    TextView weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weather = (TextView)findViewById(R.id.weather);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Call<WeatherRespose> call = apiInterface.getweatherData();
        call.enqueue(new Callback<WeatherRespose>() {
            @Override
            public void onResponse(Call<WeatherRespose> call, Response<WeatherRespose> response) {
                WeatherRespose weatherRespose = response.body();
                Log.e("MainActivity","Response:::::"+new Gson().toJson(weatherRespose));
                Log.e("MainActivity","COD:::::"+weatherRespose.getCod());
                Log.e("MainActivity", "Lat:::::"+weatherRespose.getCity().getCoord().getLat());
                weather.setText("City Name : "+weatherRespose.getCity().getName()+"\n"+
                "Lat : "+weatherRespose.getCity().getCoord().getLat()+"\n"+
                "lon :"+weatherRespose.getCity().getCoord().getLon()+"\n");
            }

            @Override
            public void onFailure(Call<WeatherRespose> call, Throwable t) {
                Log.e("MainActivity","Failure:::::"+t.getMessage());
            }
        });


    }
}
