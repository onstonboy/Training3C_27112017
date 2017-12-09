package com.example.administrator.training3c_27112017.screen.profile;

import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Administrator on 12/09/17.
 */
@Singleton
@Component(modules = {ProfileModule.class})
public interface ProfileComponent {

    void inject(ProfileActivity profileActivity);
}
