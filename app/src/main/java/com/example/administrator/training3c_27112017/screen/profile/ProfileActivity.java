package com.example.administrator.training3c_27112017.screen.profile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.administrator.training3c_27112017.Constant;
import com.example.administrator.training3c_27112017.R;
import com.example.administrator.training3c_27112017.UserFb;
import com.example.administrator.training3c_27112017.databinding.ActivityProfileBinding;
import com.example.administrator.training3c_27112017.screen.BaseActivity;
import javax.inject.Inject;

/**
 * Profile Screen.
 */
public class ProfileActivity extends BaseActivity {

    @Inject
    ProfileContract.ViewModel mViewModel;
    private ProfileComponent mComponent;
    @Inject
    UserFb user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = getIntent().getParcelableExtra(Constant.EXTRA_USERFB);
        mComponent =
                DaggerProfileComponent.builder().profileModule(new ProfileModule(user)).build();
        mComponent.inject(this);

        ActivityProfileBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_profile);
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
