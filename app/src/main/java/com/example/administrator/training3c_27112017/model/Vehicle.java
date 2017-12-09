package com.example.administrator.training3c_27112017.model;

import android.util.Log;
import javax.inject.Inject;

/**
 * Created by Administrator on 12/09/17.
 */

public class Vehicle {

    private Motor mMotor;
    private Bike mBike;
    private static final String TAG = "Chuong";

    public Vehicle(Motor motor, Bike bike) {
        mMotor = motor;
        mBike = bike;
        Log.d(TAG, "Vehicle: ");
    }

    public String getStatusBike(){
        return mBike.getStatus();
    }

    public int getSpeedBike(){
        return mBike.getRpm();
    }

    public void inscreaseSpeedBike(int value){
        mBike.accelerate(value);
    }

    public void changeStatus(String status){
        mBike.setStatus(status);
    }

    public void stopBike(){
        mBike.brake();
    }

    public void inscreaseSpeed(int value){
        mMotor.accelerate(value);
    }

    public void stop(){
        mMotor.brake();
    }


    public int getSpeed(){
        return mMotor.getRpm();
    }
}
