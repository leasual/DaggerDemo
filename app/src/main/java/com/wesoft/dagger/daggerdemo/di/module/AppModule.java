package com.wesoft.dagger.daggerdemo.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.wesoft.dagger.daggerdemo.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by james.li on 2018/5/7.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(App app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }
}
