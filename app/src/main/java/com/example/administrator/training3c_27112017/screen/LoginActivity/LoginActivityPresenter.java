package com.example.administrator.training3c_27112017.screen.LoginActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.administrator.training3c_27112017.Constant;
import com.example.administrator.training3c_27112017.R;
import com.example.administrator.training3c_27112017.UserFb;
import com.example.administrator.training3c_27112017.screen.profile.ProfileActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Listens to user actions from the UI ({@link LoginActivityActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class LoginActivityPresenter implements LoginActivityContract.Presenter {

    private static final String TAG = LoginActivityPresenter.class.getName();
    private CallbackManager mCallbackManager;
    private Activity mActivity;
    private LoginManager mLoginManager;
    private UserFb user;

    public LoginActivityPresenter(CallbackManager callbackManager, Activity activity,
            LoginManager loginManager) {
        mActivity = activity;
        mCallbackManager = callbackManager;
        mLoginManager = loginManager;
        Log.d("Chuong", "LoginActivityPresenter: ");
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void doLoginFacebook() {
        mLoginManager.logInWithReadPermissions(mActivity, Arrays.asList("public_profile"));
        mLoginManager.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                final GraphRequest graphRequest =
                        GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object,
                                            GraphResponse response) {
                                        Log.d("Chuong", "onCompleted: ");
                                        String id = AccessToken.getCurrentAccessToken().getUserId();
                                        doPassDataUser(response, id);
                                        doGoToProfileActivity();
                                    }
                                });
                Log.d("Chuong", "onSuccess: ");
                doPutBundleToServer(graphRequest);
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onCancel: ");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError: ");
            }
        });
    }

    private void doGoToProfileActivity() {
        mActivity.startActivity(
                new Intent(mActivity, ProfileActivity.class).putExtra(Constant.EXTRA_USERFB, user));
    }

    private void doPutBundleToServer(GraphRequest graphRequest) {
        Log.d("Chuong", "doPutBundleToServer: ");
        Bundle bundle = new Bundle();
        bundle.putString("fields", "first_name, last_name");
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
    }

    private void doPassDataUser(GraphResponse response, String id) {
        try {
            String firstname = response.getJSONObject().getString("first_name");
            String lastname = response.getJSONObject().getString("last_name");
            String fullname = firstname + " " + lastname;
            user = new UserFb();
            user.setId(id);
            user.setName(fullname);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("Chuong", "doPassDataUser: ");
    }
}
