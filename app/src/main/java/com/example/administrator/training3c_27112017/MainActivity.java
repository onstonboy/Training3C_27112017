package com.example.administrator.training3c_27112017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.administrator.training3c_27112017.component.VehicleComponent;
import com.example.administrator.training3c_27112017.model.Bike;
import com.example.administrator.training3c_27112017.model.Vehicle;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Chuong";
    @Inject
    Vehicle mVehicle;
//    @Inject
//    Bike mBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication.getVehicleComponent().inject(this);

        mVehicle.inscreaseSpeed(500);
        mVehicle.changeStatus("OLD");
        Log.d(TAG, "onCreate: " + mVehicle.getSpeed());
        Log.d(TAG, "onCreate: " + mVehicle.getStatusBike());

//        mBike.setStatus("Fking new");
//        Log.d(TAG, "onCreate: " + mBike.getStatus());
    }
}
