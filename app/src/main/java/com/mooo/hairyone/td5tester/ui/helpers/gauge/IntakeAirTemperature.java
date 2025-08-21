package com.mooo.hairyone.td5tester.ui.helpers.gauge;

import android.content.Context;
import android.util.AttributeSet;

import com.mooo.hairyone.td5tester.R;
import com.mooo.hairyone.td5tester.ui.helpers.Td5Gauge;

public class IntakeAirTemperature extends Td5Gauge {

    public IntakeAirTemperature(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        int min = getContext().getResources().getInteger(R.integer.intake_inletAirTemperature_gaugeMin);
        int max = getContext().getResources().getInteger(R.integer.intake_inletAirTemperature_gaugeMax);

        setGaugeName(getContext().getResources().getString(R.string.intake_air_temperature_short));
        setGraduationMin(min);
        setGraduationMax(max);
        setValue(max);
        setValueDisplayFormat("%3.1f");
        setUnitText(getContext().getResources().getString(R.string.intake_air_temperature_unit_short));
        setGraduationCountMajor((int) ((max - min) / 20.0f) + 1);
        setGraduationCountMinor((int) ((max - min) / 10.0f) + 1);
        setGraduationMajorFormat("%.0f");
        setGraduationMinorFormat("");
        section_add(min,
                getContext().getResources().getInteger(R.integer.intake_inletAirTemperature_cold),
                getContext().getResources().getColor(R.color.valueInc_low));
        section_add(getContext().getResources().getInteger(R.integer.intake_inletAirTemperature_hot),
                max,
                getContext().getResources().getColor(R.color.valueInc_high));
    }
}

