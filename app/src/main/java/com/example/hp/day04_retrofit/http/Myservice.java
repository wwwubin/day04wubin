package com.example.hp.day04_retrofit.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Myservice {
    @GET("product/getProducts")
    Call<GoodsListBean> getGoodsList(@Query("pscid") int pscid);
}
