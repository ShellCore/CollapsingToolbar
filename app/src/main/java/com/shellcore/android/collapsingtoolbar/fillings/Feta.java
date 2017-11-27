package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Feta extends Cheese {
    @Override
    public String getName() {
        return "Feta";
    }

    @Override
    public int getImage() {
        return R.drawable.feta;
    }

    @Override
    public int getCal() {
        return 105;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 1.2f;
    }
}
