package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Mahones extends Cheese {

    @Override
    public String getName() {
        return "Mahonés";
    }

    @Override
    public int getImage() {
        return R.drawable.mahones;
    }

    @Override
    public int getCal() {
        return 157;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 1.60f;
    }
}
