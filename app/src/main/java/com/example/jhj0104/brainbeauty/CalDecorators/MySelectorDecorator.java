package com.example.jhj0104.brainbeauty.CalDecorators;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.example.jhj0104.brainbeauty.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

/**
 * Created by jhj0104 on 2016-11-21.
 * Use a custom selector (fail)
 */
public class MySelectorDecorator implements DayViewDecorator {

    private final Drawable drawable;

    public MySelectorDecorator(Activity context) {
        drawable = context.getResources().getDrawable(R.drawable.check);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        //view.setSelectionDrawable(drawable);
        view.addSpan(new DotSpan(5, Color.parseColor("#fda5c0")));
    }
}
