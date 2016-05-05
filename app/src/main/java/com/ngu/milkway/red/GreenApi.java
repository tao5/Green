package com.ngu.milkway.red;

import com.ngu.milkway.red.mvp.model.bean.Meizi;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xt on 16/5/1.
 */
public interface GreenApi {
    @GET("data/福利/30/{page}")
    Observable<Meizi> getMeiziData(@Path("page") int page);

}


