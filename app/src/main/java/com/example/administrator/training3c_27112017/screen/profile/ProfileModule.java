package com.example.administrator.training3c_27112017.screen.profile;

import com.example.administrator.training3c_27112017.UserFb;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Administrator on 12/09/17.
 */

@Module
class ProfileModule {

    private UserFb mUserFb;
    ProfileModule(UserFb userFb) {
        mUserFb = userFb;
    }

    @Provides
    @Singleton
    UserFb provideUserFb(){
        return new UserFb();
    }

    @Singleton
    @Provides
    ProfileContract.ViewModel provideViewModel(ProfileContract.Presenter presenter){
        return new ProfileViewModel(presenter, mUserFb);
    }

    @Singleton
    @Provides
    ProfileContract.Presenter providePresenter(){
        return new ProfilePresenter();
    }
}
