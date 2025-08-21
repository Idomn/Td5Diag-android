package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class AirFuelRatio extends Td5Gauge {

    public AirFuelRatio(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.fueling_airFuelRatio_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.fueling_airFuelRatio_gaugeMax);

        setGaugeName(getContext().getResources().getString(R.string.air_fuel_ratio_short));
        setGraduationMin(min);
        setGraduationMax(max);
        setValue(max);
        setValueDisplayFormat("%2.0f:1");
        setUnitText(getContext().getResources().getString(R.string.air_fuel_ratio_unit));
        setGraduationCountMajor((int) ((max - min) / 5.0f) + 1);
        setGraduationCountMinor((int) ((max - min) / 2.5f) + 1);
        setGraduationMajorFormat("%.0f");
        setGraduationMinorFormat("");
    }
}

