package com.smabo.dany_kun.lapoulpe.entries;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.smabo.dany_kun.lapoulpe.entries.model.Card;

/**
 * Created by dany on 06/06/15.
 */
public class BooleanStateCard extends Card<Boolean> {

    private boolean trueState;

    public BooleanStateCard(@StringRes int octopusStringRes, @DrawableRes int drawableRes, boolean trueState) {
        super(trueState, octopusStringRes, drawableRes);
        this.trueState = trueState;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeByte(trueState ? (byte) 1 : (byte) 0);
    }

    protected BooleanStateCard(Parcel in) {
        super(in);
        this.trueState = in.readByte() != 0;
    }

    public static final Creator<BooleanStateCard> CREATOR = new Creator<BooleanStateCard>() {
        public BooleanStateCard createFromParcel(Parcel source) {
            return new BooleanStateCard(source);
        }

        public BooleanStateCard[] newArray(int size) {
            return new BooleanStateCard[size];
        }
    };
}
