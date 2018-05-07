package com.wesoft.dagger.daggerdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by james.li on 2018/5/7.
 */

public class BaseActivity extends AppCompatActivity/* implements HasSupportFragmentInjector*/ {

    @Inject
    SharedPreferences preferences;

    // support fragment injection-----start
    //@Inject
    //DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    //@Override
    //public AndroidInjector<Fragment> supportFragmentInjector() {
    //    return dispatchingAndroidInjector;
    //}
    // support fragment injection-----end

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
