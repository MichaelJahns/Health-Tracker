package com.example.healthtracker.backend;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EntryService {
    @POST("entry")
    @FormUrlEncoded
    Call<Void> createEntry(
            @Field("description") String description,
            @Field("length") String length,
            @Field("mood") int mood);
}
