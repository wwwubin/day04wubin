package com.example.hp.day04_retrofit.parsenter;

import com.example.hp.day04_retrofit.http.GoodsListBean;
import com.example.hp.day04_retrofit.model.IModel;
import com.example.hp.day04_retrofit.view.IView;
import java.util.List;

public class IPresenterImpl implements IPresenter {
    private IView iView;
    @Override
    public void showBookToView(IModel iModel, IView iView) {
            this.iView=iView;
        iModel.getList(null);
    }

    @Override
    public void getData(List<GoodsListBean.DataBean> list) {
       iView.showGoodsList(list);
    }
}
