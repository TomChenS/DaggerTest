package com.ittest.cs.daggertest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ittest.cs.daggertest.AppComponent;
import com.ittest.cs.daggertest.R;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @OnClick(R.id.showButton)
    public void onShowRepositoriesClick(){
        startActivity(new Intent(this,ReposListActivity.class));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupActaivtyComponent(AppComponent appComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
