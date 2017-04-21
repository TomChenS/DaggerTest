package com.ittest.cs.daggertest.data;

import android.app.Application;

import com.ittest.cs.daggertest.R;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by 雷神 on 2017/4/11.
 */
@Module
public class GithubApiModule {

    @Provides
    public OkHttpClient provideokHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MICROSECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MICROSECONDS);
        return okHttpClient;
    }

    @Provides
    public Retrofit provideRetrofit(Application application,OkHttpClient okHttpClient){
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(application.getString(R.string.api_github))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }

    @Provides
    protected GithubApiService provideGithubApiService(Retrofit retrofit){
        return retrofit.create(GithubApiService.class);
    }
}
