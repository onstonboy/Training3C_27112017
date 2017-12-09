package com.example.administrator.training3c_27112017;

import android.databinding.BindingAdapter;
import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by Administrator on 12/09/17.
 */

public class BindingUtils {

    @BindingAdapter({"setSrc"})
    public static void setSrc(ProfilePictureView pictureView, String id) {
        pictureView.setProfileId(id);
    }
}
