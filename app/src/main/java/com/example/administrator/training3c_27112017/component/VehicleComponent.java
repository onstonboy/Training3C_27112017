package com.example.administrator.training3c_27112017.component;

import com.example.administrator.training3c_27112017.MainActivity;
import com.example.administrator.training3c_27112017.module.VehicleModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Administrator on 12/09/17.
 */

@Singleton
@Component(modules = { VehicleModule.class})
public interface VehicleComponent {

    void inject(MainActivity mainActivity);
}
