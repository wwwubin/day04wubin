package com.example.hp.day04_retrofit.view;

import com.example.hp.day04_retrofit.http.GoodsListBean;

import java.util.List;

public interface IView {
    void showGoodsList(List<GoodsListBean.DataBean> data);
}
