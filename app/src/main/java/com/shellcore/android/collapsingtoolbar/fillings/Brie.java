package com.shellcore.android.collapsingtoolbar.fillings;

import com.shellcore.android.collapsingtoolbar.R;

/**
 * Created by Shell on 25/11/2017.
 */

public class Brie extends Cheese {

    @Override
    public String getName() {
        return "Brie";
    }

    @Override
    public int getImage() {
        return R.drawable.brie;
    }

    @Override
    public int getCal() {
        return 92;
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public float getPrice() {
        return 0.7f;
    }
}
