package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Cheddar extends Cheese {
    @Override
    public String getName() {
        return "Cheddar";
    }

    @Override
    public int getImage() {
        return R.drawable.cheddar;
    }

    @Override
    public int getCal() {
        return 833;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 0.5f;
    }
}
