package com.example.administrator.training3c_27112017.screen.LoginActivity;

import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Administrator on 12/09/17.
 */
@Singleton
@Component(modules = {LoginActivityModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivityActivity loginActivityActivity);
}
