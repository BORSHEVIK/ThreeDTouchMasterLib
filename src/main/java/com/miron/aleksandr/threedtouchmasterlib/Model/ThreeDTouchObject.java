package com.miron.aleksandr.threedtouchmasterlib.Model;

import android.view.MotionEvent;
import android.view.View;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Aleksandr on 14.05.2016.
 */
public class ThreeDTouchObject {

    private View mView;
    private ThreeDTouchListener mThreeDTouchListener;
    private int mColibeTime;

    private long mFirstClickTime;
    private boolean mClickDetected;
    private float mApproximateClickSize;
    private int mEventsCounter;
    private int mCurrentTouchPower;
    private LinkedList<Float> mAllSizesOfClicks;

    public ThreeDTouchObject(View view, ThreeDTouchListener listener) {
        this.mView = view;
        this.mThreeDTouchListener = listener;
        this.mColibeTime = 200;

        init();
    }

    public ThreeDTouchObject(View view, ThreeDTouchListener listener, final int colibTime) {
        this.mView = view;
        this.mThreeDTouchListener = listener;
        this.mColibeTime = colibTime;

        init();
    }

    private void init() {
        mView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mFirstClickTime = new Date().getTime();
                        setFirstParams();

                        mEventsCounter++;
                        mAllSizesOfClicks.add(event.getSize());

                        v.performClick();

                        break;

                    case MotionEvent.ACTION_MOVE:

                        if (mClickDetected) {
                            float diffKoeff = event.getSize() / mApproximateClickSize;

                            if (diffKoeff < ThreeDTouchListener.CLICK_X2_KOEF) {
                                if ((mThreeDTouchListener != null) && (mCurrentTouchPower != ThreeDTouchListener.NO_THREE_D_TOUCH_CLICK)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.NO_THREE_D_TOUCH_CLICK), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.NO_THREE_D_TOUCH_CLICK;
                            } else if ((diffKoeff >= ThreeDTouchListener.CLICK_X2_KOEF) && (diffKoeff < ThreeDTouchListener.CLICK_X3_KOEF)) {
                                if ((mThreeDTouchListener != null) && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X2)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X2), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X2;
                            } else if ((diffKoeff >= ThreeDTouchListener.CLICK_X3_KOEF) && (diffKoeff < ThreeDTouchListener.CLICK_X4_KOEF)) {
                                if (mThreeDTouchListener != null && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X3)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X3), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X3;
                            } else if ((diffKoeff >= ThreeDTouchListener.CLICK_X4_KOEF) && (diffKoeff < ThreeDTouchListener.CLICK_X5_KOEF)) {
                                if (mThreeDTouchListener != null && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X4)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X4), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X4;
                            } else if ((diffKoeff >= ThreeDTouchListener.CLICK_X5_KOEF) && (diffKoeff < ThreeDTouchListener.CLICK_X6_KOEF)) {
                                if (mThreeDTouchListener != null && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X5)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X5), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X5;
                            } else if ((diffKoeff >= ThreeDTouchListener.CLICK_X6_KOEF) && (diffKoeff < ThreeDTouchListener.CLICK_X7_KOEF)) {
                                if (mThreeDTouchListener != null && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X6)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X6), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X6;
                            } else if ((diffKoeff >= ThreeDTouchListener.CLICK_X7_KOEF) && (diffKoeff < ThreeDTouchListener.CLICK_X8_KOEF)) {
                                if (mThreeDTouchListener != null && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X7)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X7), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X7;
                            } else if (diffKoeff >= ThreeDTouchListener.CLICK_X8_KOEF) {
                                if (mThreeDTouchListener != null && (mCurrentTouchPower != ThreeDTouchListener.CLICK_X8)) {
                                    mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.CLICK_X8), mView);
                                }
                                mCurrentTouchPower = ThreeDTouchListener.CLICK_X8;
                            }
                        } else {
                            mEventsCounter++;
                            mAllSizesOfClicks.add(event.getSize());
                        }

                        if (((new Date().getTime() - mFirstClickTime) >= mColibeTime && !mClickDetected)) {
                            mClickDetected = true;

                            for (Float clickSize : mAllSizesOfClicks) {
                                mApproximateClickSize += clickSize;
                            }

                            mApproximateClickSize /= mEventsCounter;
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        if ((mThreeDTouchListener != null)) {
                            mThreeDTouchListener.threeDTouch(new ThreeDTouchEvent(ThreeDTouchListener.NO_THREE_D_TOUCH_CLICK), mView);
                        }
                        break;
                }

                return true;
            }
        });
    }

    public void setColibTime(int colibTime) {
        this.mColibeTime = colibTime;
        setFirstParams();
    }

    public void setFirstParams() {
        mClickDetected = false;
        mApproximateClickSize = 0;
        mEventsCounter = 0;
        mCurrentTouchPower = 0;
        mAllSizesOfClicks = new LinkedList<Float>();
    }

    public void removeListenr() {
        setFirstParams();
        this.mView.setOnTouchListener(null);
    }

}
