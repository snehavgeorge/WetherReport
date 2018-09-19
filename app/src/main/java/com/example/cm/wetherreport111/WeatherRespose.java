package com.example.cm.wetherreport111;

import java.util.List;

public class WeatherRespose {

    public List<WeatherRespose> getDataList() {
        return dataList;
    }

    public void setDataList(List<WeatherRespose> dataList) {
        this.dataList = dataList;
    }

    List<WeatherRespose> dataList;
    public String getDaily_temp() {
        return daily_temp;
    }

    public void setDaily_temp(String daily_temp) {
        this.daily_temp = daily_temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWether_discription() {
        return wether_discription;
    }

    public void setWether_discription(String wether_discription) {
        this.wether_discription = wether_discription;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    private String daily_temp;
    private String pressure;
    private String humidity;
    private String wether_discription;
    private String rain;
}
