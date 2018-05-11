package com.example.hp.day04_retrofit.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.example.hp.day04_retrofit.R;
import com.example.hp.day04_retrofit.http.GoodsListBean;
import com.example.hp.day04_retrofit.model.IModelImpl;
import com.example.hp.day04_retrofit.parsenter.IPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        IPresenterImpl iPresenter = new IPresenterImpl();
        iPresenter.showBookToView(new IModelImpl(iPresenter),this);
    }

    @Override
    public void showGoodsList(List<GoodsListBean.DataBean> data) {
        MyAdapter myAdapter = new MyAdapter(this, data);
        list.setAdapter(myAdapter);
    }
}
