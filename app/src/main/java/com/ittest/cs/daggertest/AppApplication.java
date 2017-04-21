package com.ittest.cs.daggertest;


import android.app.Application;

import com.ittest.cs.daggertest.data.GithubApiModule;

/**
 * Created by 雷神 on 2017/4/11.
 */

public class AppApplication extends Application {
    private static AppApplication sInstance;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }

    private void setupCompoent() {
       mAppComponent = DaggerAppComponent.builder()
               .githubApiModule(new GithubApiModule())
               .appModule(new AppModule(this))
               .build();

    }

    public static AppApplication getInstance(){
        return sInstance;
    }

    public  AppComponent getAppComponent(){
        return mAppComponent;
    }

}
