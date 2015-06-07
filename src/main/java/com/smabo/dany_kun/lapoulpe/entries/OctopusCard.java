package com.smabo.dany_kun.lapoulpe.entries;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.smabo.dany_kun.lapoulpe.R;

/**
 * Created by dany on 06/06/15.
 */
public class OctopusCard extends BooleanStateCard {

    public OctopusCard(@DrawableRes int drawableRes) {
        super(R.string.octopus, drawableRes, true);
    }

    public OctopusCard(@StringRes int octopusStringRes, @DrawableRes int drawableRes) {
        super(octopusStringRes, drawableRes, true);
    }
}
