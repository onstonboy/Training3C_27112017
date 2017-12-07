package com.example.administrator.training3c_27112017;

import android.app.Application;
import com.example.administrator.training3c_27112017.retrofit.config.GitHubApi;
import com.example.administrator.training3c_27112017.retrofit.config.ServiceGenerators;
import com.example.administrator.training3c_27112017.roomdb.database.Database;

/**
 * Created by Administrator on 12/07/17.
 */

public class MainApplication extends Application {

    private static GitHubApi mGithubApi;
    private static Database mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = Database.initDB(this);
        if (mGithubApi == null){
            mGithubApi = ServiceGenerators.createApiService(this);
        }
    }

    public static GitHubApi getGithubApi() {
        return mGithubApi;
    }

    public static Database getDatabase() {
        return mDatabase;
    }
}