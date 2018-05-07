package com.wesoft.dagger.daggerdemo;

import android.app.Activity;
import android.app.Application;

import com.wesoft.dagger.daggerdemo.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by james.li on 2018/5/7.
 */

public class App extends Application implements HasActivityInjector {

    // inject activity start
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
    //inject activity end

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().create(this).inject(this);
    }

}
