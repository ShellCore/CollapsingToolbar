package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Parmesano extends Cheese {

    @Override
    public String getName() {
        return "Parmesano";
    }

    @Override
    public int getImage() {
        return R.drawable.parmesano;
    }

    @Override
    public int getCal() {
        return 311;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 1.85f;
    }
}
