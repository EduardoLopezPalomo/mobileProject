package com.example.myapplication2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.widget.Button;
import android.widget.RatingBar;

public class ChangeColor {
    public static void changeColorRating(Resources resources, RatingBar rating){
        int currentNightMode = resources.getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
            int customColor = resources.getColor(R.color.light_primary_color);
            LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(customColor, PorterDuff.Mode.SRC_ATOP);
        }else{
            int customColor = resources.getColor(R.color.dark_primary_color);
            LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(customColor, PorterDuff.Mode.SRC_ATOP);
        }
    }

}
