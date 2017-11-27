package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Mozzarella extends Cheese {

    @Override
    public String getName() {
        return "Mozzarella";
    }

    @Override
    public int getImage() {
        return R.drawable.mozzarella;
    }

    @Override
    public int getCal() {
        return 273;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 0.3f;
    }
}
