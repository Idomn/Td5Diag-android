package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class CylinderBalance extends Td5Gauge {
    private int mCylinderNumber = 0;

    public CylinderBalance(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.engine_cylinder_balance_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.engine_cylinder_balance_gaugeMax);

        setGaugeName(getContext().getResources().getString(R.string.cylinder_balance_short, mCylinderNumber));
        setGraduationMin(min);
        setGraduationMax(max);
        setValue(max);
        setValueDisplayFormat("%+2.0f");
        setUnitText(getContext().getResources().getString(R.string.cylinder_balance_unit));
        setGraduationCountMajor((int) ((max - min) / 5.0f) + 1);
        setGraduationCountMinor((int) ((max - min) / 2.5f) + 1);
        setGraduationMajorFormat("%.0f");
        setGraduationMinorFormat("");
        clearSections();
        section_add(min,
                getContext().getResources().getInteger(R.integer.engine_cylinder_balance_too_low),
                getContext().getResources().getColor(R.color.warning));
        section_add(getContext().getResources().getInteger(R.integer.engine_cylinder_balance_ok_low),
                getContext().getResources().getInteger(R.integer.engine_cylinder_balance_ok_high),
                getContext().getResources().getColor(R.color.valueInc_ok));
        section_add(getContext().getResources().getInteger(R.integer.engine_cylinder_balance_too_high),
                max,
                getContext().getResources().getColor(R.color.warning));
    }

    public void setCylinderNumber(int number) {
        mCylinderNumber = number;
        init();
    }
}

