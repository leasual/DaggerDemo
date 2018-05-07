package com.wesoft.dagger.daggerdemo.di.module;

import com.google.gson.Gson;
import com.wesoft.dagger.daggerdemo.BuildConfig;
import com.wesoft.dagger.daggerdemo.App;
import com.wesoft.dagger.daggerdemo.retrofit.DaggerService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by james.li on 2018/5/7.
 */

@Module
public class NetworkModule {

    private static final int DEFAULT_TIMEOUT = 60;

    @Provides
    @Singleton
    Cache provideCache(App app) {
        int cacheSize = 10 * 1024 * 1024;//10MB
        return new Cache(app.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return BuildConfig.DEBUG? new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                : new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                //.addInterceptor(TokenInterceptor)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    DaggerService provideDaggerService(Retrofit retrofit) {
        return retrofit.create(DaggerService.class);
    }
}
