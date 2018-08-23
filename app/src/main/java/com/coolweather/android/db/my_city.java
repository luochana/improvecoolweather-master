package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

public class my_city extends DataSupport {
    private int id;
    private String my_cityname;
    //  private  int my_citycode;
    private String weatherId;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMy_citynamee() {
        return my_cityname;
    }

    public void setMy_cityname(String my_cityName) {
        this.my_cityname = my_cityName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

