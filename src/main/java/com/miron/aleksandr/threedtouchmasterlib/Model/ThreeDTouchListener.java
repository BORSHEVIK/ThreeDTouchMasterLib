package com.miron.aleksandr.threedtouchmasterlib.Model;

import android.view.View;

/**
 * Created by Aleksandr on 14.05.2016.
 */
public interface ThreeDTouchListener {

    public static final float CLICK_X2_KOEF = 1.3f;
    public static final float CLICK_X3_KOEF = 1.4f;
    public static final float CLICK_X4_KOEF = 1.5f;
    public static final float CLICK_X5_KOEF = 1.6f;
    public static final float CLICK_X6_KOEF = 1.7f;
    public static final float CLICK_X7_KOEF = 1.8f;
    public static final float CLICK_X8_KOEF = 1.9f;

    public static final int NO_THREE_D_TOUCH_CLICK = 0;
    public static final int CLICK_X2 = 2;
    public static final int CLICK_X3 = 3;
    public static final int CLICK_X4 = 4;
    public static final int CLICK_X5 = 5;
    public static final int CLICK_X6 = 6;
    public static final int CLICK_X7 = 7;
    public static final int CLICK_X8 = 8;

    public static final int ALL_CLICKS_MODE = 0;
    public static final int ONLY_CLICK_X2_MODE = 2;
    public static final int ONLY_CLICK_X3_MODE = 3;
    public static final int ONLY_CLICK_X4_MODE = 4;
    public static final int ONLY_CLICK_X5_MODE = 5;
    public static final int ONLY_CLICK_X6_MODE = 6;
    public static final int ONLY_CLICK_X7_MODE = 7;
    public static final int ONLY_CLICK_X8_MODE = 8;

    void threeDTouch(ThreeDTouchEvent event, View view);

}
