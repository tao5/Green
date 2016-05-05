package com.ngu.milkway.red.mvp.presenter.home.impl;

import com.ngu.milkway.red.GreenApi;
import com.ngu.milkway.red.GreenRetrofit;
import com.ngu.milkway.red.mvp.model.bean.Meizi;
import com.ngu.milkway.red.mvp.view.home.HomeView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/4/29.
 */
public class HomePresenterImpl implements com.ngu.milkway.red.mvp.presenter.home.HomePresenter {

    private HomeView mHomeView;

    public HomePresenterImpl(HomeView homeView) {
        mHomeView = checkNotNull(homeView, "HomeView can't be NULL");
        mHomeView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void prepareData() {
        GreenApi greenApi = GreenRetrofit.getInstance().getGreenApi();
        greenApi.getMeiziData(4)
                .map(new Func1<Meizi, List<Meizi.MeiziDetail>>() {
                    @Override
                    public List<Meizi.MeiziDetail> call(Meizi meizi) {
                        return meizi.getResults();
                    }
                })
                .flatMap(new Func1<List<Meizi.MeiziDetail>, Observable<Meizi.MeiziDetail>>() {
                    @Override
                    public Observable<Meizi.MeiziDetail> call(List<Meizi.MeiziDetail> resultsBeen) {
                        return Observable.from(resultsBeen);
                    }
                })
                .map(new Func1<Meizi.MeiziDetail, String>() {
                    @Override
                    public String call(Meizi.MeiziDetail meiziDetail) {
                        return meiziDetail.getUrl();
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mHomeView.showSnackbar(e.getMessage());
                    }

                    @Override
                    public void onNext(List<String> urls) {
                        mHomeView.showImageFlow(urls);
                    }
                });
    }
}

