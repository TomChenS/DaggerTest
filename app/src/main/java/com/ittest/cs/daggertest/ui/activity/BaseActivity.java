package com.ittest.cs.daggertest.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ittest.cs.daggertest.AppApplication;
import com.ittest.cs.daggertest.AppComponent;

import butterknife.ButterKnife;

/**
 * Created by 雷神 on 2017/4/11.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupActaivtyComponent(AppApplication.getInstance().getAppComponent());
        
    }

    protected abstract void setupActaivtyComponent(AppComponent appComponent);

    protected abstract int getLayoutId();


}
