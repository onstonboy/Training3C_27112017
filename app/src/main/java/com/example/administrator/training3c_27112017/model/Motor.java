package com.example.administrator.training3c_27112017.model;

import android.util.Log;
import javax.inject.Inject;

/**
 * Created by Administrator on 12/09/17.
 */

public class Motor {

    private int rpm;
    private static final String TAG = "Chuong";

    public Motor() {
        this.rpm = 0;
        Log.d(TAG, "Motor: ");
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value){
        rpm = rpm + value;
    }

    public void brake(){
        rpm = 0;
    }
}
