package com.wesoft.dagger.daggerdemo.retrofit;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by james.li on 2018/5/7.
 */

public interface DaggerService {

    @GET("GetServerTime")
    public Flowable<String> getServerTime();
}
