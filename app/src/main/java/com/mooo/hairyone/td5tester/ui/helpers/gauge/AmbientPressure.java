package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class AmbientPressure extends Td5Gauge {

    public AmbientPressure(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.intake_ambientPressure_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.intake_ambientPressure_gaugeMax);

        setGaugeName(getContext().getResources().getString(R.string.ambient_pressure_short));
        setGraduationMin(min);
        setGraduationMax(max);
        setValue(max);
        setValueDisplayFormat("%3.0f");
        setUnitText(getContext().getResources().getString(R.string.ambient_pressure_unit_short));
        setGraduationCountMajor((int) ((max - min) / 10.0f) + 1);
        setGraduationCountMinor((int) ((max - min) / 5.0f) + 1);
        setGraduationMajorFormat("%.0f");
        setGraduationMinorFormat("");
    }
}

