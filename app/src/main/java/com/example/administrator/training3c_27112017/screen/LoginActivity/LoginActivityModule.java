package com.example.administrator.training3c_27112017.screen.LoginActivity;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Administrator on 12/09/17.
 */

@Module
class LoginActivityModule {

    private CallbackManager mCallbackManager;
    private LoginManager mLoginManager;
    private Activity mActivity;

    //    private AppCompatActivity mActivity;
    //
    LoginActivityModule(CallbackManager callbackManager, LoginManager loginManager,
            Activity activity) {
        mCallbackManager = callbackManager;
        mLoginManager = loginManager;
        mActivity = activity;
        Log.d("Chuong", "LoginActivityModule: ");
    }

    @Provides
    @Singleton
    LoginActivityContract.ViewModel provideViewModel(LoginActivityContract.Presenter presenter) {
        Log.d("Chuong", "provideViewModel: ");
        return new LoginActivityViewModel(presenter);
    }

    @Provides
    @Singleton
    LoginActivityContract.Presenter providePresenter() {
        Log.d("Chuong", "providePresenter: ");
        return new LoginActivityPresenter(mCallbackManager, mActivity, mLoginManager);
    }
}
