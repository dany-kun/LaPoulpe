package com.smabo.dany_kun.lapoulpe.entries.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by dany on 06/06/15.
 */
public class Card<S> implements Parcelable {

    private S status;

    @StringRes
    private final int octopusStringRes;
    @DrawableRes
    private final int drawableRes;

    public Card(S status, @StringRes int octopusStringRes, @DrawableRes int drawableRes) {
        this.status = status;
        this.octopusStringRes = octopusStringRes;
        this.drawableRes = drawableRes;
    }

    public int getDrawable() {
        return drawableRes;
    }

    public int getStringRes() {
        return octopusStringRes;
    }

    public S getStatus() {
        return status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.octopusStringRes);
        dest.writeInt(this.drawableRes);
    }

    protected Card(Parcel in) {
        this.octopusStringRes = in.readInt();
        this.drawableRes = in.readInt();
    }

}
