package com.example.administrator.training3c_27112017.module;

import android.util.Log;
import com.example.administrator.training3c_27112017.model.Bike;
import com.example.administrator.training3c_27112017.model.Motor;
import com.example.administrator.training3c_27112017.model.Vehicle;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Administrator on 12/09/17.
 */

@Module
public class VehicleModule {

    private static final String TAG = "Chuong";

    @Provides
    @Singleton
    Motor provideMotor() {
        Log.d(TAG, "provideMotor: ");
        return new Motor();
    }

    @Provides
    @Singleton
    Bike provideBike() {
        Log.d(TAG, "provideBike: ");
        return new Bike();
    }

    //    @Provides
    //    @Singleton
    //    Vehicle provideVehicleMotor(Motor motor, Bike bike){
    //        Log.d(TAG, "provideVehicleMotor: ");
    ////        return new Vehicle(new Motor(), new Bike());
    //        return new Vehicle(motor, bike);
    //    }

    @Provides
    @Singleton
    Vehicle provideVehicleMotor(Motor motor, Bike bike) {
        Log.d(TAG, "provideVehicleMotor: ");
        return new Vehicle(new Motor(), new Bike());
    }
}
