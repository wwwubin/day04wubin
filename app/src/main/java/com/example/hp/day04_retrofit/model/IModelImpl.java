package com.example.hp.day04_retrofit.model;


import com.example.hp.day04_retrofit.http.GoodsListBean;
import com.example.hp.day04_retrofit.http.Myservice;
import com.example.hp.day04_retrofit.http.RetroFitUtil;
import com.example.hp.day04_retrofit.parsenter.IPresenter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IModelImpl implements IModel {
    private IPresenter iPresenter;
    public IModelImpl(IPresenter iPresenter){
        this.iPresenter=iPresenter;
    }
    @Override
    public void getList(String url) {
      //网络请求
        RetroFitUtil instence = RetroFitUtil.getInstence();
        Myservice request = instence.createRequest(Myservice.class);
        Call<GoodsListBean> goodsList = request.getGoodsList(2);
        goodsList.enqueue(new Callback<GoodsListBean>() {
            @Override
            public void onResponse(Call<GoodsListBean> call, Response<GoodsListBean> response) {
                GoodsListBean body = response.body();
                String code = body.getCode();
                if(code.equals("0")){
                    List<GoodsListBean.DataBean> data = body.getData();
                    iPresenter.getData(data);
                }
            }

            @Override
            public void onFailure(Call<GoodsListBean> call, Throwable t) {

            }
        });
    }
}
