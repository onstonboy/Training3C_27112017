package com.example.administrator.training3c_27112017.screen.profile;

/**
 * Exposes the data to be used in the Profile screen.
 */

public class ProfileViewModel implements ProfileContract.ViewModel {

    private ProfileContract.Presenter mPresenter;

    public ProfileViewModel() {
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
}
