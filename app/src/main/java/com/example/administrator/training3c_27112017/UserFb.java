package com.example.administrator.training3c_27112017;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 12/09/17.
 */

public class UserFb implements Parcelable {
    private String name;
    private String id;

    public UserFb() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.id);
    }

    protected UserFb(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<UserFb> CREATOR = new Parcelable.Creator<UserFb>() {
        @Override
        public UserFb createFromParcel(Parcel source) {
            return new UserFb(source);
        }

        @Override
        public UserFb[] newArray(int size) {
            return new UserFb[size];
        }
    };
}
