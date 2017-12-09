package com.example.administrator.training3c_27112017;

import android.app.Application;
import android.util.Log;
import com.example.administrator.training3c_27112017.component.DaggerVehicleComponent;
import com.example.administrator.training3c_27112017.component.VehicleComponent;
import com.example.administrator.training3c_27112017.module.VehicleModule;

/**
 * Created by Administrator on 12/09/17.
 */

public class MainApplication extends Application {

    public static VehicleComponent mVehicleComponent;
    private static final String TAG = "Chuong";

    @Override
    public void onCreate() {
        super.onCreate();
        mVehicleComponent =
                DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        Log.d(TAG, "onCreate: ");
    }

    public static VehicleComponent getVehicleComponent() {
        return mVehicleComponent;
    }
}
