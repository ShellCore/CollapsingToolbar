package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Roquefort extends Cheese {

    @Override
    public String getName() {
        return "Roquefort";
    }

    @Override
    public int getImage() {
        return R.drawable.roquefort;
    }

    @Override
    public int getCal() {
        return 33;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 2.0f;
    }
}
