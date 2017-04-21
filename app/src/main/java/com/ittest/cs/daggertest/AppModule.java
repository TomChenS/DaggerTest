package com.ittest.cs.daggertest;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 雷神 on 2017/4/11.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    public Application provideApplication(){
        return mApplication;
    }
}
