package com.ittest.cs.daggertest;

import com.ittest.cs.daggertest.data.GithubApiModule;
import com.ittest.cs.daggertest.ui.activity.ReposListActivity;

import dagger.Component;

/**
 * Created by 雷神 on 2017/4/11.
 */
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {
    // inject what
     void inject(ReposListActivity activity);
}
