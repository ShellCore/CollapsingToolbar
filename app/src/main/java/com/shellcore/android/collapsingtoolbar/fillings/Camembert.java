package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Camembert extends Cheese {

    @Override
    public String getName() {
        return "Camembert";
    }

    @Override
    public int getImage() {
        return R.drawable.camembert;
    }

    @Override
    public int getCal() {
        return 18;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 0.65f;
    }
}
