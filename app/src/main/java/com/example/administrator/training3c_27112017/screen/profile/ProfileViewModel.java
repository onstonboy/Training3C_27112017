package com.example.administrator.training3c_27112017.screen.profile;

import com.example.administrator.training3c_27112017.UserFb;

/**
 * Exposes the data to be used in the Profile screen.
 */

public class ProfileViewModel implements ProfileContract.ViewModel {

    private ProfileContract.Presenter mPresenter;
    private UserFb mUserFb;

    public ProfileViewModel(ProfileContract.Presenter presenter, UserFb userFb) {
        mUserFb = userFb;
        mPresenter = presenter;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public UserFb getUserFb() {
        return mUserFb;
    }
}
