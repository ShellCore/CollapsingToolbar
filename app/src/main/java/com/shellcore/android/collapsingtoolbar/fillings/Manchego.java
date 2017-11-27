package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Manchego extends Cheese {

    @Override
    public String getName() {
        return "Manchego";
    }

    @Override
    public int getImage() {
        return R.drawable.manchego;
    }

    @Override
    public int getCal() {
        return 214;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 1.7f;
    }
}
