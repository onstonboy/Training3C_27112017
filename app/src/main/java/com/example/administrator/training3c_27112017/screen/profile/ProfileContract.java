package com.example.administrator.training3c_27112017.screen.profile;

import com.example.administrator.training3c_27112017.screen.BasePresenter;
import com.example.administrator.training3c_27112017.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ProfileContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {

//        void onGetDataFromIntentSuccess();
    }
}
