package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Gorgonzola extends Cheese {

    @Override
    public String getName() {
        return "Gorgonzola";
    }

    @Override
    public int getImage() {
        return R.drawable.gorgonzola;
    }

    @Override
    public int getCal() {
        return 462;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 0.96f;
    }
}
