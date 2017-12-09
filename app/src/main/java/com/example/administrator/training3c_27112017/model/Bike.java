package com.example.administrator.training3c_27112017.model;

import android.util.Log;
import javax.inject.Inject;

/**
 * Created by Administrator on 12/09/17.
 */

public class Bike {

    private int rpm;
    private String status;
    private static final String TAG = "Chuong";

    public Bike() {
        this.rpm = 0;
        this.status = "New";
        Log.d(TAG, "Bike: ");
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void accelerate(int value){
        rpm = rpm + value;
    }

    public void brake(){
        rpm = 0;
    }
}
