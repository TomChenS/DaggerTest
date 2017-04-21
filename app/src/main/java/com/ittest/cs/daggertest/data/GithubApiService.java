package com.ittest.cs.daggertest.data;

import com.ittest.cs.daggertest.data.entity.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by 雷神 on 2017/4/11.
 */

public interface GithubApiService {
    @GET("/user/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}
