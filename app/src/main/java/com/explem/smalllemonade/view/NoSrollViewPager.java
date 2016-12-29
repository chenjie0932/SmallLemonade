package com.explem.smalllemonade.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不能滑动的viewPager
 * Created by ${薛亚南}
 * on 2016/12/29 09：17.
 */

public class NoSrollViewPager extends ViewPager {
    public NoSrollViewPager(Context context) {
        super(context);
    }

    public NoSrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
