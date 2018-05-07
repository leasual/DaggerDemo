package com.wesoft.dagger.daggerdemo.di.component;

import com.wesoft.dagger.daggerdemo.App;
import com.wesoft.dagger.daggerdemo.di.module.AppModule;
import com.wesoft.dagger.daggerdemo.di.module.BuilderModule;
import com.wesoft.dagger.daggerdemo.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by james.li on 2018/5/7.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        BuilderModule.class,
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App>{}
}
