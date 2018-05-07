package com.wesoft.dagger.daggerdemo.di.module;

import com.wesoft.dagger.daggerdemo.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by james.li on 2018/5/7.
 */

@Module
public abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    // support fragment injection
    //@ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    //abstract fun mainActivity(): MainActivity
}
