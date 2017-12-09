package com.example.administrator.training3c_27112017.screen.LoginActivity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.administrator.training3c_27112017.R;
import com.example.administrator.training3c_27112017.databinding.ActivityLoginactivityBinding;
import com.example.administrator.training3c_27112017.screen.BaseActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

/**
 * LoginActivity Screen.
 */
public class LoginActivityActivity extends BaseActivity {

    private LoginActivityContract.ViewModel mViewModel;
    private CallbackManager mCallbackManager;
    private LoginManager mLoginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCallbackManager = CallbackManager.Factory.create();
        mViewModel = new LoginActivityViewModel();
        mLoginManager = LoginManager.getInstance() ;
        LoginActivityContract.Presenter presenter =
                new LoginActivityPresenter(mViewModel, mCallbackManager, this, mLoginManager);
        mViewModel.setPresenter(presenter);

        ActivityLoginactivityBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_loginactivity);
        binding.setViewModel((LoginActivityViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
