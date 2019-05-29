package com.example.healthtracker.backend;

public class APIUtilities {
    private APIUtilities(){}

    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static EntryService getEntryService(){
        return RetrofitFactory.getRetrofit(BASE_URL).create(EntryService.class);
    }
}
