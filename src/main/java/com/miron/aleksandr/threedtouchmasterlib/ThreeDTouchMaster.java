package com.miron.aleksandr.threedtouchmasterlib;

import android.view.View;

import com.miron.aleksandr.threedtouchmasterlib.Model.ThreeDTouchListener;
import com.miron.aleksandr.threedtouchmasterlib.Model.ThreeDTouchObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 05.06.2016.
 */
public class ThreeDTouchMaster {

    private Map<View, ThreeDTouchObject> mViews = new HashMap<>();
    private ThreeDTouchListener mListener;

    public ThreeDTouchMaster(ThreeDTouchListener listener) {
        this.mListener = listener;
    }

    public void addViewForListening(View view, int colibTime) {
        mViews.put(view, new ThreeDTouchObject(view, mListener, colibTime));
    }

    public void removeViewListener(View view) {
        mViews.get(view).removeListenr();
        mViews.remove(view);
    }

    public void setColibTimeForView(View view, int colibTime) {
        mViews.get(view).setColibTime(colibTime);
    }

    public void setColibTimeForAll(int colibTime) {
        for (ThreeDTouchObject object : mViews.values()) {
            object.setColibTime(colibTime);
        }
    }

}
