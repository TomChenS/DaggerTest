package com.ittest.cs.daggertest.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.ittest.cs.daggertest.AppComponent;
import com.ittest.cs.daggertest.R;
import com.ittest.cs.daggertest.data.GithubApiService;
import com.ittest.cs.daggertest.data.entity.Repo;
import com.ittest.cs.daggertest.ui.adapter.ListAdapter;
import com.ittest.cs.daggertest.utils.SimpleObserver;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by 雷神 on 2017/4/11.
 */

public class ReposListActivity extends BaseActivity {

    @Bind(R.id.repos_rv_list)
    RecyclerView mRecyclerView;

    @Bind(R.id.pbLoading)
    ProgressBar mProgressBar;



    @Inject
    GithubApiService mGithubApiService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

       ListAdapter adapter = new ListAdapter();
        mRecyclerView.setAdapter(adapter);
        loadData(adapter);

    }

    private void loadData(final ListAdapter adapter) {
        showLoading(true);
       mGithubApiService.getRepoData(getUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<ArrayList<Repo>>() {
                    @Override
                    public void onNext(ArrayList<Repo> repos) {
                        showLoading(false);
                        adapter.setRepos(repos);
                    }
                    @Override
                    public void onError(Throwable e){
                        showLoading(false);
                    }
                });
    }

    private void showLoading(boolean loading) {
        Log.i("info",loading+" Repos");
        mProgressBar.setVisibility(loading ? View.VISIBLE :View.GONE);
    }


    @Override
    protected void setupActaivtyComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repo_list;
    }

    public String getUser() {
        return "bird1015";
    }
}
