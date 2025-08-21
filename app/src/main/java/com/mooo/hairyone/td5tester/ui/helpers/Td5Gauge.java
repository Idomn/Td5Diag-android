package com.mooo.hairyone.td5tester.ui.helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Td5Gauge extends View {
    private String mGaugeName = "";
    private String mUnitText = "";
    private String mValueFormat = "%3.0f";
    private float mValue = 0f;
    private float mTextSize = 24f;
    private final Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private static class Section {
        float from;
        float to;
        int color;
        Section(float f, float t, int c) { from = f; to = t; color = c; }
    }
    private final List<Section> mSections = new ArrayList<>();

    public Td5Gauge(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(dpToPx(mTextSize));
    }

    private float dpToPx(float dp) {
        return dp * getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        canvas.drawText(mGaugeName, cx, cy - mTextPaint.getTextSize(), mTextPaint);
        String valueText = String.format(mValueFormat, mValue);
        if (!mUnitText.isEmpty()) {
            valueText += " " + mUnitText;
        }
        canvas.drawText(valueText, cx, cy + mTextPaint.getTextSize(), mTextPaint);
    }

    public void setGaugeName(String name) {
        mGaugeName = name;
        invalidate();
    }

    public void setGraduationMin(float v) { }
    public void setGraduationMax(float v) { }
    public void setGraduationCountMajor(int count) { }
    public void setGraduationCountMinor(int count) { }
    public void setGraduationMajorFormat(String format) { }
    public void setGraduationMinorFormat(String format) { }
    public void setDialValueRangeFactor(float factor) { }
    public void setAngles(float start, float sweep) { }

    public void setValue(float v) {
        mValue = v;
        invalidate();
    }

    public void setValueDisplayFormat(String fmt) {
        mValueFormat = fmt;
        invalidate();
    }

    public void setUnitText(String unit) {
        mUnitText = unit;
        invalidate();
    }

    public void setValueTextSize(float sizeSp) {
        mTextSize = sizeSp;
        mTextPaint.setTextSize(dpToPx(sizeSp));
        invalidate();
    }

    public void section_add(float from, float to, int color) {
        mSections.add(new Section(from, to, color));
    }

    public void clearSections() {
        mSections.clear();
    }
}

