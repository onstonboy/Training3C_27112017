package com.example.administrator.training3c_27112017.screen.profile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.administrator.training3c_27112017.R;
import com.example.administrator.training3c_27112017.databinding.ActivityProfileBinding;
import com.example.administrator.training3c_27112017.screen.BaseActivity;

/**
 * Profile Screen.
 */
public class ProfileActivity extends BaseActivity {

    private ProfileContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ProfileViewModel();

        ProfileContract.Presenter presenter = new ProfilePresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        binding.setViewModel((ProfileViewModel) mViewModel);
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
}
